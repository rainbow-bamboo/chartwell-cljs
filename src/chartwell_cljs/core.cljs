(ns chartwell-cljs.core)
;; FF-Chartwell is a webfont that creates simple charts out of integers.
;;
;; For example, this span:
;; <span class="vertical-bars">10,50,100</span>
;;
;; with this css:
;; .vertical-bars{
;;   font-family: "FFChartwellBarsVerticalRegular";
;;   font-variant-ligatures: discretionary-ligatures;
;;   }
;;
;; will return a bar-graph with 3 bars:
;; 1: 10% of font-height
;; 2: 50%
;; 3: 100%

;; It also has support for horizontal-bars, pies,
;; radars, rings, areas, roses, bubbles, scatters and lines...
;; as well as a couple "floating" variants.

;; The font technology used (discretionary liglatures) is
;; supported in everything except IE, and I assume that most of
;; the bugs in FF Chartwell have been ironed out because it's
;; been active since 2012.

;; Here is a sample reagent component
;; (defn simple-component []
;;   [:div
;;     [:span {:style {:color "blue"}} "I am blue text"]
;;     [:span {:style {:color "red"}} "I am red text"]]])
;;
;; I'm imagining that the api will look like:
;; (<chart-type> <values> <default-colors> <class-name>)
;;
;; With the function for vertical-bars resembling:
;; (vertical-bars [10 20] ["#bee" "#fab] "v-bar")
;;
;;  => [:div.vertical-bar [:span "10" {:style {:color "#bee"} :class "chart-segment"}]
;;  =>                    [:span "20" {:style {:color "#fab"} :class "chart-segment"}]]
;;
;; We can abstract the "span" structure into a `chart-segment` component
;; since it'll represent the smallest building block of a chart.

;; Since each chart segment is a part of a whole chart,
;; react/reagent requires us to provide a unique key for the virtual dom

(defn chart-segment
  "Given the integer size, a hexcode color, and a class string,
   return a reagent span component."
  [content color class]
  ^{:key (random-uuid)}
  [:span {:style {:color color}
          :class (str "chart-segment " class)}
   (reduce str content)])

;; It's meant to work with the (herb)[http://herb.roosta.sh/] library for more complex
;; styling like: (chart-segment 10 "#bee" (<class sample-class-func))
