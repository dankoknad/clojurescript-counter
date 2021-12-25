(ns reagent01.state
    (:require
      [reagent.core :as r]))

(def state (r/atom
   {:initial 0 ;; so we can reset counter
    :count 0 ;; same as initial
    :step 5
    :decrement-btn-disabled false
    :increment-btn-disabled false
    :input-disabled false}))

