(ns chartwell-cljs.vertical-bars
  (:require
   [chartwell-cljs.core :refer [chart-segment sample-id-func]]))

;; Note how the key prop is stored as meta
;; (meta (chart-segment "lol" "red" (sample-id-func "101010")))
;; => {:key "1010101584214541804"}

;; Our dream is to return
;; [:div.vertical-bar [chart-segment _ _ _ ] [chart-segment _ _ _ ] ]

(defn vertical-bars [sizes colors id]
  [:div.vertical-bar
   (map
    (fn [datum] (chart-segment (str (first datum) ",") (second datum) id))
    (map vector sizes colors))])

(def sample-sizes [10 50 100])
(def sample-colors ["#bee" "#fab" "#ada"])

;; (vertical-bars sample-sizes sample-colors (sample-id-func "10"))
