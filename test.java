import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        
        User user1 = new User(1, "Alice", 25);
        User user2 = new User(2, "Bob", 17);
        User user3 = new User(3, "Charlie", 20);

        List<User> users = Arrays.asList(user1, user2, user3);

        // Partition users based on age
        Map<Boolean, List<User>> partitionedUsers = users.stream()
                .collect(Collectors.partitioningBy(user -> user.age > 18));

        System.out.println("Users above 18: " + partitionedUsers.get(true));
        System.out.println("Users 18 or below: " + partitionedUsers.get(false));

        // Convert names to uppercase
        List<String> upperCaseNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        System.out.println("Uppercase Names: " + upperCaseNames);
    }
    
}
