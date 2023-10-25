import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParrallelStreamExample {

    public static void main(String[] args) {
        long start = 0 ;
        long end = 0;

//        start = System.currentTimeMillis();
//        IntStream.range(1,1000).forEach(System.out::println);
//        end = System.currentTimeMillis();
//        System.out.println("Normal stream took " + (end - start) + " ms");
//
//        start = System.currentTimeMillis();
//        IntStream.range(1,1000).parallel().forEach(System.out::println);
//        end = System.currentTimeMillis();
//        System.out.println("Parrallel stream took " + (end - start) + " ms");

        IntStream.range(1,10).forEach(x ->{
            System.out.println("Thread: " + Thread.currentThread().getName() + "  - value: " + x);
        });

        IntStream.range(1,100).parallel().forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " - value: " + x);
        });


    }

}
