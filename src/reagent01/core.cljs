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
    [:div "The atom " [:code "$count"] " has value:" @s/$count]
    [:br]
    [:div
      [c/btn "Decrement" #(swap! s/$count - @s/$step)]
      [c/btn "Reset" #(reset! s/$count 0)]
      [c/btn "Increment" #(swap! s/$count + @s/$step)]
      [:br][:br]
      [:span "Step: "]
      [c/num-input
        @s/$step
        #(reset! s/$step (-> % .-target .-value int))
      ]
    ]
  ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counting-component] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
