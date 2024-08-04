# 1단계: Gradle을 사용하여 프로젝트 빌드
FROM gradle:8.7-jdk17 AS builder

# 프로젝트 소스 코드와 Gradle 파일을 복사
COPY . /home/gradle/project

# 프로젝트 디렉토리로 이동
WORKDIR /home/gradle/project

# 프로젝트를 빌드
RUN gradle build --no-daemon -x test

# 2단계: OpenJDK를 사용하여 애플리케이션 실행
FROM openjdk:17-jdk-alpine

# 애플리케이션 디렉토리를 생성
WORKDIR /app

# 빌드된 JAR 파일을 복사
COPY --from=builder /home/gradle/project/build/libs/*.jar /app/application.jar

# 포트를 노출
EXPOSE 8080

# 애플리케이션을 실행 수정
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
