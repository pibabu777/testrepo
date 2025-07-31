

  

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;








  

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
        System.out.println("Car has driven. Color1: " + myCar.color);
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
             List <String> list = new ArrayList<>();
             list.add("Sunil");
             list.add("Ravi");
              System.out.println("List elements: " + list);  
             list.remove(0);
             System.out.println("List elements: " + list);
             list.add("babu");
             System.out.println("List elements: " + list);
             list.get(0);
             list.set(0, "Ravi Kumar");
             list.add(0, "vamsi");
             System.out.println("List elements: " + list);

             
List<String> names = Arrays.asList("Sunil", "Ravi", "Kiran");

names.forEach(name -> System.out.println(name));

List<String> names1 = Arrays.asList("Level1", "Level2", "Level3");
names1.forEach(ver ->  System.out.println(ver));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Element2");
        linkedList.add("Element3");
        linkedList.forEach(bro -> System.out.println(bro));

       
        List<User> users = Arrays.asList(
            new User(1, "Sunil", 30),
            new User(2, "Ravi", 25),
            new User(3, "Kiran", 28) ,  
            new User(4, "Vamsi", 17 ),
            new User(5, "Babu", 14)
        );

       
Map<Boolean, List<User>> partitioned = users.stream()
            .collect(Collectors.partitioningBy(user -> user.age > 18));

           List<String> resultList  = users.stream().map(toUpperCase -> toUpperCase.getName()).collect(Collectors.toList());

            

        System.out.println("Adults (>18): " + partitioned.get(true) + "names:" + names);
        System.out.println("Minors (<=18): " + partitioned.get(false));

        System.out.println("Partitioned Users: " + partitioned + "names: " + names);
        System.out.println("Uppercase Names: " + resultList);

        

        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        List<String> uppercaseFruits = fruits.stream()
            .map(String::toUpperCase) // Convert each fruit name to uppercase
            .collect(Collectors.toList());

            System.out.println("Uppercase Fruits: " + uppercaseFruits);
        //List<String> uppercase = fruits.stream().map(fruits::uppercase).collect(Collectors.toList());


        // Fibonacci series code

        int n1 = 10;
        int a1 = 0, b1=1;

        for( int i = 0; i < n1; i++) {
            System.out.print(a1 + " ");
            int next = a1 + b1;
            a1 = b1;
            b1 = next;
        }


        







   
             


        // Uncomment the following lines to test the array search functionality
        // This code searches for a target element in an array and prints its index if found.

             
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
