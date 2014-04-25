(defproject notes "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-json "0.3.1"]
                 [org.clojure/data.json "0.2.4"]
                 [korma "0.3.0-RC5"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]]
  :plugins [[lein-ring "0.8.10"]
            [clj-sql-up "0.3.1"]]
  :clj-sql-up {:database "jdbc:postgresql://127.0.0.1:5432/notes"
               :deps [[org.postgresql/postgresql "9.3-1100-jdbc4"]]}
  :ring {:handler notes.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
