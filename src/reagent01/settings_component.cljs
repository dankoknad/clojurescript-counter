(ns reagent01.settings-component
  (:require 
    [reagent01.state :as s]
    [reagent.core :as r]
    [reagent-mui.material.typography :refer [typography]]
    [reagent-mui.material.dialog :refer [dialog]]
    [reagent-mui.material.dialog-content :refer [dialog-content]]
    [reagent-mui.material.icon-button :refer [icon-button]]
    [reagent-mui.material.switch-component :refer [switch]]
    [reagent-mui.icons.settings :refer [settings]]
    [reagent-mui.icons.close :refer [close]]
  ))

(def open (r/atom false))

(defn toggle [val]
  #(reset! val (if @val false true)))

(defn toggle-state [key]
  #(swap! s/state assoc-in [key] (if (key @s/state) false true)))

(defn option [key enabled-text disabled-text]
  [typography
    {:variant "body1" :on-click (toggle-state key)}
    [switch {:checked (key @s/state) :color "error"}]
    (if (key @s/state) disabled-text enabled-text)])

(defn settings-component []
  [:<>
    [icon-button {:color "primary"
                  :on-click (toggle open)}
      [settings]]
    [dialog {:open @open
             :on-close (toggle open)
             :classes {:paper "dialog"}}
      [dialog-content
        [typography {:variant "h5"
                     :style {:margin-bottom 30}}
          "Settings"
          [icon-button {:on-click (toggle open)
                        :classes {:root "close-btn"}}
            [close]]
        ]
        [option :dec-btn-disabled "Disable decrement" "Decrement disabled"]
        [option :inc-btn-disabled "Disable increment" "Increment disabled"]
        [option :input-disabled "Disable step input" "Step input disabled"]
      ]
    ]
  ])

