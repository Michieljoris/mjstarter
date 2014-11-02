(ns leiningen.new.mjstarter
  (:require [leiningen.new.templates :refer [renderer year project-name 
                                             sanitize-ns multi-segment
                                             name-to-path ->files]]
            [leiningen.core.main :as main]))



(defn mjstarter
  "Starter app with repls and figwheel"
  [name & rest]
  (let [
        render (renderer "mjstarter")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :sanitized (name-to-path main-ns)
              :year (year)
              :weasel-port: 8092
              :weasel-host: "127.0.0.1"
              :figwheel-port: 3449
              :nrepl-port: 15123
              }
     (println "Generating a project called" name "based on the 'mjstarter' template.")
     (println "Rest:" rest)
     (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.org" (render "README.org" data)]
             [".gitignore" (render "gitignore" data)]
             ["src-clj/mjstarter/weasel.clj" (render "weasel.clj" data)]
             ["src-clj/{{sanitized}}.clj" (render "core.clj" data)]
             ["src-cljs/{{sanitized}}.cljs" (render "core.cljs" data)]
             ["resources/public/css/main.css" (render "main.css" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ;; ["doc/intro.md" (render "intro.md" data)]

             )))
