package Java.Activities;

public class Activity1 {

    public static void main(String[] args) {

        Car carName = new Car();

        carName.make = 2014;
        carName.color = "Black";
        carName.transmission = "Manual";

        carName.displayCharacteristics();
        carName.accelarate();
        carName.brake();
    }
}

class Car {

    public String color;
    public String transmission;
    public int make;
    public int tyres;
    public int doors;

    public Car(){
        tyres =4;
        doors =4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of car is " + color);
        System.out.println("Transmission of car is " + transmission);
        System.out.println("Make of car is " + make);
        System.out.println("Number of Tyres in car is " + tyres);
        System.out.println("Number of Doors in car is " + doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    }

    public void brake(){
        System.out.println("Car has stopped.");
    }
}

