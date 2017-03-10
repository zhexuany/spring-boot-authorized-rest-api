# Student Grade Management System

This Project is a pure backend project and provide a authorize RESTful api service.

Along with authroization, user(especially front end client) can fetct necessary data from this server.

## Set up mysql database
runing `mysql -u root -p` will promot you enter password for root user. When you enter the `mysql` shell, you have to create a databse named `sgs`. 
You can find `application.properties` inside `resource` directory which contains all related configuration for access databse.

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

The following is the ouput of runing `cUrl` command.
~~~
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
* Server auth using Basic with user 'clientapp'
> POST /oauth/token HTTP/1.1
> Host: localhost:8080
> Authorization: Basic Y2xpZW50YXBwOjEyMzQ1Ng==
> User-Agent: curl/7.51.0
> Accept: application/json
> Content-Length: 112
> Content-Type: application/x-www-form-urlencoded
>
* upload completely sent off: 112 out of 112 bytes
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Fri, 10 Mar 2017 09:12:50 GMT
<
* Curl_http_done: called premature == 0
* Connection #0 to host localhost left intact
{"access_token":"47e4e8dc-7306-4e85-bbc4-0e50c32aaa83","token_type":"bearer","refresh_token":"fc6fae08-9927-459e-898e-071d946486b1","expires_in":43199,"scope":"read write"}
~~~

## Improve the security
If you do not want to expose client id and client secret ouside production enviorment. You can get help from `nginx`.  The following `nginx` will automatically add client id and 
client secret in your request.
~~~
location ~ ^/oauth/v2/token$ {
      try_files $uri /$app$is_args$args&client_id=CLIENTID&client_secret=CLIENTSECRET;
}
~~~
