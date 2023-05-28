import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrados {
    private static Statement sentencia=Conexion.getInstance().getStatement();
    static Scanner sc;
    public static void borradoDeLibro(){ //Aqui se busca el libro por titulo y se borra pues
        sc=new Scanner(System.in);

        System.out.println("Dime el titulo del libro que quieres borrar");
        String titulo=sc.nextLine();
        if(Checks.checkLibroSiExiste(titulo)){
            try{
                    sentencia.execute("DELETE FROM Libros WHERE Titulo='"+titulo+"';");
                    System.out.println("Libro Borrado");

            } catch (Exception e) {
                System.err.println("Error en la ejecución del borrado del libro");
            }
        }else System.err.println("No se ha podido borrar el libro");
    }


    public static void borradoDeAutor(){//Borramos el autor busnco el DNI, pero primerito, los libros
        //Primero borraremos todos sus libros
        sc=new Scanner(System.in);

        System.out.println("Dime el dni del autor para borrarlo");
        String dniAutor=sc.nextLine();
        if(Checks.checkAutorIfExists(dniAutor)){
            try {
                sentencia.execute("DELETE FROM Libros WHERE Autor='"+dniAutor+"';");
                sentencia.execute("DELETE FROM Autores WHERE Dni='"+dniAutor+"';");
                System.out.println("Se han eliminado con éxito todos los libros y su autor");
            } catch (SQLException e) {
                System.err.println("Error en el proceso de eliminación de autor");
            }


        }


    }
}
