(ns crypto.password.bcrypt
  "Functions for encrypting passwords using the widely-used bcrypt algorithm."
  (:import org.mindrot.jbcrypt.BCrypt))

(defn encrypt
  "Encrypt a password string using the BCrypt algorithm. The optional work
  factor is the log2 of the number of hashing rounds to apply. The default
  work factor is 10."
  ([raw]
     (BCrypt/hashpw raw (BCrypt/gensalt)))
  ([raw work-factor]
     (BCrypt/hashpw raw (BCrypt/gensalt work-factor))))

(defn check
  "Compare a raw string with a string encrypted with the
  crypto.password.bcrypt/encrypt function. Returns true the string match, false
  otherwise."
  [raw encrypted]
  (BCrypt/checkpw raw encrypted))
