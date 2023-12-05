(ns owoify-clj.utility.presets
  (:require [owoify-clj.utility.mappings :as mappings]))

(def specific-word-mapping-list [mappings/map-fuc-to-fwuc
                                 mappings/map-mom-to-mwom
                                 mappings/map-time-to-tim
                                 mappings/map-me-to-mwe
                                 mappings/map-over-to-owor
                                 mappings/map-ove-to-uv
                                 mappings/map-haha-to-hehe-xd
                                 mappings/map-the-to-teh
                                 mappings/map-you-to-u
                                 mappings/map-read-to-wead
                                 mappings/map-worse-to-wose
                                 mappings/map-great-to-gwate
                                 mappings/map-aviat-to-awiat
                                 mappings/map-dedicat-to-deditat
                                 mappings/map-remember-to-rember
                                 mappings/map-when-to-wen
                                 mappings/map-frightened-to-frigten
                                 mappings/map-meme-to-mem
                                 mappings/map-feel-to-fell])

(def uvu-mapping-list [mappings/map-o-to-owo
                       mappings/map-ew-to-uwu
                       mappings/map-hey-to-hay
                       mappings/map-dead-to-ded
                       mappings/map-n-vowel-t-to-nd])

(def uwu-mapping-list [mappings/map-brackets-to-star-trails
                       mappings/map-period-comma-exclamation-semicolon-to-kaomojis
                       mappings/map-that-to-dat
                       mappings/map-th-to-f
                       mappings/map-le-to-wal
                       mappings/map-ve-to-we
                       mappings/map-ry-to-wwy
                       mappings/map-r-or-l-to-w])

(def owo-mappings-list [mappings/map-n-vowel-to-ny
                        mappings/map-ll-to-ww
                        mappings/map-vowel-or-r-except-o-l-to-wl
                        mappings/map-old-to-owld
                        mappings/map-ol-to-owl
                        mappings/map-l-or-r-o-to-wo
                        mappings/map-specific-consonants-o-to-letter-and-wo
                        mappings/map-v-or-w-le-to-wal
                        mappings/map-fi-to-fwi
                        mappings/map-ver-to-wer
                        mappings/map-poi-to-pwoi
                        mappings/map-specific-consonants-le-to-letter-and-wal
                        mappings/map-consonant-r-to-consonant-w
                        mappings/map-ly-to-wy
                        mappings/map-ple-to-pwe
                        mappings/map-nr-to-nw
                        mappings/map-mem-to-mwem
                        mappings/unmap-nywo-to-nyo])