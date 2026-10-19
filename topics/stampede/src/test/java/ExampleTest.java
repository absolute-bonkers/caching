package learning.caching.stampede;
import org.junit.jupiter.api.Test;import java.util.concurrent.*;import java.util.concurrent.atomic.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void concurrentMissesShareOneLoad() throws Exception { var sf=new Example.SingleFlight<String,Integer>();var calls=new AtomicInteger();var pool=Executors.newFixedThreadPool(8);try{var tasks=new java.util.ArrayList<Future<Integer>>();for(int i=0;i<8;i++)tasks.add(pool.submit(()->sf.get("k",()->{calls.incrementAndGet();try{Thread.sleep(30);}catch(InterruptedException e){Thread.currentThread().interrupt();}return 42;})));for(var f:tasks)assertEquals(42,f.get());assertEquals(1,calls.get());}finally{pool.shutdownNow();} }
 @Test void propagatesLoaderFailure() { var sf=new Example.SingleFlight<String,Integer>();assertThrows(IllegalStateException.class,()->sf.get("k",()->{throw new IllegalStateException();})); }
}
