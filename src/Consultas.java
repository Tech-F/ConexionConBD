import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultas {
    private static Statement sentencia=Conexion.sentencia;
   static Scanner sc;
    public static void consultarLibro(){
        Statement sentencia = null;
        sc=new Scanner(System.in);
        System.out.println("Los datos de que libro quieres consultar?");
        String titulo=sc.nextLine();
        if (Checks.checkLibroSiExiste(titulo) != null) {
            ResultSet listaLibros = Sentencias.sentenciaBuscarLibro(titulo);
            try {
                System.out.println("El ID del libro es: "+listaLibros.getInt("IdLibro"));
                System.out.println("El titulo del libro es: "+titulo);
                System.out.println("El precio del libro es: "+listaLibros.getFloat("Precio"));
                System.out.println("El Autor del libro es: "+listaLibros.getString("Autor"));

            } catch (SQLException e) {
                System.err.println("Error al mostrar la info de un libro en Consultas");
            }

        }
    }
    public static void verTodosLibrosPorAutor(){
        Statement sentencia = null;
        int cont=0;
        sc=new Scanner(System.in);
        System.out.println("Dime de que autor quieres todos los libros");
        String autor=sc.nextLine();
        if(Checks.checkAutorIfExists(autor)!=null){
            ResultSet listaLibros= null;
            try {
                listaLibros = sentencia.executeQuery("SELECT * from Libros WHERE Autor= '"+autor+"';");
                while(listaLibros.next()){
                    cont++;
                    System.out.println("Libro numero 1");
                    System.out.println("El ID del libro es: "+listaLibros.getInt("IdLibro"));
                    System.out.println("El titulo del libro es: "+listaLibros.getString("Titulo"));
                    System.out.println("El precio del libro es: "+listaLibros.getFloat("Precio"));
                    System.out.println("");
            }

            } catch (SQLException e) {
               System.err.println("Error en la busqueda de libros por autor");
            }
        }
    }

    public static void listarTodosLosLibros(){
        Statement sentencia = null;
        int cont=0;
        sc=new Scanner(System.in);
        try{
            ResultSet listaLibros= sentencia.executeQuery("SELECT * FROM Libros");
            while(listaLibros.next()){
                cont++;
                System.out.println("Libro numero 1");
                System.out.println("El ID del libro es: "+listaLibros.getInt("IdLibro"));
                System.out.println("El titulo del libro es: "+listaLibros.getString("Titulo"));
                System.out.println("El precio del libro es: "+listaLibros.getFloat("Precio"));
                System.out.println("El Autor del libro es: "+listaLibros.getString("Autor"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.err.println("Error al listar todos los libros");
        }
    }

    public static void listarAutoresConSusLibros(){
        Statement sentencia = null;
        int contLibro=0;
        int contAutor=0;
        sc=new Scanner(System.in);
        try{
            ResultSet listaAutores=sentencia.executeQuery("SELECT * FROM Autores");
            ResultSet listaLibrosDeAutor=sentencia.executeQuery("SELECT * FROM Libros WHERE Autor= '"+listaAutores.getString("Nombre")+"';");
            while (listaAutores.next()){
                contAutor++;
                System.out.println("Autor numero "+contAutor);
                System.out.println("El autor "+listaAutores.getString("Nombre")+"Tiene los siguientes libros: ");
                while (listaLibrosDeAutor.next()){
                    contLibro++;
                    System.out.println(listaLibrosDeAutor.getString("Titulo"));
                }

            }

        } catch (SQLException e) {
            System.err.println("Error al listar los autores con sus libros");
        }

    }

}
