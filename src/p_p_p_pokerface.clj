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
  (= 3 (apply max (vals (frequencies (map rank hand))))))

(defn four-of-a-kind? [hand]
  (= 4 (apply max (vals (frequencies (map rank hand))))))

(defn flush? [hand]
  (= 5 (apply max (vals (frequencies (map suit hand))))))

(defn full-house? [hand]
  (= (sort (vals (frequencies (map rank hand)))) '(2 3)))

(defn two-pairs? [hand]
  nil)

(defn straight? [hand]
  nil)

(defn straight-flush? [hand]
  nil)

(defn value [hand]
  nil)

