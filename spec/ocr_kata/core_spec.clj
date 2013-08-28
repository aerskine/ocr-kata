(ns ocr-kata.core-spec
  (:require [speclj.core :refer :all]
            [ocr-kata.core :refer :all]))

(def test-lines
  [[11 12 13 14 15 16]
   [21 22 23 24 25 26]
   [31 32 33 34 35 36]])

(describe "partition-digits"
  (it "should partition each line into groups of 3"
    (def expected 
      [[[11 12 13] [14 15 16]]
       [[21 22 23] [24 25 26]]
       [[31 32 33] [34 35 36]]])
    (def actual (partition-digits test-lines))
    (should= expected actual)))

(describe "zip-all"
  (it "should zip  one or more collections element-wise into vectors"
    (def expected
      [[11 21 31] [12 22 32] [13 23 33] [14 24 34] [15 25 35] [16 26 36]])
    (def actual (zip-all test-lines))
    (should= expected actual)))

(describe "ocr-digits"
  (it "should compose zip-all with partition-digits to assemble 3x3 'digits'"
    (def expected
      [['(11 12 13)
        '(21 22 23)
        '(31 32 33)]
       ['(14 15 16)
        '(24 25 26)
        '(34 35 36)]])
    (def actual (ocr-digits test-lines))
    (should= expected actual)))

(describe "ocr-lines-to-digit-string"
  (it "should convert ocr lines to a sequence of 'digits' and map to chars"
    (def expected "0123456789")
    (def actual (ocr-lines-to-digit-string zero-to-nine-lines))
    (should= expected actual)))

(run-specs)
