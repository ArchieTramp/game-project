FROM java:alpine
EXPOSE 8080
COPY target/WildWest.jar .
CMD java -jar WildWest.jar