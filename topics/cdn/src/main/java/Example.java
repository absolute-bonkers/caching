package learning.caching.cdn;
import java.time.*;import java.util.*;
public final class Example {
 record Response(String body,Instant expires) {}
 static Optional<String> edgeHit(Map<String,Response> edge,String path,Instant now){var r=edge.get(path);return r!=null&&now.isBefore(r.expires())?Optional.of(r.body()):Optional.empty();}
 public static void main(String[] args){var t=Instant.EPOCH;System.out.println(edgeHit(Map.of("/logo.svg",new Response("svg",t.plusSeconds(60))),"/logo.svg",t));}
}
