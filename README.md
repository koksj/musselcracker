# Musselcracker
Content management system

Three componentes 
* Musselcracker Headless
* Musselcracker Content Management Application (CMA)
* Musselcracker Content Delivery Application (CDA)

### Musselcracker Headless

### Musselcracker Content Management Application (CMA)

### Musselcracker Content Delivery Application (CDA) 


## Setup Dev environment

### Podman & KeyCloak
podman run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.0 start-dev

### Podman & Cassandra
podman run -p 9042:9042 --name cass_cluster cassandra:latest

### Podman & Cassandra  CQLSH
podman exec -it cass_cluster cqlsh
