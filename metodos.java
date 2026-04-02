import java.util.Scanner;


public class metodos {
private Scanner K;
private String [] jugadores;
private String [][] tablero;
public metodos(){
    K=new Scanner(System.in);
    jugadores= new String[2];
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
}