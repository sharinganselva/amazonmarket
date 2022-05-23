FROM maven:3.8.5-openjdk-18
COPY src/ /home/amazonMarketV1/src/
COPY Drivers/ /home/amazonMarketV1/Drivers
COPY Resources/ /home/amazonMarketV1/Reources
COPY pom.xml /home/amazonMarketV1
RUN mvn -f /home/amazonMarketV1/pom.xml clean test -DsuiteXmlFile=TestNG.xml
# RUN mvn -f /home/amazonMarketV1/pom.xml clean test -Dsurefire.suiteXmlFiles=/home/amazonMarketV1/TestNG.xml
# RUN mvn -f /home/amazonMarketV1/pom.xml clean test
# RUN mvn clean test