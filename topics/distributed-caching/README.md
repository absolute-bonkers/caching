# Distributed Caching (Redis, Memcached)

**Roadmap coverage:** Redis; Memcached

A distributed cache exposes shared key/value state to multiple application processes. Redis and Memcached differ in data structures, persistence/replication options, eviction, and operational semantics; this example models a tiny TTL cache contract.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.distributed.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Redis and Memcached

Both are networked key/value cache choices, not interchangeable specifications. Redis offers data structures and persistence/replication options; Memcached focuses on a simple in-memory key/value cache and has its own eviction/expiration behavior. Compare the required data types, durability, clustering, client, and operational cost against current product docs. This example models a TTL key-value API only.

## Trade-offs

Shared cache increases hit rate across instances but adds a network dependency, consistency boundary, failure mode, and capacity/eviction planning.

## Anti-patterns to avoid

Putting the cache on the critical path without timeout/fallback policy, or assuming Redis and Memcached have identical features.

## Sources

[Redis documentation](https://redis.io/docs/latest/), [Memcached documentation](https://docs.memcached.org/)
