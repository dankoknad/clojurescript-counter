(ns reagent01.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [reagent01.state :as s]
      [reagent-mui.components :as mui]
      [reagent-mui.icons.close :refer [close]]
      [reagent01.components :as c]
      [reagent01.misc :as m]
      ))

;; -------------------------
;; Views

(defn counter []
  [mui/grid m/container-props 
    [mui/grid {:item true} "Simple Counter"]
    [mui/grid {:item true :style {:position "relative"}}
      [mui/paper m/paper-props [@s/state :count]]
      [mui/icon-button {
        :size "small"
        :on-click #(swap! s/state assoc-in [:count] (@s/state :initial))
        :disabled (if (== (@s/state :count) (@s/state :initial)) true false)
        :style {:position "absolute"
                :top 26
                :right -40
                :color "#fff"
                :background (if (== (@s/state :count) (@s/state :initial)) "#e2e2e2" "#d32f2f")}
        } [close]]
      ]

    [mui/grid {:item true} 
      [:<> "Step: "]
      [c/num-input
        (@s/state :step)
        #(swap! s/state assoc-in [:step] (-> % .-target .-value int))
        (@s/state :input-disabled)
      ]]

    [mui/grid {:item true} 
      [c/btn
        "Decrement"
        #(swap! s/state assoc-in [:count] (- (@s/state :count) (@s/state :step)))
        (@s/state :decrement-btn-disabled)]
      [c/btn
        "Increment"
        #(swap! s/state assoc-in [:count] (+ (@s/state :count) (@s/state :step)))
        (@s/state :increment-btn-disabled)]]
    
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counter] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
