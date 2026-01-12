# parking-backend

## Run locally

Steps:

1. From the project root, build and start the app (dev profile):

```bash
./gradlew clean bootJar --no-daemon && java -jar build/libs/*.jar --spring.profiles.active=dev
```
