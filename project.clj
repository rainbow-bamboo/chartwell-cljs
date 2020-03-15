(defproject chartwell-cljs "0.1.3"
  :description "This library generates reagent components which can be used to create charts when paired with the font-family, FF Chartwell."
  :url "https://clojars.org/chartwell-cljs"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.597" :scope "provided"]]
  :repl-options {:init-ns chartwell-cljs.core}
  :plugins [[lein-cljsbuild "1.1.7"]]
  :cljsbuild {
    :builds [{
        ; The path to the top-level ClojureScript source directory:
        :source-paths ["src/chartwell-cljs"]
        ; The standard ClojureScript compiler options:
        ; (See the ClojureScript compiler documentation for details.)
        :compiler {
          :output-to "war/javascripts/main.js"  ; default: target/cljsbuild-main.js
          :optimizations :whitespace
          :pretty-print true}}]})
