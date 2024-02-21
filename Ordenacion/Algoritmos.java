import javax.swing.JOptionPane;

public class Algoritmos {

    public static void BubbleSort() {
        int A[], N, aux;
        N = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo: "));
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(JOptionPane.showInputDialog( "[" + (i + 1) + "]" + " Digite el numero: "));
        }

        // Metodo de burbuja
        for (int i = 0; i < (N - 1); i++) {
            for (int j = 0; j < (N - 1); j++) {
                if (A[j] > A[j + 1]) {
                    aux = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = aux;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma creciente: \n" + ArrayString(A));
        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma decreciente: \n" + ArrayString(invertir(A)));
    }

    public static void Insercion() {
        int A[], N, aux, pos;
        N = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo: "));
        A = new int[N];

        System.out.println("Digite el contenido del arreglo :D");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(JOptionPane.showInputDialog( "[" + (i + 1) + "]" + " Digite el numero: "));
        }

        //Método de Insercion
        for (int i = 0; i < N; i++) {
            pos = i;
            aux = A[i];
            while ((pos > 0) && (A[pos - 1] > aux)) {
                A[pos] = A[pos - 1];
                pos--;
            }
            A[pos] = aux; 
        }

        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma creciente: \n" + ArrayString(A));
        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma decreciente: \n" + ArrayString(invertir(A)));
    }

    public static void Seleccion() {
        int A[], N, aux, pos, menor;
        N = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo: "));
        A = new int[N];

        System.out.println("Digite el contenido del arreglo :D");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(JOptionPane.showInputDialog( "[" + (i + 1) + "]" + " Digite el numero: "));
        }
    
        // Metodo de Seleccion
        for (int i = 0; i < (N - 1); i++) {
            menor = A[i];
            pos = i;
            for (int j = (i + 1); j < N; j++) {
                if (A[j] < menor) {
                    menor = A[j];
                    pos = j;
                }
            }
            aux = A[i];
            A[i] = A[pos];
            A[pos] = aux;
        }

        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma creciente: \n" + ArrayString(A));
        JOptionPane.showMessageDialog(null, "El arreglo ordenado en forma decreciente: \n" + ArrayString(invertir(A)));
    }

    public static void Busqueda() {
        int A[], N, dato;
        N = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del arreglo: "));
        A = new int[N];

        System.out.println("Digite el contenido del arreglo :D");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(JOptionPane.showInputDialog( "[" + (i + 1) + "]" + " Digite el numero: "));
        }
        dato = Integer.parseInt(JOptionPane.showInputDialog("Dato a buscar: "));
        
        //Algoritmo Busqueda Secuencial
        int i = 0;
        while ((i < N) && A[i] != dato) {
            i++;  
        }
        if (i >= N) {
            JOptionPane.showMessageDialog(null, "La informacion no está en el arreglo");
        } else {
            JOptionPane.showMessageDialog(null, "La informacion está en la posicion " + (i + 1));
        } 
    }

    private static String ArrayString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString(); 
    }

    private static int[] invertir(int[] array) {
        int longitud = array.length;
        for (int i = 0; i < longitud / 2; i++) {
            int temp = array[i];
            array[i] = array[longitud - 1 - i];
            array[longitud - 1 - i] = temp;
        }
        return array; 
    }
}
