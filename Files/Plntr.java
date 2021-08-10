package Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Plntr {
 public static void main(String args[]){
     double dist = 100;
     CorreBolt s1 = new CorreBolt("usain bolt",0.5,0.0,dist);
     ExecutorService threadExecutor = Executors.newFixedThreadPool(5);
     threadExecutor.execute(s1);
     threadExecutor.shutdown();
 }
}