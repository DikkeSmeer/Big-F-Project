package classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObjectLoader<T> {

    private final Gson gson;
    private String fileName;
    private Type objectType;

    public ObjectLoader(Class<T> clazz, String database) {
        this.fileName = database;
        gson = new Gson();
        objectType = TypeToken.getParameterized(List.class, clazz).getType();
    }

    public List<T> loadObjects() {
        List<T> objects;
        try (Reader reader = new FileReader(fileName)) {
            objects = gson.fromJson(reader, objectType);
        } catch (IOException e) {
            e.printStackTrace();
            objects = new ArrayList<>();
        }
        return objects;
    }
}
