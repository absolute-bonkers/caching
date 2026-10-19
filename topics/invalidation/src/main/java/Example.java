package learning.caching.invalidation;
import java.util.*;
public final class Example {
 static String key(String entity,long version){return entity+":v"+version;}
 static <V> void invalidate(Set<String> cache,String entity){cache.removeIf(k->k.startsWith(entity+":"));}
 public static void main(String[] args){System.out.println(key("product:7",3));}
}
