import java.time.Duration;
import java.time.Instant;

public class Sorting {
    private static int[] initArray = new int[1000000];
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
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static void bubbleSort(int[] inputArray) {
        int inputLength = inputArray.length;
        int temp;
        boolean swappdSomething = true;
        while (swappdSomething) {
            swappdSomething = false;
            for (int i = 0; i < inputLength - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    swappdSomething = true;
                }
            }
        }
    }

    private static void insertionSort(int[] inputArray) {
        int inputLength = inputArray.length;

        for (int i = 1; i < inputLength; i++) {
            int currentValue = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > currentValue) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void quickSort(int[] inputArray, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = inputArray[highIndex];
        int leftPointer = lowIndex, rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(inputArray, leftPointer, rightPointer);
        }
        swap(inputArray, leftPointer, highIndex);
        quickSort(inputArray,lowIndex, leftPointer - 1);
        quickSort(inputArray,leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static void main(String[] args) throws InterruptedException {
        fillArray();
        System.out.println("Before:");
        Instant starts = Instant.now();
        Thread.sleep(10);
//        printArray();
//        bubbleSort(initArray);
//        mergeSort(initArray);
        quickSort(initArray, 0, initLength - 1);
//        insertionSort(initArray);
        System.out.println("After:");
//        printArray();
        Instant ends = Instant.now();
        System.out.println(Duration.between(starts, ends));

    }


}
