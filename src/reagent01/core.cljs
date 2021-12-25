(ns reagent01.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [reagent01.state :as s]
      [reagent-mui.components :as mui]
      [reagent01.components :as c]
      [reagent01.misc :as m]
      ))

;; -------------------------
;; Views

(defn counter []
  (println s/state)
  [mui/grid m/container-props 
    [mui/grid {:item true} "Simple Counter"]
    [mui/grid {:item true} [mui/paper m/paper-props [@s/state :count]]]
    [mui/grid {:item true} 
      [:<> "Step: "]
      [c/num-input
        (@s/state :step)
        #(swap! s/state assoc-in [:step] (-> % .-target .-value int))
        (@s/state :input-disabled)
      ]]

    [mui/grid {:item true} 
      [c/btn "Decrement" #(swap! s/state assoc-in [:count] (- (@s/state :count) (@s/state :step))) (@s/state :decrement-btn-disabled)]
      [c/btn "Reset" #(swap! s/state assoc-in [:count] (@s/state :initial)) (@s/state :reset-btn-disabled) "error"]
      [c/btn "Increment" #(swap! s/state assoc-in [:count] (+ (@s/state :count) (@s/state :step))) (@s/state :increment-btn-disabled)]]
    ]
  )

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counter] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
