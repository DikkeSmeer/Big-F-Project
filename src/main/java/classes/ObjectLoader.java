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

    private final Gson gson; // Een Gson-object om JSON-serialisatie en -deserialisatie uit te voeren.
    private String fileName; // Naam van het bestand waaruit de objecten worden geladen.
    private Type objectType; // Het type van de objecten dat uit het JSON-bestand wordt geladen.

    public ObjectLoader(Class<T> clazz, String database) {
        this.fileName = database; // Geef de naam van het JSON-bestand door aan de instantievariabele fileName.
        gson = new Gson(); // Initialiseer de gson-instantievariabele met een nieuw Gson-object.
        objectType = TypeToken.getParameterized(List.class, clazz).getType(); // Geef het type van de objecten door aan de objectType-instantievariabele.
    }

    public List<T> loadObjects() {
        List<T> objects; // Lijst van objecten die worden geladen.
        try (Reader reader = new FileReader(fileName)) { // Open een Reader-object om de JSON-gegevens uit het bestand te lezen.
            objects = gson.fromJson(reader, objectType); // Deserialiseer de JSON-gegevens naar een lijst van objecten met behulp van het Gson-object en objectType.
        } catch (IOException e) { // Vang IOException op als er een fout optreedt bij het lezen van het bestand.
            e.printStackTrace(); // Print de foutmelding naar de standaardfout.
            objects = new ArrayList<>(); // Initialiseer een nieuwe, lege lijst van objecten.
        }
        return objects; // Geef de lijst van objecten terug.
    }
}
