import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Statement;

public class RellenoDeInfo {
    private static Statement sentencia= Conexion.getInstance().getStatement();
    public static void rellenamosMovidas() {
        try {
            //Aquí metemos 3 buenos autores
            sentencia.executeUpdate("INSERT INTO Autores (Dni, Nombre, Nacionalidad) VALUES('12345678A', 'Manolo', 'Española');");
            sentencia.executeUpdate("INSERT INTO Autores (Dni, Nombre, Nacionalidad) VALUES('98765432B', 'Juana De Arco', 'Mexicana');");
            sentencia.executeUpdate("INSERT INTO Autores (Dni, Nombre, Nacionalidad) VALUES('54321678C', 'Sreck', 'Estadounidense');");

            //Y también varios libros
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('El Gran Gatsby', 19.99, '12345678A');");
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('Cien años de soledad', 24.99, '12345678A');");
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('Don Quijote de la Mancha', 14.99, '98765432B');");
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('1984', 17.99, '98765432B');");
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('Matar a un ruiseñor', 16.99, '54321678C');");
            sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES('Orgullo y prejuicio', 21.99, '54321678C');");


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
