public class Manifold {
    int size;
    void setSize(int s){
        size = s;
    }

    int getSize(){
        return size;
    }
    public static void main(String[] args) {
        User first = new User("Jameel", 21, "Nigeria");
        System.out.println(first);
        
        Manifold myManifold = new Manifold();
        myManifold.setSize(25);
        System.out.println(myManifold.getSize());
    }
}
