FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/workspace/learn

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar        selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs                       libs

# ADD any other dependencies like  .csv/ .json ./xls

# ADD suite files

ADD book-flight-module.xml  book-flight-module.xml
ADD search-module.xml  search-module.xml

ADD healthcheck.sh     healthcheck.sh
# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh

# ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

#for file upload we need to add this snippet before actual selenium code to upload file -> as the file is in a different machine
# assuming driver is the name of the variable for WebDriver instance.
# if(driver instanceof RemoteWebDriver){
#    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
# }



