;; migrations/20140425174433134-create-notes.clj

(defn up []
  ["CREATE TABLE notes(id int)"])

(defn down []
  ["DROP TABLE notes"])
