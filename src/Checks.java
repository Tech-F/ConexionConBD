import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checks {

    //Esta quizá sea la clase mais guay, donde se comprueba lo maximo posible, esta comoda.
    private static Statement sentencia=Conexion.getInstance().getStatement();


    public static Boolean checkAutorIfExists(String dniAutor) {

            ResultSet listaAutores = Sentencias.sentenciaBuscarAutor(dniAutor);
        try {
            if (listaAutores.next()) {
                //True si el autor ya existe
                return true;
            } else{

                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error en el Check de autor");
        }
return false;
    }


    public static int checkTamanhoAutor(String autor) {
        if (autor.length() > 30) {
            System.out.println("El nombre es demasiado largo");
            return 1;
        } else return 2;
    }

    //Esto de comprobar el DNI en plan Pro, sacadísimo de internet vamos, para que mentir, también es que no lo pedias, es un poquito sobrada
    //En lugar de un 2, esto se merece un 2.2 al menos
    public static boolean comprobarDNI(String dni) {
        // Verificar el formato del DNI
        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            System.err.println("No me cuadra el formato del DNI");
            return false;
        }

        // Extraer el número y la letra del DNI
        String numeroStr = dni.substring(0, 8);
        String letraStr = dni.substring(8);

        int numero;
        try {
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el String a int en el DNI");
            return false;
        }

        // Calcular la letra correspondiente al número
        char letraCalculada = calcularLetraDNI(numero);

        // Comparar la letra calculada con la letra proporcionada
        return letraCalculada == letraStr.charAt(0);
    }

    private static char calcularLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = numero % 23;
        return letras.charAt(indiceLetra);
    }

    public static int checkTamanhoNacionalidad(String nacionalidad) {
        if (nacionalidad.length() > 30) {
            System.out.println("La Nacionalidad es demasiado larga");
            return 1;
        } else return 2;
    }

    public static boolean comprobarNumeroMenuGeneral(int num) {
        if (num != 1 && num != 2 && num != 3 && num != 4 && num != 0) {
            System.err.println("Cabrón, solo tenías que hacer una cosa y te has equivocado, prueba otra vez anda");
            return false;
        } else return true;
    }

    public static boolean comprobarNumeroMenusPeque(int num) {
        if (num != 1 && num != 2 && num != 0) {
            System.err.println("Cabrón, solo tenías que hacer una cosa y te has equivocado, prueba otra vez anda");
            return false;
        } else return true;
    }


    public static Boolean checkLibroSiExiste(String titulo) {
        if (checkTamanhoTitulo(titulo) == 2) {

            try {
                ResultSet listaLibros = Sentencias.sentenciaBuscarLibro(titulo);
                while (listaLibros.next()) {
                    return true;
                }
                System.err.println("El Libro no existe");
                return false;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public static int checkTamanhoTitulo(String titulo) {
        if (titulo.length() > 30) {
            System.out.println("El titulo es demasiado largo");
            return 1;
        } else return 2;
    }

    public static boolean checkDNIifExists(String dni) {

        if (Checks.comprobarDNI(dni)) {
            try {
                ResultSet listaDNI = sentencia.executeQuery("SELECT * FROM Libros WHERE Dni = '" + dni + "';");
                if (listaDNI != null) {
                    return true;
                } else return false;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    return false;
    }
}
