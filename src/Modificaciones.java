import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Modificaciones {
    private static Statement sentencia=Conexion.sentencia;
    static Scanner sc;
    public static void ModificarLibroPorTitulo(){
        Statement sentencia = null;
        sc=new Scanner(System.in);
        System.out.println("Dime el titulo del libro que quieres modificar");
        String titulo=sc.nextLine();
        if(Checks.checkLibroSiExiste(titulo)!=null){
            System.out.println("Dime cual será su nuevo título");
            String nuevoTitulo=sc.nextLine();
            System.out.println("Dime cual sera su nuevo precio");
            float nuevoPrecio=sc.nextFloat();
            System.out.println("Dime cual es su autor");
            String nuevoAutor=sc.nextLine();
            nuevoAutor=Checks.checkAutorIfExists(nuevoAutor);
            ResultSet listaLibros=Sentencias.sentenciaBuscarLibro(titulo);
            if(listaLibros!=null) {
                try {
                    sentencia.executeUpdate("UPDATE Libros set Titulo= '" + nuevoTitulo + "', Precio= " + nuevoPrecio + ",Autor= '" + nuevoAutor + "',IdLibro= "+listaLibros.getInt("idLibro")+";");
                } catch (SQLException e) {
                    System.err.println("Error al hacer los cambios en Libro");
                }
            }
        }
    }

    public static void ModificarAutorPorDNI(){
        Statement sentencia = null;
        sc=new Scanner(System.in);
        System.out.println("Dime el DNI del autor que quieres modificar");
        String dni=sc.nextLine();
        if(Checks.comprobarDNI(dni)){
            System.out.println("Dime el nuevo nombre del Autor");
            String nuevoNombre=sc.nextLine();
            System.out.println("Dime la nueva nacionalidad del Autor");
            String nuevaNacionalidad=sc.nextLine();
            System.out.println("Dime el nuevo DNI del autor");
            String nuevoDni=sc.nextLine();
            if((Checks.checkTamanhoAutor(nuevoNombre)==2) && (Checks.checkTamanhoNacionalidad(nuevaNacionalidad)==2) && (Checks.checkDNIifExists(nuevoDni))){
                try{
                    sentencia.executeUpdate("UPDATE Autores set Dni= '"+nuevoDni+"', Nombre= '"+nuevoNombre+"', Nacionalidad= '"+nuevaNacionalidad+"';");
                } catch (Exception e) {
                    System.err.println("Problemita al Modificar un Autor");
                }
            }
        }
    }
}
