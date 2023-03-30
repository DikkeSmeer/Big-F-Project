package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaver<T> {

    private final Gson gson;
    private String fileName = "savedObjects.json";
    private List<T> objects;

    public ObjectSaver(String database) {
        this.fileName = database;
        gson = new GsonBuilder().setPrettyPrinting().create();
        objects = new ArrayList<>();
    }

    public ObjectSaver(List<T> objects, String database) {
        this.fileName = database;
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.objects = objects;
    }

    public void addObject(T obj) {
        objects.add(obj);
    }

    public void saveObjects() {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(objects, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
