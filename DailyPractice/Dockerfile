FROM openjdk:8               
VOLUME /tmp                   
EXPOSE 8000                 
ADD target/practice.jar practice.jar 
ENTRYPOINT ["java","-jar","/practice.jar"]   