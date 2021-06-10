(ns owoify-clj.utility.utility)

(defn interleave-arrays
  "Helper function to interleave and combine a sequence of strings and a sequence of spaces."
  [a b]
  (loop [result '()
         arr a
         other b
         round 0]
    (if (= (rem round 2) 0)
      (if (empty? arr)
        (if-not (empty? other)
          (concat other result)
          result)
        (recur (cons (first arr) result) (rest arr) other (+ round 1)))
      (if (empty? other)
        result
        (recur (cons (first other) result) arr (rest other) (+ round 1))))))