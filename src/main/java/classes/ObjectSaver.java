package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
public class ObjectSaver<T> {
    private List<T> objects = new ArrayList<>();
    private final String fileName;
    private final Gson gson = new Gson();

    public ObjectSaver(String fileName) {
        this.fileName = fileName;
    }

    public void addObject(T object) {
        objects.add(object);
    }

    public void saveObjects() {
        try (FileWriter file = new FileWriter(fileName)) {
            gson.toJson(objects, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add this new method to accept a list of objects
    public void saveObjects(List<T> objectList) {
        objects = objectList;
        saveObjects();
    }
}
