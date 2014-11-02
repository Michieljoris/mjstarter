(defproject {{raw-name}} "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; Warns users of earlier versions of Leiningen. Set this if your project
  ;; relies on features only found in newer Leiningen versions.
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [com.cemerick/piggieback "0.1.3"]
                 [weasel "0.4.2"]
                 [figwheel "0.1.5-SNAPSHOT"] 
                 ]
  ;; Plugins are code that runs in Leiningen itself and usually
  ;; provide new tasks or hooks.
  :plugins [
            [lein-cljsbuild "1.0.3"]
            [lein-figwheel "0.1.5-SNAPSHOT"]
            [cider/cider-nrepl "0.8.0-SNAPSHOT"] ;; or add to ~/.lein/proofiles.clj
            [lein-cooper "0.0.1"]
            ]

  ;; Profiles
  ;; Each active profile gets merged into the project map. The :dev
  ;; and :user profiles are active by default, but the latter should be
  ;; looked up in ~/.lein/profiles.clj rather than set in project.clj.
  ;; Use the with-profiles higher-order task to run a task with a
  ;; different set of active profiles.
  ;; See `lein help profiles` for a detailed explanation.
  ;; :profiles {:uberjar {:aot :all}}

  ;;; Entry Point
  ;; The -main function in this namespace will be run at launch
  ;; (either via `lein run` or from an uberjar). It should be variadic:
  ;;
  ;; (ns my.service.runner
  ;; (:gen-class))
  ;;
  ;; (defn -main
  ;; "Application entry point"
  ;; [& args]
  ;; (comment Do app initialization here))
  ;;
  :main {{namespace}}
  
  ;;; Filesystem Paths
  ;; If you'd rather use a different directory structure, you can set these.
  ;; Paths that contain "inputs" are string vectors, "outputs" are strings.
  :source-paths ["src-clj"]
  ;; :java-source-paths ["src/main/java"] ; Java source is stored separately.
  ;; :test-paths ["test" "src/test/clojure"]
  ;; :resource-paths ["src/main/resource"] ; Non-code files included in classpath/jar.
  ;; All generated files will be placed in :target-path. In order to avoid
  ;; cross-profile contamination (for instance, uberjar classes interfering
  ;; with development), it's recommended to include %s in in your custom
  ;; :target-path, which will splice in names of the currently active profiles.
  ;; :target-path "target/%s/"
  ;; Directory in which to place AOT-compiled files. Including %s will
  ;; splice the :target-path into this value.
  ;; :compile-path "%s/classy-files"
  ;; Directory in which to extract native components from inside dependencies.
  ;; Including %s will splice the :target-path into this value. Note that this
  ;; is not where to *look* for existing native libraries; use :jvm-opts with
  ;; -Djava.library.path=... instead for that.
  ;; :native-path "%s/bits-n-stuff"
  ;; Directories under which `lein clean` removes files.
  ;; Specified by keyword or keyword-chain to get-in path in this defproject.
  ;; Both a single path and a collection of paths are accepted as each.
  ;; For example, if the other parts of project are like:
  ;; :target-path "target"
  ;; :compile-path "classes"
  ;; :foobar-paths ["foo" "bar"]
  ;; :baz-config {:qux-path "qux"}
  ;; :clean-targets below lets `lein clean` remove files under "target",
  ;; "classes", "foo", "bar", "qux", and "out".
  ;; By default, will protect paths outside the project root and within standard
  ;; lein source directories ("src", "test", "resources/public", "doc", "project.clj").
  ;; However, this protection can be overridden with metadata on the :clean-targets
  ;; vector - ^{:protect false}
  ;; :clean-targets [:target-path :compile-path :foobar-paths
  ;;                 [:baz-config :qux-path] "out"]
  ;; Workaround for http://dev.clojure.org/jira/browse/CLJ-322 by deleting
  ;; compilation artifacts for namespaces that come from dependencies.
  ;; :clean-non-project-classes true
  ;; Paths to include on the classpath from each project in the
  ;; checkouts/ directory. (See the FAQ in the Readme for more details
  ;; about checkout dependencies.) Set this to be a vector of
  ;; functions that take the target project as argument. Defaults to
  ;; [:source-paths :compile-path :resource-paths], but you could use
  ;; the following to share code from the test suite:
  ;; :checkout-deps-shares [:source-paths :test-paths
  ;;                        ~(fn [p] (str (:root p) "/lib/dev/*"))]

  
  ;; All generated files will be placed in :target-path. In order to avoid
  ;; cross-profile contamination (for instance, uberjar classes interfering
  ;; with development), it's recommended to include %s in in your custom
  ;; :target-path, which will splice in names of the currently active profiles.

  ;; Options to change the way the REPL behaves.
  :repl-options { ;; Specify the string to print when prompting for input.
                 ;; defaults to something like (fn [ns] (str *ns* "=> "))
                 ;; :prompt (fn [ns] (str "your command for <" ns ">, master? " ))
                 ;; What to print when the repl session starts.
                 :welcome (println "Welcome to the magical world of the repl!")
                 ;; Specify the ns to start the REPL in (overrides :main in
                 ;; this case only)
                 ;; :init-ns foo.bar
                 ;; This expression will run when first opening a REPL, in the
                 ;; namespace from :init-ns or :main if specified.
                 :init (println "here we are in" *ns*)
                 ;; Print stack traces on exceptions (highly recommended, but
                 ;; currently overwrites *1, *2, etc).
                 ;; :caught clj-stacktrace.repl/pst+
                 ;; Skip's the default requires and printed help message.
                 :skip-default-init false
                 ;; Customize the socket the repl task listens on and
                 ;; attaches to.
                 ;; :host "0.0.0.0"
                 :port 52123
                 ;;for more options see the sample project.clj
                 :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  

  :figwheel {
             :http-server-root "public" ;; this will be in resources/
             :server-port 3449          ;; default

             ;; CSS reloading (optional)
             ;; :css-dirs has no default value 
             ;; if :css-dirs is set figwheel will detect css file changes and
             ;; send them to the browser
             :css-dirs ["resources/public/css"]

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server
             ;; :ring-handler example.server/handler 
             } 
  
  
  :cljsbuild {
              :builds [{
                        :id "dev"
                        ;; The path to the top-level ClojureScript source directory:
                        :source-paths ["src-cljs"]
                        ;; The standard ClojureScript compiler options:
                        ;; (See the ClojureScript compiler documentation for details.)
                        :compiler {
                                   ;; The path to the JavaScript file that will be output.
                                   ;; Defaults to "target/cljsbuild-main.js".
                                   :output-to "resources/public/js/main.js"
                                   ;; See
                                   ;; https://github.com/clojure/clojurescript/wiki/Source-maps
                                   ;; Sets the output directory for temporary
                                   ;; files used during compilation. Must be
                                   ;; unique among all :builds. Defaults to
                                   ;; "target/cljsbuild-compiler-X" (where X is
                                   ;; a unique integer).
                                   :output-dir "resources/public/js"
                                   ;; Defaults to :whitespace.
                                   ;; :source-map "resources/public/js/main.js.map"
                                   :source-map true
                                   ;; The optimization level. May be :whitespace, :simple, or :advanced.
                                   ;; :optimizations :whitespace
                                   ;; :optimizations :simple
                                   ;; :optimizations :advanced
                                   :optimizations :none
                                   
                                   ;; Configure externs files for external libraries.
                                   ;; Defaults to the empty vector [].
                                   ;; For this entry, and those below, you can find a very good explanation at:
                                   ;; http://lukevanderhart.com/2011/09/30/using-javascript-and-clojurescript.html
                                   ;; :externs ["jquery-externs.js"]
                                   ;; Adds dependencies on external libraries. Note that files in these directories will be
                                   ;; watched and a rebuild will occur if they are modified.
                                   ;; Defaults to the empty vector [].
                                   ;; :libs ["closure/library/third_party/closure"]
                                   ;; Adds dependencies on foreign libraries. Be sure that the url returns a HTTP Code 200
                                   ;; Defaults to the empty vector [].
                                   ;; :foreign-libs [{:file "http://example.com/remote.js"
                                   ;;                 :provides ["my.example"]}]
                                   ;; Prepends the contents of the given files to each output file.
                                   ;; Defaults to the empty vector [].
                                   ;; :preamble ["license.js"]
                                   ;; Configure the input and output languages for the closure library.
                                   ;; May be :ecmascript3, ecmascript5, or ecmascript5-strict.
                                   ;; Defaults to ecmascript3.
                                   ;; :language-in :ecmascript5
                                   ;; :language-out :ecmascript5
                                   ;; :pretty-print true
                                   }
                        }]
              }
  
  )
