# 베이스 이미지 설정
FROM openjdk:11

# JAR 파일 경로 인자 설정
ARG JAR_FILE=target/*.jar

## JAR 파일을 이미지 내의 app.jar로 복사
#COPY ${JAR_FILE} app.jar

# Copy the JAR file into the container
#COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
# 애플리케이션 JAR 파일 및 관련 파일 복사
COPY target/demo-*.jar app.jar
COPY src/main/resources/application.properties application.properties

# 애플리케이션 실행 포트 설정
EXPOSE 8090

# 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]