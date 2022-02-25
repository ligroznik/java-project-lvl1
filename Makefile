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
