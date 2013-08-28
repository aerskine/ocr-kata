(ns ocr-kata.core
  (:require [clojure.java.io :as io]))

(def zero-to-nine-lines
  [" _     _  _     _  _  _  _  _ "
   "| |  | _| _||_||_ |_   ||_||_|"
   "|_|  ||_  _|  | _||_|  ||_| _|"])

(defn partition-digits [ls]
  (map #(partition-all 3 %) ls))

(defn zip-all [colls]
  (apply (partial map vector) colls))

(defn ocr-digits [ls]
  (zip-all (partition-digits ls)))

(def ocr-digit-to-char
  (zipmap (ocr-digits zero-to-nine-lines) "0123456789"))

(defn ocr-lines-to-digit-string [ls]
  (->> (ocr-digits ls)
       (map ocr-digit-to-char)
       (apply str)))

(defn ocr [ls]
  (map ocr-lines-to-digit-string (partition-all 3 4 ls)))

(defn -main [& args]
  (with-open [rdr (io/reader *in*)]
    (doseq [n (ocr (line-seq rdr))]
      (println n))))
