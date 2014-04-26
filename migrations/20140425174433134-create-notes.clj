;; migrations/20140425174433134-create-notes.clj

(defn up []
  ["CREATE TABLE notes(id serial not null, title text not null, body text)"])

(defn down []
  ["DROP TABLE notes"])
