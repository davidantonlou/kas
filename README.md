
## KAS
Application to get Open Data Barcelona API information.

### Build and Run

`` docker-compose up ``

## API Endpoints

* http://<hostname>:8080/kas                - Get all the packages
* http://<hostname>:8080/kas/code/{code}    - Get packages by code

## Actuator Endpoints

* http://<hostname>:8080/info               - Get application information
* http://<hostname>:8080/health             - Get health status
* http://<hostname>:8080/metrics            - Get all metrics
* http://<hostname>:8080/metrics/{metric}   - Get specific metric details