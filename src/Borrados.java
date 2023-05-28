import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrados {
    private static Statement sentencia=Conexion.sentencia;
    static Scanner sc;
    public static void borradoDeLibro(){
        sc=new Scanner(System.in);
        Statement sentencia = null;
        System.out.println("Dime el titulo del libro que quieres borrar");
        String titulo=sc.nextLine();
        if(Checks.checkLibroSiExiste(titulo)!=null){
            try{
                ResultSet listaLibros=Sentencias.sentenciaBuscarLibro(titulo);
                if(listaLibros!=null){
                    sentencia.execute("DELETE FROM Libros WHERE Titulo="+listaLibros.getString("Titulo")+";");
                    System.out.println("Libro Borrado");
                }
            } catch (Exception e) {
                System.err.println("Error en la ejecución del borrado del libro");
            }
        }else System.err.println("No se ha podido borrar el libro");
    }


    public static void borradoDeAutor(){
        //Primero borraremos todos sus libros
        sc=new Scanner(System.in);
        Statement sentencia = null;
        System.out.println("Dime el nombre del autor a borrar");
        String nombreAutor=sc.nextLine();
        ResultSet listaAutores=Sentencias.sentenciaBuscarAutor(nombreAutor);
        if(listaAutores!=null){
            try {
                String dniAutor=listaAutores.getString("Dni");
                sentencia.execute("DELETE FROM Libros WHERE Autores='"+dniAutor+"';");
                sentencia.execute("DELETE FROM Autores WHERE Dni='"+dniAutor+"';");

            } catch (SQLException e) {
                System.err.println("Error en el proceso de eliminación de autor");
            }


        }


    }
}
