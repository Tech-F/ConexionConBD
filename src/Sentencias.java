import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sentencias {
    private static Statement sentencia=Conexion.getInstance().getStatement();
    public static ResultSet sentenciaBuscarLibro(String titulo) {

        try {
            ResultSet listaLibros = sentencia.executeQuery("SELECT * FROM Libros WHERE Titulo = '" + titulo + "';");
            return listaLibros;
        } catch (SQLException e) {
            System.err.println("Error en la sentencia de búsqueda de libro");
        }
        return null;
    }

    public static ResultSet sentenciaBuscarAutor(String dni){

        try {
            ResultSet listaAutores = sentencia.executeQuery("SELECT * FROM Autores WHERE Dni = '" + dni + "';");
            return listaAutores;
        } catch (SQLException e) {
            System.err.println("Error en la sentencia de búsqueda de Autores");
        }
        return null;
    }
}
