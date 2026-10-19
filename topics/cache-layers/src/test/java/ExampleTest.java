package learning.caching.layers;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void applicationCacheAvoidsRepeatedDatabaseReads() { var s=new Example.Service();assertEquals("row-1",s.get(1));assertEquals("row-1",s.get(1));assertEquals(1,s.dbReads.get()); }
 @Test void distinctKeysLoadIndependently() { var s=new Example.Service();s.get(1);s.get(2);assertEquals(2,s.dbReads.get()); }
}
