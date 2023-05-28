import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserciones {
    private static Statement sentencia=Conexion.getInstance().getStatement();
    static Scanner sc;
    public static void insertarAutor(){

        sc=new Scanner(System.in);
    System.out.println("Dígame un nombre de autor");
    String nombreAutor=sc.nextLine();
    System.out.println("Dime el DNI del autor");
    String dniAutor=sc.nextLine();
    System.out.println("Dime nacionalidad del autor");
    String nacionalidadAutor=sc.nextLine();

    Boolean valido=Checks.comprobarDNI(dniAutor);

    int verificarNacionalidad=Checks.checkTamanhoNacionalidad(nacionalidadAutor);

    if((Checks.checkAutorIfExists(dniAutor)==false) && valido && verificarNacionalidad==2) {
        try {
            sentencia.executeUpdate("INSERT INTO Autores (Dni,Nombre,Nacionalidad) VALUES('" + dniAutor + "','" + nombreAutor + "','" + nacionalidadAutor + "');");
            System.out.println("Autor añadido");
        } catch (SQLException e) {
            System.err.println("Error al añadir un autor");
        }
    }else System.out.println("El autor ya existe");
    }


    public static void insertarLibro(){

        sc=new Scanner(System.in);
        System.out.println("Dígame el título del libro");
        String tituloLibro=sc.nextLine();
        System.out.println("Dígame el precio del libro");
        String precioLibroMal=sc.nextLine();
        int precioLibro;
        try{
            precioLibro=Integer.parseInt(precioLibroMal);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dígame el DNi del autor al que autor pertenece");
        String dniAutor=sc.nextLine();
        if(Checks.checkAutorIfExists(dniAutor)){
            try{
            sentencia.executeUpdate("INSERT INTO Libros (Titulo,Precio,Autor) VALUES('"+tituloLibro+"',"+precioLibro+",'"+dniAutor+"');");
            System.out.println("Libro añadido");
        } catch (SQLException e) {
                System.err.println("Fallo al insertar el libro en parte 1");
            }
        }else {
            System.out.println("El autor no existe, quieres crearlo? pulsa 1 para crear y 2 para cancelar");
            int num=sc.nextInt();
            if(num==1){
                 insertarAutor();
                 System.out.println("Cual es el dni del autor que has creado?");
                 dniAutor=sc.nextLine();
                    try{
                        sentencia.executeUpdate("INSERT INTO Libros (Titulo,Precio,Autor) VALUES('"+tituloLibro+"',"+precioLibro+",'"+dniAutor+"');");
                        System.out.println("Libro añadido");
                    } catch (SQLException e) {
                        System.err.println("Fallo al insertar el libro en parte 2");
                    }
            }
        }

    }
}
