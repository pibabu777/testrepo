import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @GetMapping("/run")
    public String runApp() {
        StringBuilder output = new StringBuilder();

        Car myCar = new Car();
        Bike myBike = new Bike();
        myCar.color = "Red1";
        myCar.drive();
        myBike.drive();
        myBike.color = "Blue";

        output.append("Car color: ").append(myCar.color).append("\n");
        output.append("Bike max speed: ").append(myBike.maxSpeed).append("\n");

        Animal a12;
        a12 = new Dog();
        a12.sound();
        a12 = new Cat();
        a12.sound();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String created_ts = currentDateTime.format(formatter);
        output.append("Current Date and Time: ").append(created_ts).append("\n");

        // Add more logic as needed...

        return output.toString();
    }
}
