# Cache Eviction Policies

**Roadmap coverage:** LRU; LFU; TTL

LRU evicts least recently used entries, LFU least frequently used entries, and TTL expires entries by age. This example implements bounded LRU and LFU eviction plus TTL validity. LFU ties evict the least recently touched key.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.caching.eviction.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Policy behavior

**LRU** chooses the least recently accessed item; **LFU** chooses the least frequently accessed item (often with aging/tie-breaking); **TTL** expires an item after its time-to-live. TTL is freshness/retention, not by itself a memory-pressure eviction algorithm. The example uses an LRU map, LFU with recency tie-break, and a separate TTL boundary check.

## Trade-offs

Eviction is a workload fit: LRU adapts to recency, LFU can retain historically popular keys, TTL bounds staleness. Each has metadata and scan/cost tradeoffs.

## Anti-patterns to avoid

Choosing an eviction policy without measuring key popularity/working set, or assuming TTL alone bounds memory when entries may be unexpired.

## Sources

[Redis eviction policies](https://redis.io/docs/latest/develop/reference/eviction/)
