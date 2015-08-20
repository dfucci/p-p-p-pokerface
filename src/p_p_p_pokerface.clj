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
  (= '(2 2) (take 2 (vals (frequencies (map rank hand))))))

(defn straight? [hand]
  (let [ace-high (sort (map rank hand))
        ace-low (sort (replace {14 1} (map rank hand)))]
    (or (= ace-high (range (first ace-high) (inc (last ace-high))))
        (= ace-low (range (first ace-low) (inc (last ace-low)))))))

(defn straight-flush? [hand]
  (and (straight? hand) (flush? hand)))

(defn high-card?  [hand]
  true)

(defn value [hand]
  (let  [checkers #{[high-card? 0]  [pair? 1]
                    [two-pairs? 2]  [three-of-a-kind? 3]
                    [straight? 4]   [flush? 5]
                    [full-house? 6]  [four-of-a-kind? 7]
                    [straight-flush? 8]}
         passing-checks (filter (fn [c] ((first c) hand)) checkers)]
    (apply max (map second passing-checks))))



