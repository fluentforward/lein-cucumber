(ns leiningen.cucumber.util
  (:import [gherkin.formatter PrettyFormatter])
  (:import [cucumber.cli DefaultRuntimeFactory])
  (:import [cucumber.io FileResourceLoader])
  (:import [cucumber.runtime.snippets SummaryPrinter])
)

(defn exec-cucumber	[]
	(let 
	   [formatter (PrettyFormatter. System/out true true)
		reporter formatter
		classloader (.getContextClassLoader (Thread/currentThread))
		runtime-factory (DefaultRuntimeFactory.)
		runtime (.createRuntime runtime-factory (FileResourceLoader.) ["test/features/step_definitions"] classloader false)]

		(.run runtime ["test/features"] [] formatter reporter)
		(.print (SummaryPrinter. System/out) runtime)
		(doto formatter (.done) (.close))
		runtime
		))

