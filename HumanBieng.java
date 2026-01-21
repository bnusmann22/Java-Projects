public class HumanBieng {
    
    String name;
    String country;
    int age;

    HumanBieng(String name, String country, int age){
        this.name = name;
        this.country = country;
        this.age = age;

    }

    public void setName(String s){
        name = s;
    }

     String getName(){
        return name;
    }
    public static void main(String[] args) {
        HumanBieng obj = new HumanBieng("John", "USA", 30);
        HumanBieng person2 = new HumanBieng("Zainab", "BUK", 20);
        HumanBieng person3 = new HumanBieng("Sadeeq", "BUK", 20);
        System.out.println(obj.getName());
        System.out.println(person2.getName());
        System.out.println(person3.getName());
    }
}
