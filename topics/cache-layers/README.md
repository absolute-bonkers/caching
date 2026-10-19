# Application-Level vs Database-Level Caching

**Roadmap coverage:** Application-Level Caching; Database-Level Caching

Application caches are explicitly owned by app code and can cache computed/domain results. Database buffer/query caches are internal to the database and optimize storage access; neither replaces the other.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.layers.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Where caching lives

An application-level cache stores an application-selected response or domain object and needs an explicit invalidation/freshness contract. A database buffer cache holds pages internally; query/result caches are engine-specific and have different semantics. Tune one layer at a time and compare end-to-end latency, query counts, and write costs.

## Trade-offs

App caches offer flexible keying but increase invalidation responsibility; database caches preserve database semantics but are constrained to engine-managed data and query plans.

## Anti-patterns to avoid

Double-caching without measuring end-to-end impact, or diagnosing a slow query with an application cache that hides its database cost.

## Sources

[PostgreSQL shared buffers](https://www.postgresql.org/docs/current/runtime-config-resource.html), [AWS caching best practices](https://aws.amazon.com/caching/best-practices/)
