public class Hanoi {
    private static int i = 0;
    private static void hanoi(int numberOfDisksrom, char from, char via, char to) {

        if (numberOfDisksrom == 0) return;
        hanoi(numberOfDisksrom - 1, from, to, via);
        move(from, to);
        hanoi(numberOfDisksrom - 1, via, from, to);


    }

    private static void move(char from, char to) {
        System.out.println("Move disc from " + from + " to " + to);

    }

    public static void main(String[] args) {

        hanoi(4, 'A', 'B', 'C');
    }

}
