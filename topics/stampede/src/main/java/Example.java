package learning.caching.stampede;
import java.util.concurrent.*;import java.util.concurrent.atomic.*;import java.util.function.Supplier;
public final class Example {
 static final class SingleFlight<K,V>{private final ConcurrentMap<K,CompletableFuture<V>> inFlight=new ConcurrentHashMap<>();V get(K key,Supplier<V> loader){var mine=new CompletableFuture<V>();var existing=inFlight.putIfAbsent(key,mine);if(existing!=null)return existing.join();try{V v=loader.get();mine.complete(v);return v;}catch(RuntimeException | Error t){mine.completeExceptionally(t);throw t;}finally{inFlight.remove(key,mine);}}}
 public static void main(String[] args){var count=new AtomicInteger();var sf=new SingleFlight<String,Integer>();System.out.println(sf.get("popular",count::incrementAndGet));}
}
