# 1단계: Gradle을 사용하여 프로젝트 빌드
FROM gradle:8.7-jdk17 AS builder

# 프로젝트 소스 코드와 Gradle 파일을 복사
COPY . /home/gradle/project

# 프로젝트 디렉토리로 이동
WORKDIR /home/gradle/project

# 프로젝트를 빌드
RUN gradle build --no-daemon -Dorg.gradle.vfs.watch=false -x test --stacktrace --debug --scan
