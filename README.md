
## KAS
Application to get Open Data Barcelona API information.


### Build and Run
To build manually kas-api application:

``cd kas-api``

``gradle clean build``


For run the infraestructure from command-line:

``cd kas-api``

``gradle bootRun``


For run the infraestructure with Docker:

`` docker-compose up ``


## API Endpoints

* http://<hostname>:8080/kas                - Get all the packages
* http://<hostname>:8080/kas/code/{code}    - Get packages by code

## Actuator Endpoints

* http://<hostname>:8080/info               - Get application information
* http://<hostname>:8080/health             - Get health status
* http://<hostname>:8080/metrics            - Get all metrics
* http://<hostname>:8080/metrics/{metric}   - Get specific metric details