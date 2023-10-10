/**
 * User : frederic
 * Date : 10/10/2023
 * Project Name : RecursieTesten
 */

public class Iteratie {
    private static int fac(int n){
        int result = 1;
        if (n == 0){
            return result;
        }
        for (int i = 1; i <= n; i++){
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fac(5));
    }
}
