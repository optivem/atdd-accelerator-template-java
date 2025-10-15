# System Test (Java)

## Instructions

1. Open up the 'system-test' folder in IntelliJ (make sure it is at the root of your project)

2. Start Docker Containers

```shell
docker compose up -d
```

3. Run All Tests

```shell
./gradlew test
```

4. Run Smoke Tests Only

```shell
./gradlew test --tests com.optivem.atddaccelerator.template.systemtest.smoketests.*
```

5. Stop Docker Containers

```shell
docker compose down
```