# Student Grade Management System

This Project is a pure backend project and provide a authorize RESTful api service.

Along with authroization, user(especially front end client) can fetct necessary data from this server.

## How to build
The folloing command will download necessary deperdency and compile this project.
~~~
./gradlew clean build
~~~

If you want to run this project, just type
~~~
./gradlew bootRun
~~~

## How to use this project
For now, all client id, client secret and generated token are stored in memory not in database. 
~~~
 curl -X POST -vu clientapp:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=spring&username=roy&grant_type=password&scope=read%20write&client_id=clientapp"
~~~
Above command will return a access token which can use in futrue to access authorized RESTful api.


