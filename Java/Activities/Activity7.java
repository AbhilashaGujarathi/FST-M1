package Java.Activities;

public class Activity7 {

    public static void main(String[] args) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}


interface BicycleParts {
    public int gears = 0;
    public int speed = 0;

}

interface BicycleOperations {
    public void applyBrake(int decrement);

    public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {
    public int gears;
    public int currentSpeed;


    public Bicycle(int gears, int speed) {
        this.gears = gears;
        this.currentSpeed = speed;
    }


    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed - decrement;
        System.out.println("Current speed: " + currentSpeed);
    }


    public void speedUp(int increment) {
        currentSpeed = currentSpeed + increment;
        System.out.println("Current speed: " + currentSpeed);
    }

    public String bicycleDesc() {
        return ("No of gears :  " + gears + "\nSpeed of bicycle is " + currentSpeed);
    }


}

class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int gears, int speed, int startHeight) {
        super(gears, speed);
        seatHeight = startHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc() + "\nSeat height is " + seatHeight);
    }
}