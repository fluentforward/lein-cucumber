(ns plugin.test.core
  (:use [leiningen.cucumber])
  (:use [clojure.test]))

(def belly (atom []))

(defn mood []
  (let [cukes (->> @belly
                   (filter #(= "cukes" %))
                   count)]
    (cond
     (> cukes 3) :happy
     (= cukes 2) :meh
     (= cukes 1) :sad
     :else :hungry)))

(defn eat [things]
  (swap! belly concat things))
  
(deftest run-cucumber
  (cucumber))
