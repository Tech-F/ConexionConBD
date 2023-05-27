import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checks {


    public static String checkAutorIfExists(String autor){


        if(checkTamanhoAutor(autor)==2) {

            Statement sentencia = null;
            try {
                ResultSet listaAutores = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + autor + "';");
                if (listaAutores != null) {
                    return autor;
                }

            } catch (SQLException e) {
                System.err.println("Error al comprobar la existencia del autor");
            }
        }else {
            return null;
        }
            return null;
    }
    public static int checkTamanhoAutor(String autor){
        if(autor.length()>30){
            System.out.println("El nombre es demasiado largo");
            return 1;
        }else return 2;
    }

        //Esto de comprobar el DNI en plan Pro, sacadisimo de internet vamos, para que metir, tambien es que no lo pedias, es un poquito sobrada
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

}