# Benchmark Assignment Run Instructions

## Pre-requisits 
- Maven installed in the system
- JDK 1.8 or higher

1) Checkout the code from the repo
2) type **mvn tomcat7:run-war**
3) Using a desktop rest client type the following URL
```
http://localhost:8080/findCheapest?origin=NYC&destination=MAD&departureDate=2019-08-01&key=ChG3OYnhqxSmQYFJeahvLDzSrnUL
```
## NOTE 
The key property is the Amadeus authorization key. Please make sure to get a proper key.

## DEBUG
Please don't use a browser based REST client as it's not able to connect to localhost. 
You can run deply the way in a proper web server if you prefer.
