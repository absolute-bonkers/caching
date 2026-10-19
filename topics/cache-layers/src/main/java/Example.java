package learning.caching.layers;
import java.util.*;import java.util.concurrent.atomic.*;
public final class Example {
 static final class Service {final Map<Integer,String> appCache=new HashMap<>();final AtomicInteger dbReads=new AtomicInteger();String get(int id){return appCache.computeIfAbsent(id,k->{dbReads.incrementAndGet();return "row-"+k;});}}
 public static void main(String[] args){var s=new Service();System.out.println(s.get(1));System.out.println(s.get(1)+" dbReads="+s.dbReads);}
}
