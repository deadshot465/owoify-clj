(ns owoify-clj.core-test
  (:require [clojure.test :refer :all]
            [owoify-clj.core :refer :all]))

(def source "This is the string to owo! Kinda cute isn't it?")
(def pokemon-name-list-path "assets/pokemons.txt")
(def war-and-peace-path "assets/war_and_peace_chapter01-20.txt")

(deftest owoify-test
  (testing "owoify with owo level"
    (let [result (owoify-clj.core/owoify source "owo")]
      (println result)
      (is (> (.length result) 0))
      (is (not (nil? result)))))

  (testing "owoify with uwu level"
    (let [result (owoify-clj.core/owoify source "uwu")]
      (println result)
      (is (> (.length result) 0))
      (is (not (nil? result)))))

  (testing "owoify with uvu level"
    (let [result (owoify-clj.core/owoify source "uvu")]
      (println result)
      (is (> (.length result) 0))
      (is (not (nil? result)))))

  (testing "owoify using uwuify"
    (let [result (owoify-clj.core/uwuify source)]
      (println result)
      (is (> (.length result) 0))
      (is (not (nil? result)))
      (is (not (= result source)))))

  (testing "owoify using uvuify"
    (let [result (owoify-clj.core/uvuify source)]
      (println result)
      (is (> (.length result) 0))
      (is (not (nil? result)))
      (is (not (= result source)))))

  (testing "owofied string is not equal to the source string"
    (let [result (owoify-clj.core/owoify source "owo")]
      (is (not (= result source)))))

  (testing "raise error when the specified error is undefined"
    (is (thrown-with-msg? IllegalArgumentException #"The specified owoify level is not supported." (owoify-clj.core/owoify source "123"))))

  (testing "owo is not equal to uwu"
    (let [result-1 (owoify-clj.core/owoify source "owo")
          result-2 (owoify-clj.core/owoify source "uwu")]
      (is (not (= result-1 result-2)))))

  (testing "owo is not equal to uvu"
    (let [result-1 (owoify-clj.core/owoify source "owo")
          result-2 (owoify-clj.core/owoify source "uvu")]
      (is (not (= result-1 result-2)))))

  (testing "uwu is not equal to uvu"
    (let [result-1 (owoify-clj.core/owoify source "uwu")
          result-2 (owoify-clj.core/owoify source "uvu")]
      (is (not (= result-1 result-2)))))

  (testing "owoify pokemon names"
    (let [texts (-> (slurp pokemon-name-list-path)
                     (clojure.string/trim)
                     (clojure.string/split-lines))]
      (doall (map (fn [name]
                    (let [name-with-owo (owoify-clj.core/owoify name "owo")
                          name-with-uwu (owoify-clj.core/owoify name "uwu")
                          name-with-uvu (owoify-clj.core/owoify name "uvu")]
                      (is (> (.length name-with-owo) 0))
                      (is (> (.length name-with-uwu) 0))
                      (is (> (.length name-with-uvu) 0))
                      (is (not (nil? name-with-owo)))
                      (is (not (nil? name-with-uwu)))
                      (is (not (nil? name-with-uvu))))) texts))))

  (testing "owoify long text"
    (let [texts (slurp war-and-peace-path)]
      (let [text-with-owo (owoify-clj.core/owoify texts "owo")
            text-with-uwu (owoify-clj.core/owoify texts "uwu")
            text-with-uvu (owoify-clj.core/owoify texts "uvu")]
        (is (> (.length text-with-owo) 0))
        (is (> (.length text-with-uwu) 0))
        (is (> (.length text-with-uvu) 0))
        (is (not (nil? text-with-owo)))
        (is (not (nil? text-with-uwu)))
        (is (not (nil? text-with-uvu)))))))