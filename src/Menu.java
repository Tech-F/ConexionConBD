import java.util.Scanner;

public class Menu {

    static Scanner sc;


    //Este será el menu principal
    public static void menuMaestro(){
        Conexion.conectamos();
        sc=new Scanner(System.in);
        int num=99999;
        do{
            System.out.println("__________________________________________");
            System.out.println("|Digame vostede, que he o que quere facer?|");
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
                }
            }
        }while (num!=0);

    }

    public static void menuInsercion(){
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

    public static void menuBorrado(){
        sc=new Scanner(System.in);
        int num=999;
        do{
            System.out.println("Sea bienvenido al menú de *Borrado*");
            System.out.println("Pulsa: 1 para borrar un libro");
            System.out.println("Pulsa: 2 para borrar un autor");
            System.out.println("---------Pulsa: 0 para salir-------");
            num=sc.nextInt();
            if(Checks.comprobarNumeroMenusPeque(num)){
                if(num==1){

                }
            }


        }while (num!=0);
    }

}
