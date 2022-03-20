# REST-for-GPS-coordinates
 
## General info
The project's aim was to create REST web application to receive and store geographic coordinates of the mobile devices like mobile phone or GPS tracker.
The application was created with Spring Boot 2. Application logging is made with Lombok and SLF4J. Tests are written with Mockito and Junit 5. 

## Comunication
You can communicate with the appliaction via Http POST request and JSON as body. 
Example: {'deviceId':'12345', 'latitiude': 505430, 'longitude': 1423412}

## Technologies
Project is created with:
* Java
* Spring boot 2
* H2 database
* JUnit 5
* Mockito
