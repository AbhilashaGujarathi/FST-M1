package Java.Activities;

public class Activity8 {

    public static void main(String[] a) {
        try {

            exceptionTest("Will print to console");
            exceptionTest(null);
            exceptionTest("Won't execute");
        } catch (CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }

}

class CustomException extends Exception {
    private String message;


    CustomException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
