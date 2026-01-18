public class Manifold {
    int size;
    void setSize(int s){
        size = s;
    }

    int getSize(){
        return size;
    }

    Manifold(int s){
        this.size = s;
    }
    public static void main(String[] args) {
        User first = new User("Jameel", 21, "Nigeria");
        System.out.println(first);
        
        Manifold myManifold = new Manifold(25);
        System.out.println(myManifold.getSize());
    }
}
