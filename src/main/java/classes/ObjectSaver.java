package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaver<T> {

    private final Gson gson; // Een Gson-object om JSON-serialisatie en -deserialisatie uit te voeren.
    private String fileName = "savedObjects.json"; // Naam van het bestand waarin de objecten worden opgeslagen, standaard "savedObjects.json".
    private List<T> objects; // Lijst van objecten van hetzelfde type als aangeduid door de generieke parameter T, die opgeslagen moeten worden.

    public ObjectSaver(String database) {
        this.fileName = database; // Geef de naam van het JSON-bestand door aan de instantievariabele fileName.
        gson = new GsonBuilder().setPrettyPrinting().create(); // Initialiseer de gson-instantievariabele met een nieuw Gson-object.
        objects = new ArrayList<>(); // Initialiseer de objects-instantievariabele met een nieuwe ArrayList.
    }

    public ObjectSaver(List<T> objects, String database) {
        this.fileName = database; // Geef de naam van het JSON-bestand door aan de instantievariabele fileName.
        gson = new GsonBuilder().setPrettyPrinting().create(); // Initialiseer de gson-instantievariabele met een nieuw Gson-object.
        this.objects = objects; // Wijs de lijst van objecten die is doorgegeven als parameter toe aan de instantievariabele objects.
    }

    public void addObject(T obj) {
        objects.add(obj); // Voeg het doorgegeven object toe aan de lijst van objecten die opgeslagen moeten worden.
    }

    public void saveObjects() {
        try (Writer writer = new FileWriter(fileName)) { // Open een Writer-object om de JSON-gegevens naar het bestand te schrijven.
            gson.toJson(objects, writer); // Schrijf de lijst van objecten naar het JSON-bestand met behulp van het Gson-object.
        } catch (IOException e) { // Vang IOException op als er een fout optreedt bij het schrijven naar het bestand.
            e.printStackTrace(); // Print de foutmelding naar de standaardfout.
        }
    }
}
