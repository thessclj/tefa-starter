(ns tefa-starter.core)

;; ---------
;; Nodes

(def nodes {:foo "you are at the Foo"
            :bar "you are at the Bar"})

;; Although nodes are defined before, we will try to avoid working
;; with global state as much as we can. For this reason the nodes
;; will be passed as a parameter. This will also simplify testing.

;; To get the description of a location the only thing that has to
;; be done is to get the value of a key in the nodes hashmap. There
;; are many ways to do it in clojure but the most handy for us is
;; the `get` function which can also return a fallback value when the
;; key is not present in the hashmap.

(defn describe-location
  "Give the description of a location. Location is expected to be
   a keyword and nodes a hashmap."
  [location nodes])


;; ---------
;; Edges

;; Edges is a somewhat more complex data structure because it is used
;; to represent a graph.
;; It is a hashmap where its keys point to other hashmaps. The key of the
;; top level hashmap is the root place, and the keys of the nested
;; hashmaps are the places that are near to this place. The values of the
;; nearest places are a tuple of direction and which medium is used to
;; travel to that place.
;; A visual representation is more helpful in that case. Let's see what
;; it looks like from the :foo point of view:

;; :bar <----[:north :road]--- :foo ----[:south :road]---> :baz

;; From :bar we will need to move :north to end up to :foo. This is the
;; second entry in the map etc.

(def edges {:foo {:bar [:north :road]
                  :baz [:south :road]}
            :baz {:foo [:north :road]}
            :bar {:foo [:south :road]}})

;; Path is the direction/medium tuple seen above. The test has
;; the exact text that we need to produce. The `name` function
;; returns a string from a keyword, so it has to be used here.

(defn describe-path
  "Describes a path tuple"
  [path])

;; We need to take all the entries for a root key, describe them
;; using the function created above, and concatenate them.
;; This will have to be using a loop or some
;; other reducing function, like `reduce` or `reduce-kv`.
;; clojure.string/join can be used to join string with a specific
;; delimiter.

(defn describe-paths
  "Given a root location and an edges graph, describe all the paths
   the user can take from there"
  [location edges])


;; ----------
;; Items

;; For now objects will be unused.

(def objects [:quux])

;; Like nodes and edges, object-locations is a map of objects
;; and, well, their locations. The location tuple, has the place
;; (which has exist in nodes) and the exact location at that place.

;; The careful reader will notice that this get tricky here, as we
;; can't just say `on the XXX` for everything, but this should be
;; adequate for now.

(def object-locations {:quux [:foo :floor]})

;; Same as before we are passing explicitly the object locations,
;; and do not intend to access global data from the objects-at
;; function.

(defn objects-at
  "Retuns the objects (keywords) at the specific location"
  [location object-locations])

;; This function is very similar to describe paths.

(defn describe-objects
  "Describes all the objects at the given location"
  [location object-locations])


;; ---------------
;; Player Location

;; The location of the player is mutable (evil) and for this reason
;; we will use one of clojure's concurrency primitives to make changes
;; to it.
;; The use of an atom might looks like "too much" for this simple case
;; but we will use it check some interesting applications (beyond the
;; scope of this project).

;; You can read about atoms and the other concurrency primitives here:
;; https://clojure.org/reference/atoms
;; Note that this doc might be a bit hard to follow for clojure beginners


(def location (atom :foo))


;; ---------------
;; Player Actions

(defn look
  "Describes the current location, the objects at that place
   and the paths the user can take."
  [])

(defn move
  "Moves towards this direction"
  [direction])




