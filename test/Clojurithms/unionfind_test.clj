(ns Clojurithms.unionfind-test
  (:use clojure.test
        Clojurithms.unionfind))

(deftest construct-with-length
  (testing "Construct with length"
    (is (= 10 (count (:ids (with-length 10)))))
    (is (= 10 (count (:sizes (with-length 10)))))
  )
)

(deftest find-before-union
  (testing "Find before unions"
    (is (= (vec (range 10)) 
           (map #(find-root (with-length 10) %) (vec (range 10)))))
  )
) 

(deftest find-after-union
  (testing "Find after unions"
    (is (= 1 (find-root (union (with-length 10) 1 2) 2)))
    (is (= 1 (find-root (union (union (with-length 10) 1 2) 2 3) 3)))
  )
)

(deftest connected-before-union
  (testing "Connected? before unions"
    (is (= false (connected? (with-length 10) 1 2)))
    (is (= false (connected? (with-length 10) 0 5)))
    (is (= false (connected? (with-length 10) 1 9)))
  )
)

(deftest connected-after-union
  (testing "Connected? after unions"
    (is (= true (connected? (union (with-length 10) 1 2) 1 2)))
    (is (= true (connected? (union (union (with-length 10) 1 2) 2 3) 1 3)))
    (is (= true (connected? (union (union (with-length 10) 3 2) 2 1) 1 3)))
  )
)
