FROM java:alpine
EXPOSE 9000
COPY target/WildWest.jar .
CMD java -jar WildWest.jar