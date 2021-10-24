install:
	./gradlew clean install
	
run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

.PHONY: build
build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain checkstyleTest
	

