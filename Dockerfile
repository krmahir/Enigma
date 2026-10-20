FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY src/Machine/ src/Machine/
COPY src/Web/ src/Web/
RUN mkdir -p build && javac -encoding UTF-8 -d build src/Machine/Enigma.java src/Machine/PlugBoard.java src/Machine/Reflector.java src/Machine/Rotor.java src/Web/Server.java
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build ./build
COPY web ./web
ENV PORT=8080
EXPOSE 8080
CMD ["java","-cp","build","Web.Server"]