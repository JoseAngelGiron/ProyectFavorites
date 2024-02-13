package GUI;

import Model.Favorito;
import Model.Juego;
import Model.Musica;
import Model.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI implements Interface.GUI {

    /**
     * Función que se encarga de mostrar el menu principal y devolver la opción selecionada
     * Hace uso de la función solicitate number
     * @return un número, entre 1 y 5
     */
    @Override
    public int showMainMenu() {
        System.out.println("Menu principal");
        System.out.println("|----------------------------------------------------|");
        System.out.println("| 1. Listar favoritos                                |");
        System.out.println("| 2. Añadir favorito                                 |");
        System.out.println("| 3. Eliminar favorito                               |");
        System.out.println("| 4. Actualizar un favorito                          |");
        System.out.println("| 5. Salir del programa                              |");
        System.out.println("|----------------------------------------------------|");
        return solicitateNumber("Introduzca una opción valida entre las mostradas ", 1,5 );
    }



    /**
     * Esta función muestra los datos del favorito que recibe. Si el favorito es nulo,
     * muestra un mensaje diciendo que el favorito no se encontro
     *
     * @param favToShow el favorito sobre el que se muestran datos
     */
    @Override
    public void showFavorite(Favorito favToShow) {
        if (favToShow != null) {
            System.out.println("|----------------------------------------------------|");
            System.out.println("|" + favToShow + "                                   |");
            System.out.println("|----------------------------------------------------|");
        } else {
            System.out.println("|----------------------------------------------------|");
            System.out.println("| El favorito no se encontro, pruebe de nuevo        |");
            System.out.println("|----------------------------------------------------|");
        }

    }

    /**
     * Funcion que solicita un número por pantalla coincidente con alguna de las opciones que se muestran.
     *
     * @return un número, entre 1 y 3, en función del número que se desea añadir.
     */
    @Override
    public Favorito addFavorite() {

        System.out.println("|----------------------------------------------------|");
        System.out.println("| ¿Que favorito es el que deseas añadir?             |");
        System.out.println("| 1. Pelicula                                        |");
        System.out.println("| 2. Canción                                         |");
        System.out.println("| 3. Juego                                           |");
        System.out.println("|----------------------------------------------------|");
        int opcion = solicitateNumber("Inserte una opcion valida", 1,3);

        return addFav(opcion);
    }

    /**
     * funcion que manda solicita un ID, para eliminar un favorito coincidente con dicho ID
     * @return devuelve el código del favorito que se va a eliminar
     */
    @Override
    public String removeFavorite() {
        return leeString("inserte el código del favorito que desea borrar: ");
    }



    /**
     * funcion que sirve para leer un string y que comprueba si esta vacio o no, en un bucle
     * @param msg el mensaje a escribir
     * @return devuelve un String, que ha introducido el usuario por pantalla
     */
    @Override
    public String leeString(String msg) {
        Scanner teclado = new Scanner(System.in);
        String msg2;
        do {
            System.out.println(msg + ": ");
            msg2 = teclado.nextLine();

            if (msg2.isEmpty()){
                System.out.println("""
                        Por favor, introduzca algún tipo de información.
                         Pruebe de nuevo por favor\s
                        """);
            }

        } while (msg2.isEmpty());
        return msg2;
    }



    /**
     * funcion que devuelve un favorito especifico, en función de la opción que se le pase
     * @param option que sera la opción que reciba, entre 1 y 3
     * @return devuelve el favorito seleccionado
     */
    @Override
    public Favorito addFav(int option) {
        Favorito fav;
        String favorito =" del videojuego";

        if(option==1){
            favorito =" de la pelicula";
        } else if (option==2) {
            favorito=" de la canción";
        }

        String cod = leeString("Inserte el codigo"+ favorito);
        String name = leeString("Inserte el nombre"+ favorito);
        double duration = solicitateDouble("Inserte la duracion"+ favorito, 0, 99);
        String category = leeString("Inserte la categoria");
        int year = solicitateNumber("Inserte el año de lanzamiento ", 1, 9999);
        int month = solicitateNumber("Inserte el mes de lanzamiento ", 1, 12);
        int day = solicitateNumber("Inserte el dia de lanzamiento ", 1, 31);
        String author = leeString("Inserte el autor al que se relaciona ");

        if(option==1){
            fav= new Pelicula(cod, name, duration, category, LocalDate.of(year, month, day), author);
        } else if (option==2) {
            fav= new Musica(cod, name, duration, category, LocalDate.of(year, month, day), author);
        }else {
            fav= new Juego(cod, name, duration, category, LocalDate.of(year, month, day), author);
        }

        return fav;
    }

    /**
     * funcion que solicita un numero entero que contempla errores y que si no introduces en numero especifico
     * entre los permitidos entra en un buble hasta que se introduzca uno permitido
     * @param msg mensaje a introducir
     * @param numMenor variable numero 1 y minimo en la funcion
     * @param numMayor variable numero 2 y maxiomo en la funcion
     * @return devuelve el numero introducido
     */
    @Override
    public int solicitateNumber(String msg, int numMenor, int numMayor) {
        int num = -1;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println(msg);
            try {
                num = teclado.nextInt();

            } catch (Exception e) {
                teclado.nextLine();
                System.out.println("Introduce una opcion valida");
            }

            if (num < numMenor || num > numMayor){
                System.out.println("La opción introducida no se contempla. Pruebe de nuevo.");
            }

        } while (num < numMenor || num > numMayor);

        return num;
    }


    /**
     * Esta función muestra una lista, comprobando previamente si esta vacía. Si lo esta, muestra un mensaje génerico diciendo
     * que no se encontraron elementos coincidentes, de otra forma, muestra la lista que se le pasa, mostrando previamente el
     * mensaje que se le ha pasado
     *
     * @param list la lista de favoritos que se le pasa
     * @param msg  mensaje que previamente se muestra antes de imprimir la lista
     */
    @Override
    public void showList(ArrayList<Favorito> list, String msg) {
        if (list.isEmpty()) {
            System.out.println("No se encontraron elementos que coincidan.");
        } else {
            System.out.println(msg);
            for (int i =0;i<list.size();i++) {
                System.out.println(" ************************************** ");
                System.out.println(" Los datos del favorito "+i+1+" son: ");
                System.out.println(list.get(i).toString());
                System.out.println(" ************************************** ");
            }
        }
    }



    /**
     * Esta función recibe un true o false y en función de true o false que recibe, muestra un mensaje diciendo
     * si se añadió el favorito o ya existía un favorito existente con el mismo código
     *
     * @param isAdd que será true o false, para hacer la comparación
     */
    public void showIfFavoriteAdd(boolean isAdd) {
        if (isAdd) {
            System.out.println("Se ha añadido el favorito correctamente.");
        } else {
            System.out.println("Ya existe un favorito con el mismo código, por lo que el favorito no se ha añadido.");
        }
    }

    /**
     * Esta función muestra si el favorito fue borrado al pasarle un true, o false si el favorito no se encontró y
     * por tanto se muestra un mensaje diciendo que no se encontró nada que borrar
     *
     * @param isDeleted que será true o false, true si fue borrado, false si no se encontró ninguno
     */
    public void showIfFavoriteIsDeleted(boolean isDeleted) {
        if (isDeleted) {
            System.out.println("El favorito fue borrado.");
        } else {
            System.out.println("No se encontró nada que borrar.");
        }
    }

    /**
     * Esta función muestra si el favorito fue actualizado correctamente o si por el contrario no se encontró y no se
     * actualizó nada
     *
     * @param isUpdate que será true o false
     */
    public void showIfUpdate(boolean isUpdate) {
        if (isUpdate) {
            System.out.println("El favorito fue actualizado correctamente");
        } else {
            System.out.println("No se encontró el favorito, no se actualizó nada");
        }
    }

    /**
     * Función que solicita un número que admite decimales al usuario, entre los valores minimo y máximos especificados
     * @param msg mensaje que se va a imprimir para informar al usuario de que debe hacer
     * @param numMenor el minimo entre el que se encuentra el numero que se le solicita al usuario
     * @param numMayor el máximo entre el que se encuentra el numero que se le solicita al usuario
     * @return el número que el usuario ha introducido por pantalla.
     */
    public double solicitateDouble(String msg, double numMenor, double numMayor) {
        double num = -1.0;

        System.out.println(msg);
        Scanner teclado = new Scanner(System.in);

        do {
            try {
                num = teclado.nextDouble();

            }catch (Exception e) {
                    teclado.nextLine();
                    System.out.println("Introduce una opcion valida");
            }

            if (num < numMenor || num > numMayor){
                System.out.println("La opción introducida no se contempla." +
                        "Debe estar entre "+numMenor+" y "+numMayor);
            }

        } while (num < numMenor || num > numMayor);

        return num;
    }

    /**
     * Función encargada de devolver un favorito con los datos a actualizar
     * @return un favorito, entre las opciones que se le solicitan al usuario. Hace uso de la función addFav.
     */
    public Favorito updateFavorite(){

        int option = solicitateNumber("""
                Inserte que tipo de favorito que desea actualizar\s
                1 - Pelicula\s
                2 - Musica\s
                3 - Juego""", 1, 3);
        return addFav(option);

    }
}
