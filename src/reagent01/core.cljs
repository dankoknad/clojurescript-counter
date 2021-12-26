(ns reagent01.core
  (:require
    [reagent.core :as r]
    [reagent.dom :as d]
    [reagent01.state :as s]
    [reagent-mui.components :as mui]
    [reagent01.components :as c]
    [reagent01.utils :as u]))

;; -------------------------
;; Views

(defn counter []
  (def _count (:count @s/state))
  (def initial (:initial @s/state))
  (def step (:step @s/state))
  (def input-disabled (:input-disabled @s/state))
  (def dec-btn-disabled (:dec-btn-disabled @s/state))
  (def inc-btn-disabled (:inc-btn-disabled @s/state))

  [mui/grid u/container-props
    [:mui/grid>h3 {:item true} "Simple Counter"]

    [mui/grid {:item true :style {:position "relative"}}
      [mui/paper u/paper-props _count]
      [c/reset-btn
        #(swap! s/state assoc-in [:count] initial)
        (== _count initial)
      ]]

    [mui/grid {:item true}
      [:div>em "Step: "]
      [c/num-input
        step
        #(swap! s/state assoc-in [:step] (-> % .-target .-value int))
        input-disabled
      ]]

    [mui/grid {:item true}
      [c/btn
        "Decrement"
        #(swap! s/state assoc-in [:count] (- _count step))
        dec-btn-disabled]
      [c/btn
        "Increment"
        #(swap! s/state assoc-in [:count] (+ _count step))
         inc-btn-disabled
      ]]
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counter] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))

