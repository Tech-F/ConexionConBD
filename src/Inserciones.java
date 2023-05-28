import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserciones {
    private static Statement sentencia=Conexion.sentencia;
    static Scanner sc;
    public static void insertarAutor(){
        Statement sentencia = null;
        sc=new Scanner(System.in);
    System.out.println("Dígame un nombre de autor");
    String nombreAutor=sc.nextLine();
    System.out.println("Dime el DNI del autor");
    String dniAutor=sc.nextLine();
    System.out.println("Dime nacionalidad del autor");
    String nacionalidadAutor=sc.nextLine();

    Boolean valido=Checks.comprobarDNI(dniAutor);

    int verificarNacionalidad=Checks.checkTamanhoNacionalidad(nacionalidadAutor);

    if((Checks.checkAutorIfExists(nombreAutor)==null) && valido && verificarNacionalidad==2) {
        try {
            sentencia.executeUpdate("INSERT INTO PRODUCTOS (Dni,Nombre,Nacionalidad) VALUES('" + dniAutor + "','" + nombreAutor + "','" + nacionalidadAutor + "');");
            System.out.println("Autor añadido");
        } catch (SQLException e) {
            System.err.println("Error al añadir un autor");
        }
    }else System.out.println("El autor ya existe");
    }


    public static void insertarLibro(){
        Statement sentencia = null;
        sc=new Scanner(System.in);
        System.out.println("Dígame el título del libro");
        String tituloLibro=sc.nextLine();
        System.out.println();
        System.out.println("Dígame el precio del libro");
        int precioLibro=sc.nextInt();
        System.out.println("Dígame a que autor pertenece");
        String autorDelLibro=sc.nextLine();
        if(Checks.checkAutorIfExists(autorDelLibro)!=null){
            try{
            sentencia.executeUpdate("INSERT INTO Libros (Titulo,Precio,Autor) VALUES('"+tituloLibro+"',"+precioLibro+",'"+autorDelLibro+"');");
            System.out.println("Libro añadido");
        } catch (SQLException e) {
                System.err.println("Fallo al insertar el libro en parte 1");
            }
        }else {
            System.out.println("El autor no existe, quieres crearlo? pulsa 1 para crear y 2 para cancelar");
            int num=sc.nextInt();
            if(num==1){
                 insertarAutor();
                    try{
                        sentencia.executeUpdate("INSERT INTO Libros (Titulo,Precio,Autor) VALUES('"+tituloLibro+"',"+precioLibro+",'"+autorDelLibro+"');");
                        System.out.println("Libro añadido");
                    } catch (SQLException e) {
                        System.err.println("Fallo al insertar el libro en parte 2");
                    }
            }
        }

    }
}
