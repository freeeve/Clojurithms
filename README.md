# Clojurithms

A Clojure library containing the algorithms from the Java textbook Algorithms by Robert Sedgewick and Kevin Wayne.

At least, that is the plan.

## Usage

Available on clojars for leiningen dependencies: [clojurithms/clojurithms "0.1.0-SNAPSHOT"]

Example union-find usage:

```Clojure
(use clojurithms.unionfind)

; create a new union-find structure with vector length 10
(def uf (with-length 10))

; union (connect) 0 to 1 and 0 to 9
(def uf (union uf 0 1))
(def uf (union uf 0 9))

; check whether 1 and 9 are connected
(connected? uf 1 9)
=> true
```

## License

Copyright © 2012 Wes Freeman

Distributed under the Eclipse Public License, the same as Clojure.
