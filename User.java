public class User {
    private String name;
    private int age;
    private String country;

    public User(String name , int age , String country){
        this.name = name;
        this.age = age;
        this.country = country;
    }

    void getAllNames(String name, String country){
        System.out.println("Names " +  name + " and " + " Country: " + country);
    }
}
