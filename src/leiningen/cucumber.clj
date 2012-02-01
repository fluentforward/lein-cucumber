(ns leiningen.cucumber)

(defn cucumber [] 
	(def formatter (gherkin.formatter.PrettyFormatter. System/out true true))
	(def reporter formatter)
	(def classloader (.getContextClassLoader (Thread/currentThread)))
	(def runtime (cucumber.runtime.Runtime. (cucumber.io.FileResourceLoader.) ["test/features/step_definitions"] classloader false))
	(.run runtime ["test/features"] [] formatter reporter)
	(.print (cucumber.runtime.snippets.SummaryPrinter. System/out) runtime)
	(doto formatter (.done) (.close))
	)