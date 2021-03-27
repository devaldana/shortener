To run this project using docker you should:
1. Have docker installed.
2. Create a Dockerfile in the root project folder and add the next:
   ```
   FROM openjdk:11-jre-slim
   VOLUME /tmp
   COPY target/*.jar shortener.jar
   ENTRYPOINT ["java","-jar","/shortener.jar"]
   ```
3. Run `mnv package`
4. Run `docker build -t blue/shortener .`
5. Finally, run `docker run --name shortener -p 8080:8080 -d blue/shortener`

Now you can play with the API. For example: \
Request to short URL:
```
curl --location --request POST 'http://localhost:8080/urls' \
--header 'Content-Type: text/plain' \
--data-raw 'https://devspods.com'
```

Response:
```
b
```

Request to retrieve long URL:
```
curl --location --request GET 'http://localhost:8080/urls?shortUrl=b'
```

Response:
```
{
    "id": 1,
    "url": "https://devspods.com",
    "created": "2021-03-27T23:19:37.965039"
}
```