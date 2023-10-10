public class RecursiveTests {


    private static int recursiveSum(int x, int y) {
        if (y == 0) return x;
        else return 1 + recursiveSum(x, y - 1);
    }

    private static int recursiveMultiple(int x, int y) {
        if (y == 0) return 0;
        else return x + recursiveMultiple(x, y - 1);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n - 1);
    }

    private static int fibon(int n) {
        if (n == 0) return 1;
        else return 1 + fibon(n - 1);
    }

    private static int power(int x, int y){
        if (y == 0) return 1;
        else return x * power(x, y - 1);
    }

    static int n1 = 0, n2 = 1, n3, counter = 0;

    static void printFibonacci(int count) {
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            if (counter == 0) System.out.print(" " + 0);
            if (counter == 0) System.out.print(" " + 1);
            counter++;
            System.out.print(" " + n3);
            printFibonacci(count - 1);
        }
    }




    public static void main(String[] args) {
//        System.out.println(recursiveSum(5, 0));
//        System.out.println(recursiveSum(5, 5));
//        System.out.println(recursiveSum(5, 3));
//        System.out.println(recursiveMultiple(5, 0));
//        System.out.println(recursiveMultiple(5, 1));
//        System.out.println(recursiveMultiple(5, 2));
//        System.out.println(recursiveMultiple(5, 3));
//        System.out.println(factorial(5));
//        printFibonacci(5);
//        System.out.println(power(5,2));
//        System.out.println(factorial(5));
    }
}


