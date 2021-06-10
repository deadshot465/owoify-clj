(ns owoify-clj.structures.word)

(defrecord Word [word replaced-words])

(defn contains-replaced-words?
  "Check if the replaced words already contains the replacing result. For internal use."
  [word search-value replace-value]
  (some (fn [w]
          (if-not (nil? (re-find search-value w))
            (let [match-result (-> (re-find search-value w)
                                   (clojure.string/replace w replace-value))]
              (= match-result replace-value)) false))
        (.replaced_words word)))

(defn inner-replace
  "Replace all matched items with a string. For internal use.
  This function is the actual invoked function regardless of the caller passing `replace-replaced-words` or not.
  If the caller doesn't pass the last argument, `false` is passed."
  [word search-value replace-value replace-replaced-words]
  (if (and (not replace-replaced-words) (contains-replaced-words? word search-value replace-value))
    word
    (let [replacing-word (if-not (nil? (re-find search-value (.word word)))
                           (clojure.string/replace (.word word) search-value replace-value)
                           (.word word))]
      (let [collection (->> (re-seq search-value (.word word))
                            (flatten))]
        (let [replaced-words (if-not (empty? collection)
                               (map (fn [x] (clojure.string/replace x x replace-value)) collection)
                               '())]
          (let [new-replaced-words (if-not (= replacing-word (.word word))
                                     (->> (concat (.replaced_words word) replaced-words)
                                          (dedupe))
                                     (.replaced_words word))]
            (let [new-word (if-not (= replacing-word (.word word))
                             replacing-word
                             (.word word))]
              (Word. new-word new-replaced-words))))))))

(defn replace
  "Replace all matched items with a string. For internal use."
  ([word search-value replace-value] (inner-replace word search-value replace-value false))
  ([word search-value replace-value replace-replaced-words] (inner-replace word search-value replace-value replace-replaced-words)))

(defn inner-replace-single
  "Replace all matched items by repeatedly invoking a function. For internal use.
  `f` should be a function of no arguments.
  This function is the actual invoked function regardless of the caller passing `replace-replaced-words` or not.
  If the caller doesn't pass the last argument, `false` is passed."
  [word search-value f replace-replaced-words]
  (let [replace-value (f)]
    (if (and (not replace-replaced-words) (contains-replaced-words? word search-value replace-value))
      word
      (let [replacing-word (if-not (nil? (re-find search-value (.word word)))
                             (let [match (-> (re-seq search-value (.word word))
                                              (nth 0))]
                               (clojure.string/replace (.word word) match replace-value))
                             (.word word))]
        (let [collection (->> (re-seq search-value (.word word))
                              (flatten))]
          (let [replaced-words (if-not (empty? collection)
                                 (map (fn [x] (clojure.string/replace x x replace-value)) collection)
                                 '())]
            (let [new-replaced-words (if-not (= replacing-word (.word word))
                                       (->> (concat (.replaced_words word) replaced-words)
                                            (dedupe))
                                       (.replaced_words word))]
              (let [new-word (if-not (= replacing-word (.word word))
                               replacing-word
                               (.word word))]
                (Word. new-word new-replaced-words)))))))))

(defn replace-single
  "Replace all matched items by repeatedly invoking a function. For internal use.
  `f` should be a function of no arguments."
  ([word search-value f] (inner-replace-single word search-value f false))
  ([word search-value f replace-replaced-words] (inner-replace-single word search-value f replace-replaced-words)))

(defn inner-replace-multiple
  "Replace all matched items by repeatedly invoking a function. For internal use.
  `f` should be a function of two arguments.
  This function is the actual invoked function regardless of the caller passing `replace-replaced-words` or not.
  If the caller doesn't pass the last argument, `false` is passed."
  [word search-value f replace-replaced-words]
  (if (nil? (re-find search-value (.word word)))
    word
    (let [inner-word (.word word)]
      (let [captures (-> (re-seq search-value inner-word)
                         (flatten))]
        (let [replace-value (f (nth captures 1) (nth captures 2))]
          (if (and (not replace-replaced-words) (contains-replaced-words? word search-value replace-value))
            word
            (let [replacing-word (clojure.string/replace (.word word) (nth captures 0) replace-value)]
              (let [collection (->> (re-seq search-value (.word word))
                                    (flatten))]
                (let [replaced-words (if-not (empty? collection)
                                        (map (fn [x] (clojure.string/replace x x replace-value)) collection)
                                        '())]
                  (let [new-replaced-words (if-not (= replacing-word (.word word))
                                             (->> (concat (.replaced_words word) replaced-words)
                                                  (dedupe))
                                             (.replaced_words word))]
                    (let [new-word (if-not (= replacing-word (.word word))
                                     replacing-word
                                     (.word word))]
                      (Word. new-word new-replaced-words))))))))))))

(defn replace-multiple
  "Replace all matched items by repeatedly invoking a function. For internal use.
  `f` should be a function of two arguments."
  ([word search-value f] (inner-replace-multiple word search-value f false))
  ([word search-value f replace-replaced-words] (inner-replace-multiple word search-value f replace-replaced-words)))