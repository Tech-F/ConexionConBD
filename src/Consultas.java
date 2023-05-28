import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultas {
    private static Statement sentencia=Conexion.getInstance().getStatement();
   static Scanner sc;
    public static void consultarLibro(){

        sc=new Scanner(System.in);
        System.out.println("Los datos de que libro quieres consultar?");
        String titulo=sc.nextLine();
        if (Checks.checkLibroSiExiste(titulo)) {
            ResultSet listaLibros = Sentencias.sentenciaBuscarLibro(titulo);
            try {
                if(listaLibros.next()) {
                    System.out.println("El ID del libro es: " + listaLibros.getInt("IdLibro"));
                    System.out.println("El titulo del libro es: " + titulo);
                    System.out.println("El precio del libro es: " + listaLibros.getFloat("Precio"));
                    System.out.println("El Autor del libro es: " + listaLibros.getString("Autor"));
                }
            } catch (SQLException e) {
                System.err.println("Error al mostrar la info de un libro en Consultas");
            }

        }
    }
    public static void verTodosLibrosPorAutor(){

        int cont=0;
        sc=new Scanner(System.in);
        System.out.println("Dime el dni del autor quieres todos los libros");
        String dniAutor=sc.nextLine();
        if(Checks.checkAutorIfExists(dniAutor)!=null){
            ResultSet listaLibros= null;
            try {
                listaLibros = sentencia.executeQuery("SELECT * from Libros WHERE Autor= '"+dniAutor+"';");
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

    public static void listarAutoresConSusLibros() {

        sc = new Scanner(System.in);
        try {
            ResultSet listaAutores = sentencia.executeQuery("SELECT * FROM Autores");
            int contAutor = 0;
            while (listaAutores.next()) {
                contAutor++;
                System.out.println("Autor numero " + contAutor);
                String dniAutor = listaAutores.getString("Dni");
                String nombreAutor=listaAutores.getString("Nombre");
                System.out.println("El autor "+nombreAutor+" Con DNI " + dniAutor + " tiene los siguientes libros: ");

                ResultSet listaLibrosDeAutor = sentencia.executeQuery("SELECT * FROM Libros WHERE Autor= '" + dniAutor + "';");
                int contLibro = 0;
                while (listaLibrosDeAutor.next()) {
                    contLibro++;
                    System.out.println("Libro número " + contLibro);
                    System.out.println("El ID del libro es: " + listaLibrosDeAutor.getInt("IdLibro"));
                    System.out.println("El título del libro es: " + listaLibrosDeAutor.getString("Titulo"));
                    System.out.println("El precio del libro es: " + listaLibrosDeAutor.getFloat("Precio"));
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los autores con sus libros");
        }

    }
}
