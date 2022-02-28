install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

install-run:
	./gradlew clean install
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

run:
	./gradlew run
lint:
	./gradlew checkstyleMain

run-build: lint
	./gradlew clean build

