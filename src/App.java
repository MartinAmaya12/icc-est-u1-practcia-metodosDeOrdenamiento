import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] arreglo = { 12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3 };
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("==== PROGRAMA DE ORDENAMIENTO ====");
            System.out.println("1. Ejecutar ordenamientos");
            System.out.println("2. Salir");
            System.out.print("Elija una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();

                if (opcion == 1) {
                    boolean insAsc = getBooleanInput(sc, "¿Inserción ascendente? (true/false): ");
                    boolean shellAsc = getBooleanInput(sc, "¿Shell ascendente? (true/false): ");
                    System.out.println();

                    System.out.println("==== MÉTODO INSERCIÓN ====");
                    Insertion insertion = new Insertion();
                    // Enviamos una copia independiente del arreglo
                    int[] arrIns = Arrays.copyOf(arreglo, arreglo.length);
                    int[] statsIns = insertion.sort(arrIns, insAsc);

                    System.out.println("==== MÉTODO SHELL ====");
                    Shell shell = new Shell();
                    int[] arrShell = Arrays.copyOf(arreglo, arreglo.length);
                    int[] statsShell = shell.sort(arrShell, shellAsc);

                } else if (opcion == 2) {
                    System.out.println("Saliendo del programa...");
                    break;
                } else {
                    System.out.println("Error: Opción fuera de rango. Ingrese 1 o 2.\n");
                }
            } else {
                System.out.println("Error: Entrada inválida. Debe ingresar un número entero.\n");
                sc.next();
            }
        }
        sc.close();
    }

    
    private static boolean getBooleanInput(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.next().trim().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Error: Entrada inválida. Ingrese estrictamente 'true' o 'false'.");
            }
        }
    }
}