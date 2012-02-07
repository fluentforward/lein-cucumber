# plugin

lein-cucumber is a leiningen plugin that simplifies the running of cucumber tests.

## Usage

Simply create a `test/features` directory to contain your feature files, and a
`test/features/step_definitions` directory to contain all of your related
test steps.

Add a dependency on 

```
[fluentsoftware/lein-cucumber "1.0.0-SNAPSHOT"]
```
 to your project.clj

Your cucumber tests can then be run by executing
```
lein cucumber
```

## License

Copyright (C) 2012 Fluent Software

Distributed under the Eclipse Public License, the same as Clojure.
