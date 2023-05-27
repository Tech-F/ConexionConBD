import org.mariadb.jdbc.Statement;

import java.sql.SQLException;

public class CrearBase {
public static void crearBase(Statement sentencia){
    try{//Aqui creamos la base como quien dice, con código de SQL
        String bd="Biblioteca";
        sentencia.execute("DROP DATABASE IF EXISTS "+bd+";");
        sentencia.execute("CREATE DATABASE "+bd+";");
        sentencia.execute("USE "+bd+";");


        //Creamos la tabla Autores
        sentencia.execute("CREATE TABLE Autores"
        +"(Dni VARCHAR(9) not null,"
        + "Nombre VARCHAR(30) not null,"
        + "Nacionalidad VARCHAR(30) not null;"
        + " PRIMARY KEY (Dni))"
        + "ENGINE INNODB;");


        //Creamos la tabla Libros
        sentencia.execute("CREATE TABLE Libros"
        +"(IdLibro int auto_increment unsigned zerofill,"
        +"Titulo varchar(30),"
        +"Precio float,"
        +"Autor varchar(9),"
        +"PRIMARY KEY(IdLibro),"
        +"FOREING KEY(Autor) REFERENCES Autores(Dni));");
    } catch (SQLException e) {
        System.err.println("Machiño, nin crear a tabla sabes");
    }
}
}
