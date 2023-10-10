import java.time.Duration;
import java.time.Instant;
import java.util.Timer;

public class MergeSort {
    private static int[] initArray = new int[10];
    private static int initLength = initArray.length;

    private static void fillArray() {
        for (int i = 0; i < initLength; i++) {
            initArray[i] = (int) (1 + Math.random() * 10000);
        }
    }

    private static void printArray() {
        for (int i = 0; i < initLength; i++) {
            System.out.println(initArray[i]);
        }
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int leftSideLength = inputLength / 2;
        int rightSideLength = inputLength - leftSideLength;
        int[] leftHalf = new int[leftSideLength];
        int[] rightHalf = new int[rightSideLength];


        for (int i = 0; i < leftSideLength; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = leftSideLength; i < inputLength; i++) {
            rightHalf[i - leftSideLength] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }


    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            }
            else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }


    }

    public static void main(String[] args) throws InterruptedException {
        fillArray();
        System.out.println("Before:");
        Instant starts = Instant.now();
        Thread.sleep(10);
        printArray();
        mergeSort(initArray);
        System.out.println("After:");
        printArray();
        Instant ends = Instant.now();
        System.out.println(Duration.between(starts, ends));

    }


}
