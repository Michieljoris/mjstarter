(ns {{namespace}}
  (:require 
   ;; standard and piggieback:
   ;; [clojure.browser.repl :as repl] 
   ;; weasel:
   [weasel.repl :as ws-repl]
   ;; figwheel
   [figwheel.client :as fw :include-macros true]
   )
  )

;; standard and piggyback:
;; (repl/connect "http://localhost:8090/repl")

;;weasel:
(if-not (ws-repl/alive?)
  (ws-repl/connect "ws://{{weasel-host}}:{{weasel-port}}"))

;; figwheel
(fw/watch-and-reload
  ;; :websocket-url "ws://localhost:{{figwheel-port}}/figwheel-ws" 
  :jsload-callback (fn [] (print "reloaded"))) ;; optional callback

(enable-console-print!)

(println "You can change this line an see the changes in the dev console")






;; (defn foo [a b]
;;   (+ a b))

;; (defn foo2 [a b]
;;   (+ a b))

;; (. js/console (log "And now it works!!!" (foo 1 2)))
;; (println "hell")(f)

;; (defonce state (atom {:text "hello2asdfasdf"}))

;; (println (str "the state is" @state))
