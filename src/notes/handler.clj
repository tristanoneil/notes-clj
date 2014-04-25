(ns notes.handler
  (:use [compojure.core]
        [ring.util.response]
        [korma.db]
        [korma.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defdb prod (postgres {:db "notes"}))

(defentity notes)

(defn get-all-notes []
  (response {:notes (select notes)}))

(defn create-note []
  (response "create some note"))

(defroutes api-routes
  (GET "/notes" [] (get-all-notes))
  (POST "/notes" [] (create-note)))

(defroutes main-routes
  (GET "/" [] "Hello World")
  (context "/api/v1" [] api-routes)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site main-routes)
    (middleware/wrap-json-body)
    (middleware/wrap-json-response)))
