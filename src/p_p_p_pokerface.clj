(ns p-p-p-pokerface)

(defn rank [card]
  (let [[rank _] card]
    (def replacements {\A 14, \K 13, \Q 12, \J 11, \T 10 })
    (if (Character/isDigit rank) (Integer/valueOf (str rank)) (replacements rank))))

(defn suit [card]
  (let [[_ s] card]
    (str s)))


(defn pair? [hand]
  (= 2 (apply max (vals (frequencies (map rank hand))))))

(defn three-of-a-kind? [hand]
  nil)

(defn four-of-a-kind? [hand]
  nil)

(defn flush? [hand]
  nil)

(defn full-house? [hand]
  nil)

(defn two-pairs? [hand]
  nil)

(defn straight? [hand]
  nil)

(defn straight-flush? [hand]
  nil)

(defn value [hand]
  nil)
