(ns tefa-starter.core)

;; ---------
;; Nodes

(def nodes {:foo "you are at the Foo"
            :bar "you are at the Bar"})

(defn describe-location [location nodes])


;; ---------
;; Edges

(def edges {:foo {:bar [:north :road]
                  :baz [:south :road]}
            :baz {:foo [:north :road]}
            :bar {:foo [:south :road]}})

(defn describe-path [path])

(defn describe-paths [location edges])


;; ----------
;; Items

(def objects [:quux])

(def object-locations {:quux [:foo :floor]})

(defn objects-at [location object-locations])

(defn describe-objects [location object-locations])


;; ---------------
;; Player Location

(def location (atom :foo))


;; ---------------
;; Player Actions

(defn look [])

(defn move [direction])




