(ns reagent01.utils)

(def container-props {:container true
                      :direction "column"
                      :justifyContent "center"
                      :alignItems "center"
                      :rowSpacing "20px"
                      :classes {:root "container"}})

(def paper-props {:elevation 3
                  :classes {:root "result"}})

(def reset-btn-style {:position "absolute"
                      :bottom 4
                      :right -40
                      :color "#fff"})

(def btn-style {:margin-left 10
                :text-transform "none"})

(def text-field-props {:type "number"
                       :size "small"
                       :color "primary"
                       :autoFocus true
                       :style {:margin-top 6 :vertical-align "middle"}})

