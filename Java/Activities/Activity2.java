package Java.Activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] array  = {10, 77, 10, 54, -11, 10};
       System.out.println(checkSum(array));
       checkSum(array);
    }

    public static boolean checkSum( int[] numArray ) {
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == 10) {
                sum = numArray[i] + sum;
            }
        }
        if (sum==30){
            return true ;
        }
        return false;
    }
}
