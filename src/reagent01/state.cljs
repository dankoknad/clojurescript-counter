(ns reagent01.state
    (:require
      [reagent.core :as r]))

(def $count (r/atom 0))
(def $step (r/atom 5))

