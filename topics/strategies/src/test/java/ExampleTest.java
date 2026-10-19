package learning.caching.strategies;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void cacheAsideLoadsOnMiss() { assertTrue(Example.flow(Example.Strategy.CACHE_ASIDE).appLoadsOnMiss()); }
 @Test void writeThroughAndBehindHaveDifferentDurabilityTiming() { assertTrue(Example.flow(Example.Strategy.WRITE_THROUGH).writeImmediatelyToStore());assertTrue(Example.flow(Example.Strategy.WRITE_BEHIND).deferredWrite()); }
}
