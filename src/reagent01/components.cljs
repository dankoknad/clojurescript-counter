(ns reagent01.components
  (:require 
     [clojure.string :as s]
     [reagent-mui.components :as mui]
     [reagent-mui.icons.close :refer [close]]
     [reagent-mui.material.button :refer [button]]
  ))

(defn reset-btn [handle-click disabled]
  [mui/icon-button
    {:size "small"
     :on-click handle-click
     :disabled disabled
     :style {:position "absolute"
             :top 26
             :right -40
             :color "#fff"
             :background (if disabled "#e2e2e2" "#d32f2f")}
    }
    [close]
  ])

(defn btn [label handle-click disabled color]
  [button
    {:variant "outlined"
     :color (or color "primary")
     :style {:margin-left 10 :text-transform "none"}
     :on-click handle-click
     :disabled disabled
    }
    label
  ])

(defn num-input [val handle-change disabled]
  [mui/text-field
    {:type "number"
     :size "small"
     :color "primary"
     :autoFocus true
     :value val
     :disabled disabled
     :on-change handle-change
     :style {:vertical-align "middle"}
    }
  ])

