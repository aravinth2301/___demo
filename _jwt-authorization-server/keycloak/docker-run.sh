#docker run -p 8080:8080 jboss/keycloak
docker run \
-e KEYCLOAK_USER="admin" \
-e KEYCLOAK_PASSWORD="admin" \
-p 8080:8080 \
-p 9990:9990 \
jboss/keycloak