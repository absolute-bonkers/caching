# Cache Invalidation

**Roadmap coverage:** Cache Invalidation

Invalidation removes or makes obsolete cached data when its source changes. Versioned keys and tags can target logical data groups; TTL bounds stale duration but does not guarantee immediate freshness.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.invalidation.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Common techniques

Invalidate exact keys after a write, publish tags/groups for related entries, use versioned keys so new readers stop addressing old values, or accept a bounded stale window with TTL. If invalidation is asynchronous, make event loss and ordering recoverable (for example, reconcile or version-check at read time).

## Trade-offs

Eager invalidation provides freshness but adds write-path coupling and race conditions. Versioning is robust but can temporarily retain old entries.

## Anti-patterns to avoid

“There are only two hard things…” is not an invalidation strategy: define ownership, ordering, and behavior when invalidation messages are lost.

## Sources

[AWS caching best practices](https://aws.amazon.com/caching/best-practices/)
