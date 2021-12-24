(ns reagent01.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [reagent01.state :as s]
      [reagent01.components :as c]
      ))

;; -------------------------
;; Views

(defn counting-component []
  [:div {:style {:textAlign "center"}}
    [:div "The atom " [:code "$count"] " has value:"
      [:div {:style {:color "#f0f" :fontWeight 700}} @s/$count]
    ]
    [:hr]
    [:div
       [:input {
         :type "button"
         :value "Dec"
         :on-click #(swap! s/$count - @s/$step)
      }]
      [:input {
         :type "button"
         :value "Reset"
         :on-click #(reset! s/$count 0)
         :style {:margin "0 4px"} 
      }]
      [:input {
         :type "button"
         :value "Inc"
         :on-click #(swap! s/$count + @s/$step)
      }]
      [:hr]
      [:span "Step: "]
      [:input {
         :type "number"
         :value @s/$step
         :on-change #(reset! s/$step (-> % .-target .-value int))
      }]
      [:hr]
      [c/welcome "Danko"]
    ]
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counting-component] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
