# 베이스 이미지 설정
FROM eclipse-temurin:17-jdk

# 작업 디렉터리 설정
WORKDIR /app

# .env 파일 복사
COPY .env /app/.env

# JAR 파일 복사
COPY build/libs/Farm-In-Server-Test-0.0.1-SNAPSHOT.jar /app/app.jar

# 실행 명령어 설정
CMD ["java", "-jar", "/app/app.jar", "--spring.config.location=file:/app/.env"]
