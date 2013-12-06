(ns NightClazz1.core
  (:require [quil.core :as q]))

;; cellule
; [0 1]

;; voisinage

;; vivante -> relation d'appartenance à une génération

;; génération -> ensemble des cellules vivantes
(def world (atom #{[0 1] [1 2] [1 1]}))

(def width 400)
(def height 300)

;; quil's setup
(defn setup []
  (q/smooth) ;; anti-aliasing
  (q/frame-rate 6))

;; quil's draw
(defn draw []
  (q/background (q/color 0 0 255))
  (q/stroke-weight 0)
  (q/fill (q/color 255 255 0))

  (doseq [[x y] @world]
    (let [diam 50
          x (+ 100 (* x 20))
          y (+ 100 (* y 20))]
      (q/ellipse x y diam diam))))

(q/defsketch game-of-life                  ;;Define a new sketch named example
  :title "Game of life"  ;;Set the title of the sketch
  :setup setup                      ;;Specify the setup fn
  :draw draw                        ;;Specify the draw fn
  :size [width height])              ;;You struggle to beat the golden ratio

(defn neighbours
  "Calcule les 8 voisines"
  [[x y]]
  {:post [(= (count %) 8)]}
  (for [nx (range (dec x) (+ x 2))
        ny (range (dec y) (+ y 2))
        :when (not= [x y] [nx ny])]
    [nx ny]))

(defn step [cells]
  (let [freqs (frequencies
                (mapcat neighbours cells))
        alive? (fn [[cell freq]]
                        (if (contains? cells cell)
                          (<= 2 freq 3)
                          (= freq 3)))]
    (set (keys (filter alive? freqs)))))
