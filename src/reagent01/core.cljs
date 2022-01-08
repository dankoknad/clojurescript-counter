(ns reagent01.core
  (:require
    [reagent.core :as r]
    [reagent.dom :as d]
    [reagent01.state :as s]
    [reagent-mui.material.grid :refer [grid]]
    [reagent-mui.material.paper :refer [paper]]
    [reagent-mui.icons.add :refer [add]]
    [reagent-mui.icons.remove :refer [remove]]
    [reagent01.components :as c]
    [reagent01.settings-component :as stc]
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

  [grid u/container-props
    
    [grid [:h3 {:item "true"} "Simple Counter " [stc/settings-component]]]

    [grid {:item true :style {:position "relative"}}
      [:div>em "Result:"]
      [paper u/paper-props _count]
      [c/reset-btn
        #(swap! s/state assoc-in [:count] initial)
        (== _count initial)
      ]]

    [grid {:item true}
      [:div>em "Step:"]
      [c/num-input
        step
        #(swap! s/state assoc-in [:step] (-> % .-target .-value int))
        input-disabled
      ]]

    [grid {:item true}
      [c/btn
        [remove]
        #(swap! s/state assoc-in [:count] (- _count step))
        dec-btn-disabled]
      [c/btn
        [add]
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

