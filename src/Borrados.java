import java.sql.Statement;
import java.util.Scanner;

public class Borrados {
    static Scanner sc;
    public static void borradoDeLibro(){
        sc=new Scanner(System.in);
        Statement sentencia = null;
        System.out.println("Dime el titulo del libro que quieres borrar");
        String titulo=sc.nextLine();
        if(Checks.checkLibroSiExiste(titulo)!=null){

        }else System.err.println("No se ha podido borrar el libro");
    }
}
