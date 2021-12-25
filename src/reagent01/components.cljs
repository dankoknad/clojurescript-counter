(ns reagent01.components
  (:require 
     [clojure.string :as s]
     [reagent-mui.components :as mui]
     [reagent-mui.material.button :refer [button]]
  ))

(defn btn [label handle-click disabled color]
  [button
    {:variant "outlined"
     :color (or color "primary")
     :style {:marginLeft 10}
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
     :style {:verticalAlign "middle"}
    }
  ]
)
