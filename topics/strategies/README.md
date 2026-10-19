# Caching Strategies

**Roadmap coverage:** Cache-Aside; Write-Through; Write-Behind; Read-Through

The strategies specify which component loads data and when writes reach the system of record. This executable policy shows where misses and writes are routed; it does not connect to a cache server.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.strategies.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Read and write paths

- **Cache-aside:** application checks cache; on miss reads the source, fills cache, then returns.
- **Read-through:** cache abstraction loads from the source on miss.
- **Write-through:** update cache and source in the write path (atomicity depends on implementation).
- **Write-behind:** acknowledge a cache write and persist later; requires durable queues/retries and accepts a defined loss window.

The `Flow` record captures only who loads and when persistence happens; real ordering and failure handling are system-specific.

## Trade-offs

Cache-aside is simple and flexible; read/write-through centralizes behavior; write-behind reduces write latency but risks loss and requires durable retry/reconciliation.

## Anti-patterns to avoid

Caching without an explicit source of truth, treating cache writes as durable in write-behind, or leaving stale values after updates.

## Sources

[AWS caching strategies](https://docs.aws.amazon.com/AmazonElastiCache/latest/dg/Strategies.html)
