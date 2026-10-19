# Cache Stampede & Thundering Herd

**Roadmap coverage:** Cache Stampede; Thundering Herd

A cache stampede occurs when many requests miss or expire together and concurrently load the same expensive origin value. This example coalesces same-key loads with a per-key future (single-flight).

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.stampede.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Mitigations

Coalesce concurrent same-key misses (single-flight), add random TTL jitter, refresh popular data before expiration, serve stale-while-revalidate when acceptable, and cap origin concurrency. Distributed deployments may need a distributed lease, but leases need expiration, fencing, and safe failure semantics.

## Trade-offs

Request coalescing reduces duplicate work; stale-while-revalidate, jittered TTLs, and rate limits are other tools. Coordination can itself add complexity and failure modes.

## Anti-patterns to avoid

Synchronized global locks, identical short TTLs across a large key set, or unbounded retries that amplify origin overload.

## Sources

[AWS caching challenges and strategies](https://aws.amazon.com/builders-library/caching-challenges-and-strategies/)
