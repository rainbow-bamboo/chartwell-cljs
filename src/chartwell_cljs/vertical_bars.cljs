(ns chartwell-cljs.vertical-bars
  (:require
   [chartwell-cljs.core :refer [chart-segment size-id-func]]))

;; Note how the key prop is stored as meta
;; (meta (chart-segment "lol" "red" (sample-id-func "101010")))
;; => {:key "1010101584214541804"}

;; Our dream is to return
;; [:div.vertical-bar [chart-segment _ _ _ ] [chart-segment _ _ _ ] ]

(defn vertical-bars [sizes colors class]
  [:div.vertical-bar
   (map
    (fn [[size color]] (chart-segment (str size ",")
                               color
                               class))
    (map vector sizes colors))])

;; I'm sure that there's a more elegant way of doing this in one
(defn herb-vertical-bars [sizes colors class-func]
  [:div.vertical-bar
   (map
    (fn [[size color]] (chart-segment (str size ",")
                                      color
                                      (class-func size color)))
    (map vector sizes colors))])

;; (def sample-sizes [10 50 100])
;; (def sample-colors ["#bee" "#fab" "#ada"])

;; (defn sample-class-func
;;   "Given a a size and color, test if the value is below 50,and
;;   return a herb className that contains the appropriate style."
;;   [size color]
;;   (letfn [(style []
;;             (if (< size 50)  ;; we can change this 50 to an atom
;;               {:background-color "#fab"};; controlled by a slider
;;               {:background-color "#bee"}))]
;;     (<class style)))

;; (vertical-bars sample-sizes sample-colors (sample-id-func "10"))
