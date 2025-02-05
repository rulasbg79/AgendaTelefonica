import java.io.*;
        import java.util.*;

public class AddressBook {
    private HashMap<String, String> contacts;
    private final String fileName = "contacts.txt";

    public AddressBook() {
        contacts = new HashMap<>();
        load();
    }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontró un archivo de contactos. Se creará uno nuevo.");
        }
    }

    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos.");
        }
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Contactos:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public void create(String number, String name) {
        if (contacts.containsKey(number)) {
            System.out.println("El número ya existe en la agenda.");
        } else {
            contacts.put(number, name);
            save();
            System.out.println("Contacto guardado.");
        }
    }

    public void delete(String number) {
        if (contacts.remove(number) != null) {
            save();
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("El número no se encuentra en la agenda.");
        }
    }
}
