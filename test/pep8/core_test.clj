(ns pep8.core-test
  (:require [clojure.test :refer :all]
            [pep8.core :refer :all]
            [pep8.interpreter :refer :all]))

(deftest read-byte-test
  (testing "read-byte-test"
    (is (= (read-byte [10 9 8 7 6 5 4 3 2 1] 6) 4))))

(deftest read-word-test
  (testing "read-word-test"
    (is (= (read-word [10 9 8 7 6 5 4 3 2 1] 6) 16r0403))))

(deftest read-byte-i-test
  (testing "read-byte-i-test"
    (is (= (read-byte-operand (make-state 0 0 0 0 0 14 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :i) 14))))

(deftest read-byte-d-test
  (testing "read-byte-d-test"
    (is (= (read-byte-operand (make-state 0 0 0 0 0 2 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :d) 8))))

(deftest read-byte-n-test
  (testing "read-byte-n-test"
    (is (= (read-byte-operand (make-state 0 0 0 0 0 1 0 0 0 0 [0 0 4 7 6 5 4 3 2 1] 20 true) :n) 6))))

(deftest read-byte-s-test
  (testing "read-byte-s-test"
    (is (= (read-byte-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :s) 2))))

(deftest read-byte-sf-test
  (testing "read-byte-sf-test"
    (is (= (read-byte-operand (make-state 0 0 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :sf) 9))))

(deftest read-byte-x-test
  (testing "read-byte-x-test"
    (is (= (read-byte-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :x) 6))))

(deftest read-byte-sx-test
  (testing "read-byte-sx-test"
    (is (= (read-byte-operand (make-state 0 3 4 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :sx) 2))))

(deftest read-byte-sxf-test
  (testing "read-byte-sxf-test"
    (is (= (read-byte-operand (make-state 0 1 4 0 0 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :sxf) 7))))

(deftest read-word-i-test
  (testing "read-word-i-test"
    (is (= (read-word-operand (make-state 0 0 0 0 0 14 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :i) 14))))

(deftest read-word-d-test
  (testing "read-word-d-test"
    (is (= (read-word-operand (make-state 0 0 0 0 0 2 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :d) 16r807))))

(deftest read-word-n-test
  (testing "read-word-n-test"
    (is (= (read-word-operand (make-state 0 0 0 0 0 1 0 0 0 0 [0 0 4 7 6 5 4 3 2 1] 20 true) :n) 16r605))))

(deftest read-word-s-test
  (testing "read-word-s-test"
    (is (= (read-word-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :s) 16r201))))

(deftest read-word-sf-test
  (testing "read-word-sf-test"
    (is (= (read-word-operand (make-state 0 0 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :sf) 16r908))))

(deftest read-word-x-test
  (testing "read-word-x-test"
    (is (= (read-word-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :x) 16r605))))

(deftest read-word-sx-test
  (testing "read-word-sx-test"
    (is (= (read-word-operand (make-state 0 3 4 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :sx) 16r201))))

(deftest read-word-sxf-test
  (testing "read-word-sxf-test"
    (is (= (read-word-operand (make-state 0 1 4 0 0 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :sxf) 16r706))))

(deftest write-byte-test
  (testing "write-byte-test"
    (let [[_ _ _ _ _ _ _ _ _ _ memory _ _] (write-byte (make-state 0 0 0 0 0 0 0 0 0 0 [0 0 0 0 0 0 0 0 0 0] 20 true) 6 4)]
      (is (= (read-byte memory 6) 4)))))

(deftest write-word-test
  (testing "write-word-test"
    (let [[_ _ _ _ _ _ _ _ _ _ memory _ _] (write-word (make-state 0 0 0 0 0 0 0 0 0 0 [0 0 0 0 0 0 0 0 0 0] 20 true) 6 16r403)]
    (is (= (read-word memory 6) 16r403)))))

(deftest write-byte-d-test
  (testing "write-byte-d-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 0 0 0 0 2 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :d 8) :d) 8))))

(deftest write-byte-n-test
  (testing "write-byte-n-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 0 0 0 0 1 0 0 0 0 [0 0 4 7 6 5 4 3 2 1] 20 true) :n 6) :n) 6))))

(deftest write-byte-s-test
  (testing "write-byte-s-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :s 2) :s) 2))))

(deftest write-byte-sf-test
  (testing "write-byte-sf-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 0 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :sf 9) :sf) 9))))

(deftest write-byte-x-test
  (testing "write-byte-x-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :x 6) :x) 6))))

(deftest write-byte-sx-test
  (testing "write-byte-sx-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 3 4 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :sx 2) :sx) 2))))

(deftest write-byte-sxf-test
  (testing "write-byte-sxf-test"
    (is (= (read-byte-operand (write-byte-operand (make-state 0 1 4 0 0 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :sxf 7) :sxf) 7))))

(deftest write-word-d-test
  (testing "write-word-d-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 0 0 0 0 2 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :d 16r807) :d) 16r807))))

(deftest write-word-n-test
  (testing "write-word-n-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 0 0 0 0 1 0 0 0 0 [0 0 4 7 6 5 4 3 2 1] 20 true) :n 16r605) :n) 16r605))))

(deftest write-word-s-test
  (testing "write-word-s-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :s 16r201) :s) 16r201))))

(deftest write-word-sf-test
  (testing "write-word-sf-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 0 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :sf 16r908) :sf) 16r908))))

(deftest write-word-x-test
  (testing "write-word-x-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 3 7 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 0 1] 20 true) :x 16r605) :x) 16r605))))

(deftest write-word-sx-test
  (testing "write-word-sx-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 3 4 0 0 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :sx 16r201) :sx) 16r201))))

(deftest write-word-sxf-test
  (testing "write-word-sxf-test"
    (is (= (read-word-operand (write-word-operand (make-state 0 1 4 0 0 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :sxf 16r706) :sxf) 16r706))))

(deftest replace-memory-block-test
  (testing "replace-memory-block-test"
    (is (= (replace-memory-block [0 1 2 3 4 5 6 7 8 9] [6 5 4 3] 3) [0 1 2 6 5 4 3 7 8 9]))))

(deftest load-os-test
  (testing "load-os-test"
    (is (= (load-os [0 1 2 3 4 5 6 7 8 9] [6 5 4 3]) [[0 1 2 3 4 5 6 5 4 3] 6]))))

(deftest load-program-test
  (testing "load-program-test"
    (is (= (load-program [0 1 2 3 4 5 6 7 8 9] [6 5 4 3]) [6 5 4 3 4 5 6 7 8 9]))))

(deftest get-addressing-mode-a-i-test
  (testing "get-addressing-mode-a-i-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r00000110 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :a) :i))))

(deftest get-addressing-mode-a-x-test
  (testing "get-addressing-mode-a-x-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r00000111 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :a) :x))))

(deftest get-addressing-mode-aaa-i-test
  (testing "get-addressing-mode-aaa-i-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100000 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :i))))

(deftest get-addressing-mode-aaa-d-test
  (testing "get-addressing-mode-aaa-d-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100001 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :d))))

(deftest get-addressing-mode-aaa-n-test
  (testing "get-addressing-mode-aaa-n-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100010 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :n))))

(deftest get-addressing-mode-aaa-s-test
  (testing "get-addressing-mode-aaa-s-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100011 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :s))))

(deftest get-addressing-mode-aaa-sf-test
  (testing "get-addressing-mode-aaa-sf-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100100 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :sf))))

(deftest get-addressing-mode-aaa-x-test
  (testing "get-addressing-mode-aaa-x-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100101 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :x))))

(deftest get-addressing-mode-aaa-sx-test
  (testing "get-addressing-mode-aaa-sx-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100110 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :sx))))

(deftest get-addressing-mode-aaa-sxf-test
  (testing "get-addressing-mode-aaa-sxf-test"
    (is (= (get-addressing-mode (make-state 0 1 4 0 2r01100111 1 0 0 0 0 [10 9 8 7 6 0 2 3 2 1] 20 true) :aaa) :sxf))))

(deftest get-register-r-a-test
  (testing "get-register-r-a-test"
    (is (= (get-register (make-state 0 1 4 0 2r00011110 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :r) :a))))

(deftest get-register-r-a-test
  (testing "get-register-r-x-test"
    (is (= (get-register (make-state 0 1 4 0 2r00011111 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :r) :x))))

(deftest get-register-rrr-a-test
  (testing "get-register-rrr-a-test"
    (is (= (get-register (make-state 0 1 4 0 2r10010111 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :raaa) :a))))

(deftest get-register-rrr-x-test
  (testing "get-register-rrr-x-test"
    (is (= (get-register (make-state 0 1 4 0 2r10011111 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :raaa) :x))))

(deftest get-value-nn-2-test
  (testing "get-value-nn-2-test"
    (is (= (get-value-from-inst (make-state 0 1 4 0 2r00100110 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :nn) 2))))

(deftest get-value-nnn-6-test
  (testing "get-value-nnn-6-test"
    (is (= (get-value-from-inst (make-state 0 1 4 0 2r01011110 1 0 0 0 0 [10 9 8 7 6 5 4 3 2 1] 20 true) :nnn) 6))))