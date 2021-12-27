(ns reagent01.components
  (:require 
     [clojure.string :as s]
     [reagent01.utils :as u]
     [reagent-mui.material.button :refer [button]]
     [reagent-mui.material.icon-button :refer [icon-button]]
     [reagent-mui.material.text-field :refer [text-field]]
     [reagent-mui.icons.close :refer [close]]
  ))

;; -------------------------
;; components


(defn reset-btn [handle-click disabled]
  [icon-button {:size "small"
                    :on-click handle-click
                    :disabled disabled
                    :style (merge {:background (if disabled "#e2e2e2" "#d32f2f")} u/reset-btn-style)}
  [close]])


(defn btn [icon handle-click disabled color]
  [button {:variant "outlined"
           :color (or color "primary")
           :on-click handle-click
           :disabled disabled
           :style u/btn-style}
   icon])


(defn num-input [val handle-change disabled]
  [text-field
    (merge {:value val
            :disabled disabled
            :on-change handle-change} u/text-field-props)])

