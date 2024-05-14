package Java.Activities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Activity4 {

    public static void main(String[] args) {
        int[] numberArray = {10, 15, 5, 12, 30, 25};
        sortArray(numberArray);
    }

    public static void sortArray(int[] array) {
        System.out.println("Array before sorting : " + Arrays.toString(array));

        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        System.out.println("Array After sorting : " + Arrays.toString(array));
    }
}
