(ns leiningen.cucumber
	(:use [leiningen.compile :only [eval-in-project]])
    (:require [leiningen.core :as core]))

(defn cucumber [project] 
	(let [runtime (gensym "runtime")]
    (eval-in-project
     project
     `(do
        (let [~runtime (leiningen.cucumber.util/exec-cucumber)]
          (println)
          ~(when-not core/*interactive?*
             `(System/exit (.exitStatus ~runtime)))))
     nil
     nil
     '(require 'leiningen.cucumber.util))))
	

