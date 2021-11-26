(ns clj_mockwebserver.core
  (:import
    (okhttp3.mockwebserver MockWebServer MockResponse)))

(defn map->MockResponse
  []
  (MockResponse.))

(defn new-server []
  (MockWebServer.))

(defn start
  [^MockWebServer server]
  (.start server))

(defn shutdown
  [^MockWebServer server]
  (.shutdown server))

(defn url
  [^MockWebServer server]
  (str (.url server "")))

(defn enqueue
  [^MockWebServer server]
  (.enqueue server (map->MockResponse)))
