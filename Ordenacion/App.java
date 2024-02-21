import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escoja la acción que desea realizar:"
                    + "\n1.- Ordenación"
                    + "\n2.- Búsqueda"
                    + "\n3.- Salir", 
                    "MENU", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    otroMenu();
                    break;
                case 2:
                    Algoritmos.Busqueda();
                    break;
                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void otroMenu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escoja la ordenación que desea realizar:"
                    + "\n1.- Intercambio Directo"
                    + "\n2.- Inserción"
                    + "\n3.- Selección"
                    + "\n4.- Salir", 
                    "MENU", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    Algoritmos.BubbleSort();
                    break;
                case 2:
                    Algoritmos.Insercion();
                    break;
                case 3:
                    Algoritmos.Seleccion();
                    break;
                default:
                    break;
            }
        } while (opcion != 4);
    }
    

    
}
