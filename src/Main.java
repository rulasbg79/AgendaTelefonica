import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int option;

        do {
            System.out.println("\n--- Agenda Telefónica ---");
            System.out.println("1. Mostrar contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Ingrese el número de teléfono: ");
                    String number = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String name = scanner.nextLine();
                    addressBook.create(number, name);
                    break;
                case 3:
                    System.out.print("Ingrese el número de teléfono a eliminar: ");
                    String deleteNumber = scanner.nextLine();
                    addressBook.delete(deleteNumber);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 4);

        scanner.close();
    }
}
