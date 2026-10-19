package learning.caching.distributed;
import java.time.*;import java.util.*;
public final class Example {
 static final class TtlCache<K,V>{record Entry<V>(V value,Instant expires){} Map<K,Entry<V>> data=new HashMap<>();void put(K k,V v,Instant now,Duration ttl){data.put(k,new Entry<>(v,now.plus(ttl)));}Optional<V> get(K k,Instant now){var e=data.get(k);if(e==null)return Optional.empty();if(!now.isBefore(e.expires())){data.remove(k);return Optional.empty();}return Optional.of(e.value());}}
 public static void main(String[] args){var c=new TtlCache<String,String>();var now=Instant.now();c.put("greeting","hello",now,Duration.ofMinutes(1));System.out.println(c.get("greeting",now));}
}
