import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    //Esta clase es como la tuya pero variando un poco como se declara para poder llamarlo desde las distintas clases
    private static Conexion instance = null;
    private static Statement sentencia = null;

    private Conexion() {
        conectamos();
    }

    public static Conexion getInstance() {
        if(instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Statement getStatement() {
        return sentencia;
    }

    private void conectamos() {
        Connection conexion = null;
        int op = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mariadb://localhost:3307/?user=root&password=,swacIm5"; //Ojo aqui al poner el LocalHost porque tenía la 06 ocupada. La contraseña ya la teneis desde siempre
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error");
        }

        try {
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        CrearBase.crearBase(sentencia);
    }
}