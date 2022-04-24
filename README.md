# Musselcracker
Content management system

# Musselcracker Headless

### Musselcracker Content Management Application (CMA)

### Musselcracker Content Delivery Application (CDA) 


## Setup Dev environment

### Podman & KeyCloak
podman run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.0 start-dev

### Podman & Casandra
podman run -p 9042:9042 --name cass_cluster cassandra:latest

podman exec -it cass_cluster cqlsh
