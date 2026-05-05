public class Insertion {

    public int[] sort(int[] array, boolean asc) {
        int iteraciones = 0;
        int comparaciones = 0;
        int cambios = 0;

        System.out.println("Arreglo original:");
        imprimirArreglo(array);
        System.out.println("\n");

        for (int i = 1; i < array.length; i++) {
            iteraciones++;
            int j = i;
            System.out.print("I" + iteraciones + "\t");
            imprimirArreglo(array);

            boolean firstInIter = true;

            while (j > 0) {
                comparaciones++;
                int a = j - 1;
                int b = j;

                int valA = array[a];
                int valB = array[b];
                boolean cambio = false;

                // Condición para ascendente o descendente
                if (asc == true) {
                    if (valA > valB) {
                        array[a] = valB;
                        array[b] = valA;
                        cambio = true;
                        cambios++;
                    }
                } else {
                    if (valA < valB) {
                        array[a] = valB;
                        array[b] = valA;
                        cambio = true;
                        cambios++;
                    }
                }

                if (!firstInIter) {
                    System.out.print("\t");
                    imprimirArreglo(array); 
                }
                firstInIter = false;

                System.out.printf("\ta=%d\tb=%d\t[a]=%d\t[b]=%d\tcambio=%s\n", 
                                  a, b, valA, valB, (cambio ? "si" : "no"));

                
                if (!cambio) {
                    break;
                }
                j--;
            }
            System.out.println();
        }

        System.out.print("end\t");
        imprimirArreglo(array);
        System.out.println("\n\nCOMPARACIONES = " + comparaciones);
        System.out.println("ITERACIONES   = " + iteraciones);
        System.out.println("CAMBIOS       = " + cambios + "\n");

        // Retorna: cantidad de comparaciones, cantidad de cambios, cantidad de iteraciones
        return new int[]{comparaciones, cambios, iteraciones};
    }

    private void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }
}