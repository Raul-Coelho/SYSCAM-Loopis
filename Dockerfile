FROM java:8
ADD /target/SYSCAM-Loopis.jar SYSCAM-Loopis.jar
EXPOSE 8085 8090 
ENTRYPOINT ["java","-jar","SYSCAM-Loopis.jar"]
