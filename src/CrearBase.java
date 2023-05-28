

import java.sql.SQLException;
import java.sql.Statement;

public class CrearBase {
    public static void crearBase(Statement sentencia){
        try{//Aqui creamos la base como quien dice, con código de SQL

            //Bueno, y yo hago un DROP DATABASE, completamente a proposito, no me des esto por malo por cambiarlo, pero me resulta mas como para este trabajo.
            String bd="Biblioteca";
            sentencia.execute("DROP DATABASE IF EXISTS "+bd+";");
            sentencia.execute("CREATE DATABASE "+bd+";");
            sentencia.execute("USE "+bd+";");


            //Creamos la tabla Autores
            sentencia.execute("CREATE TABLE Autores"
                    +"(Dni VARCHAR(9) not null,"
                    + "Nombre VARCHAR(30) not null,"
                    + "Nacionalidad VARCHAR(30) not null,"
                    + " PRIMARY KEY (Dni));");


            //Creamos la tabla Libros
            sentencia.execute("CREATE TABLE Libros"
                    +"(IdLibro int auto_increment not null,"
                    +"Titulo varchar(30) not null,"
                    +"Precio float not null,"
                    +"Autor varchar(9) not null,"
                    +"PRIMARY KEY(IdLibro),"
                    +"FOREIGN KEY(Autor) REFERENCES Autores(Dni));");
        } catch (SQLException e) {
            System.err.println("Machiño, nin crear a tabla sabes");
        }
    }

}
