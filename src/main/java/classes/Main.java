package classes;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HoofdMenu menu = new HoofdMenu();
        menu.createMenu();
        menu.execute(menu.printMenu());

        /* Save Objects */

        ObjectSaver<MyClass> objectSaver = new ObjectSaver<>("MyClassDB.json");

        MyClass obj1 = new MyClass("John", 25);
        MyClass obj2 = new MyClass("Jane", 28);

        objectSaver.addObject(obj1);
        objectSaver.addObject(obj2);
        objectSaver.saveObjects();

        /* Load Objects */

//        ObjectLoader<MyClass> objectLoader = new ObjectLoader<>(MyClass.class, "MyClassDB.json");
//
//        List<MyClass> loadedObjects = objectLoader.loadObjects();
//
//        for (MyClass obj : loadedObjects) {
//            System.out.println("Name: " + obj.getName() + ", Age: " + obj.getAge());
//        }
    }
}

class MyClass {
    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}