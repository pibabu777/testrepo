public class User {
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name.toUpperCase(); // Convert name to uppercase
    }

}
 