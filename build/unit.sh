#!/bin/bash -ex
set -ex
cd restservice/leavemanager/
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -Dbuild.number=${BUILD_NUMBER}
cd ../integration-test
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -DskipTests
cd ../../webui/lm-app
# Here we run the jasmine test
npm install
ng lint --type-check
ng test --watch false
ng build
cp ../../restservice/leavemanager/target/ftp88-0.0.1-${BUILD_NUMBER}.war ./ftp88.war
cd ..
tar -cvzf lm-app.zip lm-app/*
cd lm-app/dist
jar -uvf ../ftp88.war *
cd ../../../build
cp ../webui/lm-app/ftp88.war .
cp ../webui/lm-app.zip .
cp ../restservice/integration-test/target/ftp88-integration-tests-1.0-test-sources.jar .
cp ../database/database.* .
tar -cvzf ftp88-${BUILD_NUMBER}.tar.gz ftp88.war ftp88-integration-tests-1.0-test-sources.jar lm-app.zip database.* *.sh
echo TAR_FILE=ftp88-${BUILD_NUMBER}.tar.gz > build.properties
/usr/local/bin/aws s3 cp ftp88-${BUILD_NUMBER}.tar.gz s3://com.hexaware.builds.ftp/