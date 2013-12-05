(ns NightClazz1.core
  (:require [quil.core :as q]))

;; cellule
; [0 1]

;; voisinage

;; vivante -> relation d'appartenance à une génération

;; génération -> ensemble des cellules vivantes
(def world #{[0 1] [1 2] [1 1]})

;; setup
(defn setup []
  (q/smooth) ;; anti-aliasing
  (q/frame-rate 30))

(defn draw []
  (q/background (q/color 0 0 255))
  (q/stroke-weight 0)
  (q/fill (q/color 255 255 0))

  (doseq [cell world]
    (let [diam (q/random 100)
          x (q/random (q/width))
          y (q/random (q/height))]
      (q/ellipse x y diam diam))))

(q/defsketch game-of-life                  ;;Define a new sketch named example
  :title "Game of life"  ;;Set the title of the sketch
  :setup setup                      ;;Specify the setup fn
  :draw draw                        ;;Specify the draw fn
  :size [323 200])              ;;You struggle to beat the golden ratio

