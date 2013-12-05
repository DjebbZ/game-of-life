(ns NightClazz1.core
  (:require [quil.core :as q]))

;; cellule
[0 1]


 ;; voisinage

 ;; vivante -> relation d'appartenance à une génération

 ;; génération -> ensemble des cellules vivantes
(def world #{[0 1] [1 2] [1 1]})

;; setup
(defn setup []
  (q/smooth)
  (q/frame-rate 30))

(defn draw []
  (q/background (q/color 0 0 255)))
