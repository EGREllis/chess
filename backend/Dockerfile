FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY target/backend-0.0.1-SNAPSHOT.jar /opt/app/backend-springboot.jar
HEALTHCHECK --interval=1m --timeout=5s --start-period=15s --retries=3 \
  CMD curl --fail --silent localhost:8080/actuator/health | jq --exit-status -n 'inputs | if has(\"status\") then .status==\"UP\" else false end' > /dev/null || exit 1
CMD ["java", "-jar", "/opt/app/backend-springboot.jar"]


#ENTRYPOINT ["java", "-jar", "room-booker-springboot.jar"]

