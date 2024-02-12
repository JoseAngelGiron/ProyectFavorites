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
     * Menu principal del programa y la primera interraccion con el usuario
     */
    @Override
    public void showMainMenu() {
        System.out.println("Menu principal");
        System.out.println("|----------------------------------------------------|");
        System.out.println("| pulsa una opción valida mostrada a continuación    |");
        System.out.println("| 1. listar favoritos                                |");
        System.out.println("| 2. añadir favorito                                 |");
        System.out.println("| 3. eliminar favorito                               |");
        System.out.println("| 4. salir del programa                              |");
        System.out.println("|----------------------------------------------------|");
    }

    @Override
    public void showFavorite(Interface.Favorito favToShow) {

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
            System.out.println("|" + favToShow + "                                           |");
            System.out.println("|----------------------------------------------------|");
        } else {
            System.out.println("|----------------------------------------------------|");
            System.out.println("| el favorito no se encontro, prueb   |");
            System.out.println("|----------------------------------------------------|");
        }

    }

    /**
     * Funcion que añade favotito (aún por modificar)
     *
     * @return devuelve el resultado añadido
     */
    @Override
    public Favorito addFavorite() {

        System.out.println("|----------------------------------------------------|");
        System.out.println("| ¿Que favorito es el que deseas añadir?             |");
        System.out.println("| 1. Pelicula                                        |");
        System.out.println("| 2. Musica                                          |");
        System.out.println("| 3. Juego                                           |");
        System.out.println("|----------------------------------------------------|");
        int opcion = solicitateNumber("Inserte una opcion valida", 1,3);
        Favorito result = options(opcion);

        return result;
    }

    @Override
    public String removeFavorite() {
        return leeString("inserte el favorito que desea borrar: ");
    }

    @Override
    public void showResult(String Resultado) {

    }

    @Override
    public String leeString(String msg) {
        Scanner Teclado = new Scanner(System.in);
        String msg2;
        do {
            System.out.println(msg + ": ");
            msg2 = Teclado.nextLine();

        } while (!msg2.isEmpty());
        return msg;
    }

    @Override
    public Favorito options(int o) {
        Favorito fav;
        switch (o) {
            case 1:
                fav = addFav(o);
                break;
            case 2:
                fav = addFav(o);
                break;
            default:
                fav = addFav(o);




        }
        return fav;
    }

    @Override
    public Favorito addFav(int option) {
        Favorito fav = null;
        String cod = leeString("inserte el codigo de la pelicula:");
        String name = leeString("inserte el nombre de la pelicula: ");
        double duration = solicitateDouble("inserte la duracion de la pelicula: ", 0, 6);
        String category = leeString("inserte el tipo de categoria: ");
        String releaseDate = leeString("inserte la decha de lanzamiento: ");
        String author = leeString("inserte el autor al que se relaciona: ");

        if(option==1){
            Pelicula pelicula = new Pelicula(cod, name, duration, category, LocalDate.parse(releaseDate), author);
            fav=pelicula;
        } else if (option==2) {
            Musica song= new Musica(cod, name, duration, category, LocalDate.parse(releaseDate), author);
            fav=song;
        }else {
            Juego juego= new Juego(cod, name, duration, category, LocalDate.parse(releaseDate), author);
            fav=juego;
        }

        return fav;
    }


    @Override
    public int solicitateNumber(String msg, int num1, int num2) {
        int num = -1;
        System.out.println(msg);
        Scanner teclado = new Scanner(System.in);
        try {
            do {
                num = teclado.nextInt();
            } while (num >= num1 && num <= num2);
        } catch (Exception e) {
            System.out.println("Introduce una opcion valida");
        }
        return num;
    }

    @Override
    public void showList(ArrayList<Interface.Favorito> list, String msg) {
        if (list.isEmpty()) {
            System.out.println("No se encontraron elementos que coincidan.");
        } else {
            System.out.println(msg);
            for (Model.Favorito fav : list) {
                System.out.println(fav);
            }
        }
    }

    /**
     * Esta función muestra una lista, comprobando previamente si esta vacía. Si lo esta, muestra un mensaje génerico diciendo
     * que no se encontraron elementos coincidentes, de otra forma, muestra la lista que se le pasa, mostrando previamente el
     * mensaje que se le ha pasado
     *
     * @param list la lista de favoritos que se le pasa
     * @param msg  mensaje que previamente se muestra antes de imprimir la lista
     */
    public void showList(ArrayList<Favorito> list, String msg) {

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
            System.out.println("Ya existe un favorito con el mismo código.");
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

    public double solicitateDouble(String msg, int num1, int num2) {
        double num = -1;
        System.out.println(msg);
        Scanner teclado = new Scanner(System.in);
        try {
            do {
                num = teclado.nextInt();
            } while (num >= num1 && num <= num2);
        } catch (Exception e) {
            System.out.println("Introduce una opcion valida");
        }
        return num;
    }
}
