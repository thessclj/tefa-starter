(ns tefa-starter.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [tefa-starter.core :refer [describe-location]]))

(deftest describe-location-test
  (testing "describing locations."
    (let [nodes {:foo "i am here"}]
      (is (= "i am here"
             (describe-location :foo nodes))))))
