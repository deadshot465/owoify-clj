(ns owoify-clj.core
  (:require [owoify-clj.structures.word :refer :all])
  (:require [owoify-clj.utility.presets :as presets :refer :all])
  (:require [owoify-clj.utility.utility :as utility])
  (:require [owoify-clj.structures.word :as word]))

(defn owoify
  "The main entry point of `owoify-clj`.

  Currently, there are three levels (owoness) available, from the lightest to the heaviest: owo, uwu, uvu.
  `source` is the source string, while `level` is the specified owoness level."
  [source level]
  (let [words (->> (re-seq #"[^\s]+" source)
                   (flatten)
                   (map (fn [x] (word/->Word x '()))))
        spaces (->> (re-seq #"\s+" source)
                    (flatten)
                    (map (fn [x] (word/->Word x '()))))
        actual-level (.toLowerCase level)]
    (let [inner-words (map (fn [word] (reduce (fn [w f] (f w)) word presets/specific-word-mapping-list)) words)]
      (let [inner-words (cond (= actual-level "owo")
                              (map (fn [word] (reduce (fn [w f] (f w)) word presets/owo-mappings-list)) inner-words)
                              (= actual-level "uwu")
                              (->> (map (fn [word] (reduce (fn [w f] (f w)) word presets/uwu-mapping-list)) inner-words)
                                   (map (fn [word] (reduce (fn [w f] (f w)) word presets/owo-mappings-list))))
                              (= actual-level "uvu")
                              (->> (map (fn [word] (reduce (fn [w f] (f w)) word presets/uvu-mapping-list)) inner-words)
                                   (map (fn [word] (reduce (fn [w f] (f w)) word presets/uwu-mapping-list)))
                                   (map (fn [word] (reduce (fn [w f] (f w)) word presets/owo-mappings-list))))
                              :else (throw (IllegalArgumentException. "The specified owoify level is not supported.")))]
        (->> (utility/interleave-arrays inner-words spaces)
             (map (fn [w] (.word w)))
             (reverse)
             (clojure.string/join)
             (clojure.string/trim))))))

(defn uwuify
  "Owoifies the `source` string using uwu owoness level."
  [source]
  (owoify source "uwu"))

(defn uvuify
  "Owoifies the `source` string using uvu owoness level."
  [source]
  (owoify source "uvu"))