package learning.caching.distributed;
import org.junit.jupiter.api.Test;import java.time.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void sharesValueUntilExpiry() { var c=new Example.TtlCache<String,String>();var t=Instant.EPOCH;c.put("k","v",t,Duration.ofSeconds(2));assertEquals("v",c.get("k",t.plusSeconds(1)).orElseThrow());assertTrue(c.get("k",t.plusSeconds(2)).isEmpty()); }
 @Test void missingKeyIsMiss() { assertTrue(new Example.TtlCache<>().get("none",Instant.EPOCH).isEmpty()); }
}
