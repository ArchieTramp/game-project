FROM tomcat:9-jdk8
COPY target/WildWest.war /usr/local/tomcat/webapps/ROOT.war