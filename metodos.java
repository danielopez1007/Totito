import java.util.Scanner;


public class metodos {
private final Scanner K;
private final String [] jugadores, simbolos;
private final String [][] tablero;
public metodos(){
    K=new Scanner(System.in);
    jugadores= new String[2];
    simbolos= new String[2];
    tablero= new String[10][10];


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
    int turno = 0;
    boolean ganador=false;
    try {
        while (ganador==false) {
            int i = turno % 2;
            System.out.println("Turno del jugador " + jugadores[i]);

            while (true) {
                System.out.print("Ingrese la fila donde desea colocar su simbolo: ");
                fila = K.nextInt();

                System.out.print("Ingrese la columna donde desea colocar su simbolo: ");
                columna = K.nextInt();

                
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
        int contador =0;
                    for (int e =0;e<10;e++){
                    for(int j=0;j<10;j++){
                        if(tablero[e][j].equals(simbolos[i]) || tablero[j][e].equals(simbolos[i])){
                contador++;
            }else{
                contador=0;
            }
            if(contador==3){
                System.out.println("El jugador "+jugadores[i]+" ha ganado");
                ganador=true;
                break;
            }
        }
    }
        
        turno++;

            }
            
        
        }
    catch (Exception e) {
        System.out.println("Entrada inválida. Intente de nuevo.");
        K.nextLine();
    }
}}
