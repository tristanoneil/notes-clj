(ns notes.test.handler
  (:use clojure.test
        ring.mock.request
        notes.handler)
  (:require [clojure.data.json :as json]))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

  (testing "/api/v1/notes route"
    (let [response (app (request :get "/api/v1/notes"))]
      (is (= (:status response) 200))
      (is (= (:body response) (json/write-str {:notes []})))))
