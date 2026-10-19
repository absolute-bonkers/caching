package learning.caching.eviction;
import org.junit.jupiter.api.Test;import java.time.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void lruEvictsLeastRecentlyUsed() { var c=new Example.Lru<String,Integer>(2);c.put("a",1);c.put("b",2);c.get("a");c.put("c",3);assertEquals(1,c.get("a"));assertNull(c.get("b")); }
 @Test void lfuEvictsLeastFrequentlyUsed() { var c=new Example.Lfu<String,Integer>(2);c.put("a",1);c.put("b",2);c.get("a");c.put("c",3);assertEquals(1,c.get("a"));assertNull(c.get("b")); }
 @Test void ttlExpiresAtBoundary() { var t=Instant.EPOCH;assertTrue(Example.alive(t,Duration.ofSeconds(5),t.plusSeconds(4)));assertFalse(Example.alive(t,Duration.ofSeconds(5),t.plusSeconds(5))); }
}
