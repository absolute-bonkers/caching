package learning.caching.eviction;
import java.time.*;import java.util.*;
public final class Example {
 static final class Lru<K,V>{private final int cap;private final LinkedHashMap<K,V> map=new LinkedHashMap<>(16,.75f,true);Lru(int c){if(c<1)throw new IllegalArgumentException();cap=c;}void put(K k,V v){map.put(k,v);if(map.size()>cap)map.remove(map.keySet().iterator().next());}V get(K k){return map.get(k);}}
 static final class Lfu<K,V>{private static final class Entry<V>{V value;int frequency=1;long used;Entry(V v,long t){value=v;used=t;}}private final int cap;private long clock;private final Map<K,Entry<V>> map=new HashMap<>();Lfu(int c){if(c<1)throw new IllegalArgumentException();cap=c;}void put(K k,V v){Entry<V> e=map.get(k);if(e!=null){e.value=v;e.frequency++;e.used=++clock;return;}if(map.size()==cap){K victim=map.entrySet().stream().min(Comparator.<Map.Entry<K,Entry<V>>>comparingInt(x->x.getValue().frequency).thenComparingLong(x->x.getValue().used)).orElseThrow().getKey();map.remove(victim);}map.put(k,new Entry<>(v,++clock));}V get(K k){Entry<V> e=map.get(k);if(e==null)return null;e.frequency++;e.used=++clock;return e.value;}}
 static boolean alive(Instant written,Duration ttl,Instant now){return now.isBefore(written.plus(ttl));}
 public static void main(String[] args){var c=new Lru<String,Integer>(2);c.put("a",1);c.put("b",2);c.get("a");c.put("c",3);var lfu=new Lfu<String,Integer>(2);lfu.put("a",1);lfu.get("a");lfu.put("b",2);lfu.put("c",3);System.out.println("LRU a="+c.get("a")+", LFU a="+lfu.get("a"));}
}
