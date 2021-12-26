(ns reagent01.components
  (:require 
     [clojure.string :as s]
     [reagent01.utils :as u]
     [reagent-mui.components :as mui]
     [reagent-mui.icons.close :refer [close]]
     [reagent-mui.material.button :refer [button]]
  ))

;; -------------------------
;; components

(defn reset-btn [handle-click disabled]
  [mui/icon-button {:size "small"
                    :on-click handle-click
                    :disabled disabled
                    :style (merge {:background (if disabled "#e2e2e2" "#d32f2f")} u/reset-btn-style)}
  [close]])


(defn btn [label handle-click disabled color]
  [button {:variant "outlined"
           :color (or color "primary")
           :on-click handle-click
           :disabled disabled
           :style u/btn-style}
   label])


(defn num-input [val handle-change disabled]
  [mui/text-field
    (merge {:value val
            :disabled disabled
            :on-change handle-change} u/text-field-props)])

