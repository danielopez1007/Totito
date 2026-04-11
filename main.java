import java.util.Scanner;
public class main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
         System.out.println("------------------------------");
         System.out.println("Bienvenido al juego del Totito |");
         System.out.println("------------------------------");
          try {
         System.out.println("¿Desea cargar una partida guardada? (s/n)");
         
         String op = sc.nextLine().toUpperCase();
         if(op.equals("S")){
                metodos m = new metodos();
                m.cargar_partida();
         }else if(op.equals("N")){
            metodos m = new metodos();
        System.out.println("------------------------------");
        System.out.println("Partida Nueva                  |");
        System.out.println("------------------------------");
        m.Nuevo_totito();
        m.Ingresar_jugadores();
        m.Ingresar_jugada();
         }else{
            System.out.println("Opción no válida. Por favor, ingrese 's' o 'n'.");
            salir = false;
            
         }

          } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
         }
    }}}

