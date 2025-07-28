

  

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



  

class Car {
    String color;
    void drive() {
        
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(); // myCar is an object
        myCar.color = "Red1";
        myCar.drive();
        System.out.println("Car has driven. Color: " + myCar.color);
        LocalDateTime currentDateTime = LocalDateTime.now();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

                    String created_ts = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + created_ts);
        Integer a = 1;
        Integer b = 1;
        int c ;
        String sub = "Hello";
        String sub2 = "Hello1";
        System.out.println(a == b);
         // This will print true because both are 1 in Java
        if (sub == sub2) {
            System.out.println("Strings are equal");
        } 
        else {
            System.out.println("Strings are not equal12");
        }
        if(a.equals(b)) {
            System.out.println("Integers are equal");
        } else {
            System.out.println("Integers are not equal");
        }
        // Removed redundant else block that caused syntax error
        
        Integer x = 100;
        Integer y = 100;

        System.out.println("Using == with Integer: " + (x == y)); // true (cached values)
        System.out.println("Using .equals() with Integer: " + x.equals(y)); // true

        Integer m = 200;
        Integer n = 300;
        System.out.println("Using == with Integer: " + (m == n)); 
         Main mainObj = new Main();
        mainObj.greenMethod();
        mainObj.blueMethod();// false (not cached)
        if (a == b) {
            System.out.println("Condition is true");
        } else {
            System.out.println("Condition is false");
            
        }


            int [] arr = {12, 34, 56, 78, 90};
            int target = 56;
            for (int i = 0; i < arr.length; i++) {
             if(arr[i] == target) {
            System.out.println("Element found at index places: " + i);
            break;
             }}

             
        // int[] arr = {12, 34, 56, 78, 90};
        // int target = 56;

        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] == target) {
        //         System.out.println("Element found at index: " + i);
        //         break;
        //     }}
    }
    // Adding new methods outside main
    void greenMethod(){
        System.out.println("This is a green method12");
    }

    void blueMethod(){
        System.out.println("This is a blue method");
    }
}
