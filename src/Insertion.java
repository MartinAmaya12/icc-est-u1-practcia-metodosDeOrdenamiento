public class Insertion {
    public int  sort(int[] arr, boolean asc){
        int interacciones = 0;
        int comparaciones = 0;
        int cambios = 0;
        System.out.println("Arreglo original: ");
        imprimirArreglo(arr);
        System.out.println("\n");

        for(int i = 1; i < arr.length; i++){
            interacciones++;
            int j = i;
            System.out.println("I" + interacciones + "\t");
            imprimirArreglo(arr);

            boolean firstInter = true;
            while(j > 0){
                comparaciones++;
                int a = j - 1;
                int b = j;

                int valA = arr[a];
                int valB = arr[b];
                boolean cambio = false;

                if(asc == true){
                    if(valA > valB){
                        arr[a] = valB;
                        arr[b] = valA;
                        cambio = true;
                        cambios++;
                }
            }else{
                if(valA < valB){
                    arr[a] = valB;
                    arr[b] = valA;
                    cambio = true;
                    cambios++;
                }
                
            }j++;
        }
    }



    private void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

}
