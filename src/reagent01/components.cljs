(ns reagent01.components
  (:require 
     [clojure.string :as s]
     [reagent-mui.components :as mui]
     [reagent-mui.material.button :refer [button]]
  ))

(defn welcome [name]
  [:div
  [:p
      "Hello There"
      " "
      (if-not (s/blank? name) name "Anonimous")
      "!!"
      [button {:variant "contained"
               :color "primary"
               :style {:marginLeft 10}
               :value "danko"
               :on-click #(-> % .-target .-value js/console.log)}
        "just a button"
      ]
      [:br]
      [mui/switch {:defaultChecked true :color "secondary"}]
  ]])

