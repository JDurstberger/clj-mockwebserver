(ns clj-mockwebserver.core-test
  (:require
    [clojure.test :refer :all]
    [clj-http.client :as client]
    [clj_mockwebserver.core :as mws])
  )

(def client-options
  {:socket-timeout 200 :connection-timeout 200})

(def server (mws/new-server))

(defn fixture [f]
  (mws/start server)
  (f)
  (mws/shutdown server))

(use-fixtures :each fixture)

(deftest responds-with-200-for-simple-request
  (let [server-url (mws/url server)
        _ (mws/enqueue server)
        response (client/get (str server-url "/some-resource") client-options)]
    (is (= 200 (:status response)))))
