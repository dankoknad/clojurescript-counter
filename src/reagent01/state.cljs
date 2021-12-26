(ns reagent01.state
    (:require
      [reagent.core :as r]))

(def state (r/atom
   {:initial 0 ;; so we can reset counter
    :count 0 ;; same as initial
    :step 5
    :dec-btn-disabled false
    :inc-btn-disabled false
    :input-disabled false}))

