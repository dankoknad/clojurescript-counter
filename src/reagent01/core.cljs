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
  [mui/grid m/container-props 
    [mui/grid {:item true} "The atom " [:code "$count"] " has value:"]
    [mui/grid {:item true} [mui/paper m/paper-props @s/$count]]
    [mui/grid {:item true} 
      [c/btn "Decrement" #(swap! s/$count - @s/$step)]
      [c/btn "Reset" #(reset! s/$count 0) false]
      [c/btn "Increment" #(swap! s/$count + @s/$step)]]

    [mui/grid {:item true} 
      [:<> "Step: "]
      [c/num-input
        @s/$step
        #(reset! s/$step (-> % .-target .-value int))
      ]]
    ]
  )

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [counter] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
