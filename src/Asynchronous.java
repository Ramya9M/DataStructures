//import java.util.concurrent.*;
//import java.util.*;
//
//public class Asynchronous {
//
//
//    public static void main(String args[]) throws ExecutionException, InterruptedException {
//
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        Future<List<Integer>> future = service.submit(()->{
//            TimeUnit.MINUTES.sleep(1);
//            return Arrays.asList(1,2,3,4);
//        });
//future.
//        System.out.println(future.get());
//    }
//}
