# CDN (Content Delivery Network)

**Roadmap coverage:** CDN (Content Delivery Network)

A CDN caches eligible content at geographically distributed edge locations, reducing origin load and user-perceived latency. The example models cache key + freshness as a local edge decision.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.cdn.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Edge cache keys

A CDN routes requests to an edge point of presence and may serve a cached response based on cache-control rules and its cache key (often URL plus selected request dimensions). Origin headers, purge/invalidation, and stale response policies decide freshness. Never share-cache personalized responses unless the key and authorization policy make it safe.

## Trade-offs

Edge delivery improves latency and resilience for cacheable content; invalidation and personalized responses complicate correctness and privacy.

## Anti-patterns to avoid

Caching user-specific responses under a shared key, or using broad purge operations as the normal update path.

## Sources

[Cloudflare cache documentation](https://developers.cloudflare.com/cache/)
