import java.util.Scanner;
public class motor {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
      System.out.println("------------------------------");
         System.out.println("Bienvenido al juego del Totito |"+"\n"+"Pablo Daniel Ordoñez lopez/7690-25-14738");
         System.out.println("------------------------------");
        boolean salir = false;
        while (!salir) {
          try {
         System.out.println("Elige una opción: (s) Cargar partida, (n) Nueva partida, (e) Salir");
         
      String op = sc.nextLine().toUpperCase();
      metodos m;
      switch (op) {
         case "S":
             m = new metodos();
             m.cargar_partida();
             break;
         case "N":
             m = new metodos();
             System.out.println("------------------------------");
             System.out.println("Partida Nueva                  |");
             System.out.println("------------------------------");
             m.Nuevo_totito();
             m.Ingresar_jugadores();
             m.Ingresar_jugada();
             break;
         case "E":
             salir = true;
             break;
         default:
             System.out.println("Opción no válida. Por favor, ingrese 's' o 'n' o 'e'.");
             break;
      }

          } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
         }
    }}}

