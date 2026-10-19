package learning.caching.cdn;
import org.junit.jupiter.api.Test;import java.time.*;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void freshEdgeObjectServesWithoutOrigin() { var t=Instant.EPOCH;assertEquals("asset",Example.edgeHit(Map.of("/a",new Example.Response("asset",t.plusSeconds(1))),"/a",t).orElseThrow()); }
 @Test void staleOrUncachedObjectMisses() { var t=Instant.EPOCH;assertTrue(Example.edgeHit(Map.of("/a",new Example.Response("old",t)),"/a",t).isEmpty()); }
}
