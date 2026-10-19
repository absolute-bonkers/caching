package learning.caching.invalidation;
import org.junit.jupiter.api.Test;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void versionedKeysSeparateOldAndNewValues() { assertNotEquals(Example.key("item",1),Example.key("item",2)); }
 @Test void targetedInvalidationRemovesEntityVersionsOnly() { var keys=new HashSet<>(List.of("item:1","item:2","other:1"));Example.invalidate(keys,"item");assertEquals(Set.of("other:1"),keys); }
}
