public class TailRecTests {


    private static int facTail(int n){
        return foo(n, 1);
    }

    private static int foo(int n, int i) {
        if (n == 1) return i;
        else return foo(n-1, i *n);
    }

    private static int fibonTail(int n){
        return goo(n, 0, 1);
    }

    private static int goo(int n, int i, int j) {
        if (n == 0) return i;
        if (n == 1) return j;
        return goo(n-1, j, i + j);
    }

    public static void main(String[] args) {
        System.out.println(fibonTail(4));
    }

}
