package learning.caching.strategies;
public final class Example {
 enum Strategy { CACHE_ASIDE,WRITE_THROUGH,WRITE_BEHIND,READ_THROUGH }
 record Flow(boolean appLoadsOnMiss,boolean writeImmediatelyToStore,boolean deferredWrite) {}
 static Flow flow(Strategy s){return switch(s){case CACHE_ASIDE->new Flow(true,false,false);case WRITE_THROUGH->new Flow(false,true,false);case WRITE_BEHIND->new Flow(false,false,true);case READ_THROUGH->new Flow(false,false,false);};}
 public static void main(String[] args){for(var s:Strategy.values())System.out.println(s+" "+flow(s));}
}
