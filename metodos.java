import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class metodos {
private final Scanner K;
private  String [] jugadores, simbolos;
private  String [][] tablero;
public metodos(){
    K=new Scanner(System.in);
    jugadores= new String[2];
    simbolos= new String[2];
    tablero= new String[10][10];


}
public void cargar_partida() {
    java.io.File archivo = new java.io.File("partida_totito.txt");
    
    if (!archivo.exists()) {
        System.out.println("No hay ninguna partida guardada.");
        return;
    }

    try (Scanner lector = new Scanner(archivo)) {
        if (lector.hasNextLine()) {
            String[] datosConfig = lector.nextLine().split(",");
            jugadores[0] = datosConfig[0];
            simbolos[0] = datosConfig[1];
            jugadores[1] = datosConfig[2];
            simbolos[1] = datosConfig[3];
        }

        if (lector.hasNextLine()) {
            String[] datosTablero = lector.nextLine().split(",");
            int contador = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    String celda = datosTablero[contador].equals("#") ? " " : datosTablero[contador];
                    tablero[i][j] = celda;
                    contador++;
                }
            }
        }
        System.out.println("Partida cargada exitosamente.");
        Ingresar_jugada();

    } catch (IOException e) {
        System.out.println("Error al cargar: " + e.getMessage());
    }
}
public void guardar_partida() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("partida_totito.txt"))) {
        writer.write(jugadores[0] + "," + simbolos[0] + "," + jugadores[1] + "," + simbolos[1]);
        writer.newLine();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String celda = tablero[i][j].equals(" ") ? "#" : tablero[i][j];
                writer.write(celda);
                if (!(i == 9 && j == 9)) {
                    writer.write(",");
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}
public void Nuevo_totito(){
    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            tablero[i][j]=" ";
        }
    }
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(tablero[i][j] +"_"+ "│");
        }
        System.out.println();
    }
}

    


public void Ingresar_jugadores(){
    for(int i=0;i<2;i++){
        System.out.print("Ingrese el nombre del jugador  "+(i+1)+" :");
        jugadores[i]=K.nextLine();
        System.out.print("Ingrese el simbolo del jugador "+(i+1)+" :");
        simbolos[i]=K.nextLine();
        
    }
}
public void Ingresar_jugada() {
    int fila, columna;
    int turno = 0, movimientos = 0;
    boolean ganador=false;
    
        while (ganador==false && movimientos<100) {
            try {
            int i = turno % 2;
            System.out.println("Turno del jugador " + jugadores[i]);

            while (true) {
                System.out.print("Ingrese la fila donde desea colocar su simbolo: ");
                fila = K.nextInt();
                K.nextLine();

                System.out.print("Ingrese la columna donde desea colocar su simbolo: ");
                columna = K.nextInt();
                K.nextLine();

                if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
                    System.out.println("Posición inválida. Intente de nuevo.");
                    continue;
                }

               
                if (!tablero[fila][columna].equals(" ")) {
                    System.out.println("Esa casilla ya está ocupada. Intente otra.");
                    continue;
                }

            
                tablero[fila][columna] = simbolos[i];
                break;
            }

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(tablero[r][c] + "_" + "│");
            }
            System.out.println();
        }
        
        int contadorcol = 0;
        int contadordiag1 = 0;
        int contadordiag2 = 0;
        int contadordiag3 = 0;
        int contadordiag4 = 0;
        int contador = 0;
        for (int e = 0; e < 10; e++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[e][j].equals(simbolos[i])) {
                    contador++;
                } else {
                    contador = 0;
                }
                if (tablero[j][e].equals(simbolos[i])) {
                    contadorcol++;
                }else{
                    contadorcol=0;
                }

                if (contador == 5 || contadorcol == 5) {
                    System.out.println("-------------------------------------------");
                        System.out.println("| El jugador " + jugadores[i] + " ha ganado          |");
                        System.out.println("-------------------------------------------");
                    ganador = true;
                    break;
                }
            }
        }
        for(int k=0;k<10;k++){
            for(int l=0;l<10;l++){
                int d = k+l;
                if(d>=0 && d<10){
                    if(tablero[d][l].equals(simbolos[i])){
                        contadordiag1++;
                    }else{
                        contadordiag1=0;
                    }
                    if(tablero[l][d].equals(simbolos[i])){
                        contadordiag2++;
                    }else{
                        contadordiag2=0;
                    }
                    if (contadordiag1 == 5 || contadordiag2 == 5) {
                        System.out.println("-------------------------------------------");
                        System.out.println("| El jugador " + jugadores[i] + " ha ganado          |");
                        System.out.println("-------------------------------------------");
                        ganador = true;
                        break;
                    }
                    
                }
            }
        }
        for(int m=9;m>=0;m--){
            for(int n =0;n<10;n++){
                int d = m-n;
                if(d>=0 && d<10){
                    if(tablero[d][n].equals(simbolos[i])){
                        contadordiag3++;
                    }else{
                        contadordiag3=0;
                    }
                    if(tablero[n][d].equals(simbolos[i])){
                        contadordiag4++;
                    }else{
                        contadordiag4=0;
                    }
                    if (contadordiag3 == 5 || contadordiag4 == 5) {
                        System.out.println("-------------------------------------------");
                        System.out.println("| El jugador " + jugadores[i] + " ha ganado          |");
                        System.out.println("-------------------------------------------");
                        ganador = true;
                        break;
                    }
                     
                    
                }
            }
        }
         System.out.print("Decea Guardar la partida? (s/n): ");
               String Save= K.nextLine().toUpperCase();
                if(Save.equals("S")){
                     guardar_partida();
                     System.out.println("Partida guardada exitosamente.");
                }
        turno++;
        movimientos++;

        if(movimientos==100){
            System.out.println("-------------------------------------------");
            System.out.println("| El juego ha terminado en empate                        |");
            System.out.println("-------------------------------------------");
            break;
        }
    } catch (Exception e) {
        System.out.println("Entrada inválida. Intente de nuevo.");
        K.nextLine();
    }
}}}
