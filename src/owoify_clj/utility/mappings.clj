(ns owoify-clj.utility.mappings
  (:require [owoify-clj.structures.word :as word]))


(def o-to-owo #"o")
(def ew-to-uwu #"ew")
(def hey-to-hay #"([Hh])ey")
(def dead-to-ded-upper #"Dead")
(def dead-to-ded-lower #"dead")
(def n-vowel-t-to-nd #"n[aeiou]*t")
(def read-to-wead-upper #"Read")
(def read-to-wead-lower #"read")
(def brackets-to-star-trails-front #"[({<]")
(def brackets-to-star-trails-back #"[)}>]")
(def period-comma-exclamation-semicolon-to-kaomojis_first #"[.,](?![0-9])")
(def period-comma-exclamation-semicolon-to-kaomojis_second #"[!;]+")
(def that-to-dat-upper #"That")
(def that-to-dat-lower #"that")
(def th-to-f-upper #"TH(?!E)")
(def th-to-f-lower #"[Tt]h(?![Ee])")
(def le-to-wal #"le$")
(def ve-to-we-upper #"Ve")
(def ve-to-we-lower #"ve")
(def ry-to-wwy #"ry")
(def rorl-to-w-upper #"(?:R|L)")
(def rorl-to-w-lower #"(?:r|l)")
(def ll-to-ww #"ll")
(def vowel-or-r-except-o-l-to-wl-upper #"[AEIUR]([lL])$")
(def vowel-or-r-except-o-l-to-wl-lower #"[aeiur]l$")
(def old-to-owld-upper #"OLD")
(def old-to-owld-lower #"([Oo])ld")
(def ol-to-owl-upper #"OL")
(def ol-to-owl-lower #"([Oo])l")
(def lorr-o-to-wo-upper #"[LR]([oO])")
(def lorr-o-to-wo-lower #"[lr]o")
(def specific-consonants-o-to-letter-and-wo-upper #"([BCDFGHJKMNPQSTXYZ])([oO])")
(def specific-consonants-o-to-letter-and-wo-lower #"([bcdfghjkmnpqstxyz])o")
(def vorw-le-to-wal #"[vw]le")
(def fi-to-fwi-upper #"FI")
(def fi-to-fwi-lower #"([Ff])i")
(def ver-to-wer #"([Vv])er")
(def poi-to-pwoi #"([Pp])oi")
(def specific-consonants-le-to-letter-and-wal #"([DdFfGgHhJjPpQqRrSsTtXxYyZz])le$")
(def consonant-r-to-consonant-w #"([BbCcDdFfGgKkPpQqSsTtWwXxZz])r")
(def ly-to-wy-upper #"Ly")
(def ly-to-wy-lower #"ly")
(def ple-to-pwe #"([Pp])le")
(def nr-to-nw-upper #"NR")
(def nr-to-nw-lower #"nr")
(def fuc-to-fwuc #"([Ff])uc")
(def mom-to-mwom #"([Mm])om")
(def me-to-mwe #"([Mm])e")
(def n-vowel-to-ny-first #"n([aeiou])")
(def n-vowel-to-ny-second #"N([aeiou])")
(def n-vowel-to-ny-third #"N([AEIOU])")
(def ove-to-uv-upper #"OVE")
(def ove-to-uv-lower #"ove")
(def haha-to-hehe-xd #"\\b(ha|hah|heh|hehe)+\\b")
(def the-to-teh #"\\b([Tt])he\\b")
(def you-to-u-upper #"\\bYou\\b")
(def you-to-u-lower #"\\byou\\b")
(def time-to-tim #"\\b([Tt])ime\\b")
(def over-to-owor #"([Oo])ver")
(def worse-to-wose #"([Ww])orse")
(def faces ["(・`ω´・)" ";;w;;" "owo" "UwU" ">w<" "^w^" "(* ^ ω ^)" "(⌒ω⌒)" "ヽ(*・ω・)ﾉ" "(o´∀`o)"
            "(o･ω･o)" "＼(＾▽＾)／" "(*^ω^)" "(◕‿◕✿)" "(◕ᴥ◕)" "ʕ•ᴥ•ʔ" "ʕ￫ᴥ￩ʔ" "(*^.^*)" "(｡♥‿♥｡)"
            "OwO" "uwu" "uvu" "UvU" "(*￣з￣)" "(つ✧ω✧)つ" "(/ =ω=)/" "(╯°□°）╯︵ ┻━┻"
            "┬─┬ ノ( ゜-゜ノ)" "¯\\_(ツ)_/¯"])

(defn map-o-to-owo [input]
  (let [replacement (if (> (rand-int 2) 0)
                      "owo"
                      "o")]
    (word/replace input o-to-owo replacement)))

(defn map-ew-to-uwu [input] (word/replace input ew-to-uwu "uwu"))
(defn map-hey-to-hay [input] (word/replace input hey-to-hay "$1ay"))
(defn map-dead-to-ded [input] (-> (word/replace input dead-to-ded-upper "Ded")
                                  (word/replace dead-to-ded-lower "ded")))
(defn map-n-vowel-t-to-nd [input] (word/replace input n-vowel-t-to-nd "nd"))
(defn map-read-to-wead [input] (-> (word/replace input read-to-wead-upper "Wead")
                                   (word/replace read-to-wead-lower "wead")))
(defn map-brackets-to-star-trails [input] (-> (word/replace input brackets-to-star-trails-front "｡･:*:･ﾟ★,｡･:*:･ﾟ☆")
                                              (word/replace brackets-to-star-trails-back "☆ﾟ･:*:･｡,★ﾟ･:*:･｡")))

(defn map-period-comma-exclamation-semicolon-to-kaomojis [input]
  (-> (word/replace-single input period-comma-exclamation-semicolon-to-kaomojis_first (fn [] (rand-nth faces)))
      (word/replace-single period-comma-exclamation-semicolon-to-kaomojis_second (fn [] (rand-nth faces)))))

(defn map-that-to-dat [input] (-> (word/replace input that-to-dat-lower "dat")
                                  (word/replace that-to-dat-upper "Dat")))
(defn map-th-to-f [input] (-> (word/replace input th-to-f-lower "f")
                              (word/replace th-to-f-upper "F")))
(defn map-le-to-wal [input] (word/replace input le-to-wal "wal"))
(defn map-ve-to-we [input] (-> (word/replace input ve-to-we-lower "we")
                               (word/replace ve-to-we-upper "We")))
(defn map-ry-to-wwy [input] (word/replace input ry-to-wwy "wwy"))
(defn map-r-or-l-to-w [input] (-> (word/replace input rorl-to-w-lower "w")
                                  (word/replace rorl-to-w-upper "W")))
(defn map-ll-to-ww [input] (word/replace input ll-to-ww "ww"))
(defn map-vowel-or-r-except-o-l-to-wl [input]
  (-> (word/replace input vowel-or-r-except-o-l-to-wl-lower "wl")
      (word/replace vowel-or-r-except-o-l-to-wl-upper "W$1")))
(defn map-old-to-owld [input] (-> (word/replace input old-to-owld-lower "$1wld")
                                  (word/replace old-to-owld-upper "OWLD")))
(defn map-ol-to-owl [input] (-> (word/replace input ol-to-owl-lower "$1wl")
                                (word/replace ol-to-owl-upper "OWL")))
(defn map-l-or-r-o-to-wo [input] (-> (word/replace input lorr-o-to-wo-lower "wo")
                                     (word/replace lorr-o-to-wo-upper "W$1")))

(defn map-specific-consonants-o-to-letter-and-wo [input]
  (-> (word/replace input specific-consonants-o-to-letter-and-wo-lower "$1wo")
      (word/replace-multiple specific-consonants-o-to-letter-and-wo-upper (fn [s1 s2]
                                                                            (let [msg s1]
                                                                              (let [msg_ (if (= (.toUpperCase s2) s2)
                                                                                           (str msg "W")
                                                                                           (str msg "w"))]
                                                                                (str msg_ s2)))))))

(defn map-v-or-w-le-to-wal [input] (word/replace input vorw-le-to-wal "wal"))
(defn map-fi-to-fwi [input] (-> (word/replace input fi-to-fwi-lower "$1wi")
                                (word/replace fi-to-fwi-upper "FWI")))
(defn map-ver-to-wer [input] (word/replace input ver-to-wer "wer"))
(defn map-poi-to-pwoi [input] (word/replace input poi-to-pwoi "$1owi"))
(defn map-specific-consonants-le-to-letter-and-wal [input]
  (word/replace input specific-consonants-le-to-letter-and-wal "$1wal"))
(defn map-consonant-r-to-consonant-w [input]
  (word/replace input consonant-r-to-consonant-w "$1w"))
(defn map-ly-to-wy [input] (-> (word/replace input ly-to-wy-lower "wy")
                               (word/replace ly-to-wy-upper "Wy")))
(defn map-ple-to-pwe [input] (word/replace input ple-to-pwe "$1we"))
(defn map-nr-to-nw [input] (-> (word/replace input nr-to-nw-lower "nw")
                               (word/replace nr-to-nw-upper "NW")))
(defn map-fuc-to-fwuc [input] (word/replace input fuc-to-fwuc "$1wuc"))
(defn map-mom-to-mwom [input] (word/replace input mom-to-mwom "$1wom"))
(defn map-me-to-mwe [input] (word/replace input me-to-mwe "$1we"))
(defn map-n-vowel-to-ny [input]
  (-> (word/replace input n-vowel-to-ny-first "ny$1")
      (word/replace n-vowel-to-ny-second "Ny$1")
      (word/replace n-vowel-to-ny-third "NY$1")))
(defn map-ove-to-uv [input] (-> (word/replace input ove-to-uv-lower "uv")
                                (word/replace ove-to-uv-upper "UV")))
(defn map-haha-to-hehe-xd [input] (word/replace input haha-to-hehe-xd "hehe xD"))
(defn map-the-to-teh [input] (word/replace input the-to-teh "$1eh"))
(defn map-you-to-u [input] (-> (word/replace input you-to-u-lower "U")
                               (word/replace you-to-u-upper "u")))
(defn map-time-to-tim [input] (word/replace input time-to-tim "$1im"))
(defn map-over-to-owor [input] (word/replace input over-to-owor "$1wor"))
(defn map-worse-to-wose [input] (word/replace input worse-to-wose "$1ose"))