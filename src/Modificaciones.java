import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Modificaciones {
    private static Statement sentencia=Conexion.getInstance().getStatement();
    static Scanner sc;
    public static void ModificarLibroPorTitulo(){
        sc=new Scanner(System.in);
        System.out.println("Dime el titulo del libro que quieres modificar");
        String titulo=sc.nextLine();
        if(Checks.checkLibroSiExiste(titulo)!=null){
            System.out.println("Dime cual será su nuevo título");
            String nuevoTitulo=sc.nextLine();
            System.out.println("Dime cual sera su nuevo precio");
            String nuevoPrecioMal=sc.nextLine();
            float nuevoPrecio;
            try{
                nuevoPrecio=Float.parseFloat(nuevoPrecioMal);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Dime cual es el dni de su Autor");
            String dniAutor=sc.nextLine();
            if(Checks.checkAutorIfExists(dniAutor)) {

                ResultSet listaLibros = Sentencias.sentenciaBuscarLibro(titulo);
                if (listaLibros != null) {
                    try {
                        sentencia.executeUpdate("UPDATE Libros SET IdLibro = " + listaLibros.getInt("idLibro") + ", Titulo = '" + nuevoTitulo + "', Precio = " + nuevoPrecio + ", Autor = '" + dniAutor + "'");

                    } catch (SQLException e) {
                        System.err.println("Error al hacer los cambios en Libro");
                    }
                }
            }else System.out.println("El autor no existe, no puedes modificar su libro");
        }
    }

    public static void ModificarAutorPorDNI(){

        sc=new Scanner(System.in);
        System.out.println("Dime el DNI del autor que quieres modificar");
        String dni=sc.nextLine();
        if(Checks.checkAutorIfExists(dni)){
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
        }else System.out.println("El autor no existe, no puedes modificarlo");
    }
}
