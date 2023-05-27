import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sentencias {
    public static ResultSet sentenciaBuscarLibro(String titulo) {
        Statement sentencia = null;
        try {
            ResultSet listaLibros = sentencia.executeQuery("SELECT * FROM Libros WHERE Titulo = '" + titulo + "';");
            return listaLibros;
        } catch (SQLException e) {
            System.err.println("Error en la sentencia de búsqueda de libro");
        }
        return null;
    }

    public static ResultSet sentenciaBuscarAutor(String nombreAutor){
        Statement sentencia = null;
        try {
            ResultSet listaAutores = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + nombreAutor + "';");
        } catch (SQLException e) {
            System.err.println("Error en la sentencia de búsqueda de Autores");
        }
        return null;
    }
}
