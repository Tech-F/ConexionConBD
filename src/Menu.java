import java.util.Scanner;

public class Menu {
//En esta clase lo que hacemos es crear los menus que necesitaremos para viajar por el programa.
    static Scanner sc;


    //Este será el menu principal
    public static void menuMaestro(){
        Conexion.getInstance();//Aqui nos vamos a la clase Conexon para realizar la conexion con la base de datos.
        //Con esta función metemos varios datos para no tener que meterlos a mano
        RellenoDeInfo.rellenamosMovidas();
        //Para ver que se rellenó, pues hay que verlo en la clase
        sc=new Scanner(System.in);
        int num=99999;
        do{
            System.out.println("__________________________________________");
            System.out.println("|Dígame vostede, que e o que quere facer?|");
            System.out.println("|-----------------------------------------|");
            System.out.println("|Pulsa: 1 para Inserción de nuevas filas--|");
            System.out.println("|Pulsa: 2 para Borrar filas---------------|");// Me dirás que me quedó poco bonito el menu
            System.out.println("|Pulsa: 3 para realizar Consultas---------|");
            System.out.println("|Pulsa: 4 para realizar modificaciones----|");// Estos comentarios, en parte, son como intra-bromas
            System.out.println("|------------Pulsa 0 para salir-----------|");// A razón de que solo los leerás tu y ya quedaran para la historia
            System.out.println("|_________________________________________|");
            num=sc.nextInt();
            if(Checks.comprobarNumeroMenuGeneral(num)) {
                switch (num) {
                    case 1:
                        menuInsercion();
                        break;
                    case 2:
                        menuBorrado();
                        break;
                    case 3:
                        menuConsultas();
                        break;
                    case 4:
                        menuModificaciones();
                        break;
                }
            }

        }while (num!=0);

    }

    public static void menuInsercion(){ //Este uno de los menu
        sc=new Scanner(System.in);
        int num=999;
        do{
            System.out.println("Sea bienvenido al menú de *Inserción*");
            System.out.println("Pulsa: 1 para Añadir un nuevo Autor");
            System.out.println("Pulsa: 2 para Añadir un nuevo Libro");
            System.out.println("---------Pulsa: 0 para salir-------");
            num=sc.nextInt();
            if(Checks.comprobarNumeroMenusPeque(num)) {

                if (num == 1) {
                    Inserciones.insertarAutor();
                }
                if (num == 2) {
                    Inserciones.insertarLibro();
                }
            }
        }while (num!=0);
    }

    public static void menuBorrado(){ //Pues nada, menu de borrado
        sc=new Scanner(System.in);
        int num=999;
        do{
            System.out.println("Sea bienvenido al menú de *Borrado*");
            System.out.println("Pulsa: 1 para borrar un libro");
            System.out.println("Pulsa: 2 para borrar un autor");
            System.out.println("---------Pulsa: 0 para salir-------");
            num=sc.nextInt();
            if(Checks.comprobarNumeroMenusPeque(num)){
                if(num==1)
                    Borrados.borradoDeLibro();
                if(num==2)
                    Borrados.borradoDeAutor();
            }


        }while (num!=0);
    }

    public static void menuConsultas() { //Este es mas larguito porque tiene mas cosas
        sc = new Scanner(System.in);
        int num = 99999;
        do {
            System.out.println("______________________________________________________________");
            System.out.println("|Sea bienvenido al menu de *Consultas*------------------------|");
            System.out.println("|-------------------------------------------------------------|");
            System.out.println("|Pulsa: 1 para Consultar datos de un libro--------------------|");
            System.out.println("|Pulsa: 2 para ver todos los libros de un autor---------------|");
            System.out.println("|Pulsa: 3 para ver todos los libros---------------------------|");
            System.out.println("|Pulsa: 4 para ver todos los autores y sus libros-------------|");
            System.out.println("|------------Pulsa 0 para salir-------------------------------|");
            System.out.println("|_____________________________________________________________|");
            num = sc.nextInt();
            if(Checks.comprobarNumeroMenuGeneral(num)) {
                switch (num) {
                    case 1:
                            Consultas.consultarLibro();
                        break;
                    case 2:
                            Consultas.verTodosLibrosPorAutor();
                        break;
                    case 3:
                            Consultas.listarTodosLosLibros();
                        break;
                    case 4:
                            Consultas.listarAutoresConSusLibros();
                            break;
                }
            }
        }while (num!=0);
    }

    public static void menuModificaciones(){//Otro mas
        sc=new Scanner(System.in);
        int num=999;
        do{
            System.out.println("Sea bienvenido al menú de *Modificaciones*");
            System.out.println("Pulsa: 1 para modificar un libro por su titulo");
            System.out.println("Pulsa: 2 para modificar un autor por su DNI");
            System.out.println("---------Pulsa: 0 para salir-------");
            num=sc.nextInt();
            if(Checks.comprobarNumeroMenusPeque(num)){
                if(num==1)
                    Modificaciones.ModificarLibroPorTitulo();
                if(num==2)
                    Modificaciones.ModificarAutorPorDNI();
            }
        }while (num!=0);
    }

}
