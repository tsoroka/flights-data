# Getting Started

### Reference Documentation
Application consists of 3 parts: 
* **service registry** - for registration of services, based on Netflix Eureka. 
* **flight-services**, which contains backend part. 
* **web**, which contains web ui.

### Guides
The following guides illustrate how to build and run all applications:
- Open cmd window in project root directory, type **gradlew.bat clean build**.
- Create file **/home/apps/flightservices/flights.csv**.
- Navigate to /service-registry/build/libs and run **java -jar service-registry-0.0.1-SNAPSHOT.jar**. Wait until registry is started. Service Registry can be accessed at http://localhost:8761/
- Navigate to /flightservices/build/libs and run **java -jar flightservices-0.0.1-SNAPSHOT.jar**. Service will be run at http://localhost:8001/flightservices/flights. 
- Navigate to /web/build/libs and run **java -jar web-0.0.1-SNAPSHOT.jar**. Web will be accessible at http://localhost:8777/ui/flights.





