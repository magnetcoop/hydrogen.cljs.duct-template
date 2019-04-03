;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

{{=<< >>=}}
(ns <<namespace>>.api.config
  (:require [compojure.core :refer [GET]]
            [integrant.core :as ig]))

(defmethod ig/init-key :<<namespace>>.api/config [_ {:keys [iss client-id]}]
  (GET "/api/config" req
    (fn [req]
      (let [oidc-config {:iss iss
                         :client-id client-id}]
        {:status 200
         :body {:config oidc-config}
         :headers {"content-type" "application/json"}}))))
