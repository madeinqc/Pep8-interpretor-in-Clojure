(ns pep8.core
  (:require [pep8.interpreter :refer [run-program]])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run-program [0]))
