install:
	./gradlew clean install

run-install:
	./build/install/app/bin/app

install-and-run: lint install run-install

check-updates:
	./gradlew dependencyUpdates

run:
	./gradlew run

lint:
	./gradlew checkstyleMain

build: lint
	./gradlew clean build






