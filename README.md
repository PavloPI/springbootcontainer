How to build the project
========================

	gradlew clean build

How to build the docker image locally
=====================================

Go to the root of the project and run following command:

	gradlew clean build

	docker build -t springbootcontainer  .

How run the docker image locally
=====================================
	
	docker run --rm -p 8080:8080 springbootcontainer

