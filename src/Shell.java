public class Shell {

    public int[] sort(int[] array, boolean asc) {
        int iteraciones = 0;
        int comparaciones = 0;
        int cambios = 0;

        System.out.println("Arreglo original:");
        imprimirArreglo(array);
        System.out.println("\n");

        int gap = array.length / 2;

        while (gap > 0) {
            
            for (int i = gap; i < array.length; i++) {
                iteraciones++;
                int j = i;
                System.out.print("I" + iteraciones + "\t");
                imprimirArreglo(array);

                boolean firstInIter = true;

                while (j >= gap) {
                    comparaciones++;
                    int a = j - gap;
                    int b = j;

                    int valA = array[a];
                    int valB = array[b];
                    boolean cambio = false;

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

                    System.out.printf("\tgap=%d\ta=%d\tb=%d\t[a]=%d\t[b]=%d\tcambio=%s\n", 
                                      gap, a, b, valA, valB, (cambio ? "si" : "no"));

                    if (!cambio) {
                        break;
                    }
                    j = j - gap;
                }
                System.out.println();
            }
            
            gap = gap / 2; 
        }

        System.out.print("end\t");
        imprimirArreglo(array);
        System.out.println("\n\nCOMPARACIONES = " + comparaciones);
        System.out.println("ITERACIONES   = " + iteraciones);
        System.out.println("CAMBIOS       = " + cambios + "\n");

        return new int[]{comparaciones, cambios, iteraciones};
    }

    private void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }
}