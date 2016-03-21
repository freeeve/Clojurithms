# Clojurithms

A Clojure library containing the algorithms from the Java textbook Algorithms by Robert Sedgewick and Kevin Wayne.

At least, that is the plan.

## Usage

Available on clojars for leiningen dependencies: [clojurithms/clojurithms "0.1.0-SNAPSHOT"]

Example union-find usage:

```Clojure
(ns TestClojure.core
  (:require [clojurithms.unionfind :as uf]))

; create a new union-find structure with vector length 10
(def myuf (uf/with-length 10)) ; #clojurithms.unionfind.unionfind{:ids [0 1 2 3 4 5 6 7 8 9], :sizes [1 1 1 1 1 1 1 1 1 1]}

; union (connect) 0 to 1 and 0 to 9
(def myuf (uf/union myuf 0 1)) ; #clojurithms.unionfind.unionfind{:ids [0 0 2 3 4 5 6 7 8 9], :sizes [2 1 1 1 1 1 1 1 1 1]}
(def myuf (uf/union myuf 0 9)) ; #clojurithms.unionfind.unionfind{:ids [0 0 2 3 4 5 6 7 8 0], :sizes [3 1 1 1 1 1 1 1 1 1]}

; check whether 1 and 9 are connected
(uf/connected? myuf 1 9) ; true

; alternate idiomatic syntax
(ns TestClojure.core
  (:require [clojurithms.unionfind :as uf]))

(def myuf (-> (uf/with-length 10)
              (uf/union 0 1)
              (uf/union 0 9)))

(uf/connected? myuf 1 9)
```

## License

Copyright © 2016 Eve Freeman

Distributed under the Eclipse Public License, the same as Clojure.
