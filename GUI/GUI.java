package GUI;

import Interface.Favorito;
import Interface.Juego;
import Interface.Musica;
import Interface.Pelicula;

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

    /**
     * Esta función muestra los datos del favorito que recibe. Si el favorito es nulo,
     * muestra un mensaje diciendo que el favorito no se encontro
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
        int opcion = leeEntero("Inserte una opcion valida");
        Favorito result = options(opcion);
        result.setNombre(leeString("inserte el nombre del favorito"));
        result.setCategoria
        return result;
    }

    @Override
    public Favorito removeFavorite() {
        return null;
    }

    @Override
    public void showResult(String Resultado) {

    }

    @Override
    public int leeEntero(String msg) {
        Scanner Teclado = new Scanner(System.in);
        System.out.println(msg + ": ");
        return Teclado.nextInt();
    }

    @Override
    public String leeString(String msg) {
        Scanner Teclado = new Scanner(System.in);
        System.out.println(msg + ": ");
        return Teclado.nextLine();
    }

    @Override
    public Favorito options(int o) {
        Favorito opcion;
        switch (o) {
            case 1:
                opcion = addMovie();
                break;
            case 2:
                opcion = addSong();
                break;
            default:
                opcion = addGame();
        }
        return opcion;
    }

    @Override
    public Favorito addMovie() {

        System.out.println("inserte el nombre de la pelicula: ");

        Pelicula pelicula = new Pelicula();
        return pelicula;
    }

    @Override
    public Favorito addSong() {
        Musica musica = new Musica();
        System.out.println("inserte el nombre de la cancion");

        musica.setMusica();
        return musica;
    }

    @Override
    public Favorito addGame() {
        Juego juego = new Juego();
        System.out.println("Inserte el nombre del juego");

        juego.setGame();
        return null;
    }

    @Override
    public void solicitateNumber(String msg, int num1, int num2) {
        int num;
        System.out.println(msg);
        Scanner teclado = new Scanner(System.in);
        try {
            do {
                num = teclado.nextInt();
            } while (num >=num1 && num <=num2);
        }catch (Exception e){
            System.out.println("Introduce una opcion valida");
        }

    }
    /**
     * Esta función muestra una lista, comprobando previamente si esta vacía. Si lo esta, muestra un mensaje génerico diciendo
     * que no se encontraron elementos coincidentes, de otra forma, muestra la lista que se le pasa, mostrando previamente el
     * mensaje que se le ha pasado
     * @param list la lista de favoritos que se le pasa
     * @param msg mensaje que previamente se muestra antes de imprimir la lista
     */
    public void showList(ArrayList<Favorito> list, String msg) {
        if (list.isEmpty()) {
            System.out.println("No se encontraron elementos que coincidan.");
        } else {
            System.out.println(msg);
            for (Favorito favorito : list) {
                System.out.println(favorito);
            }
        }
    }

    /**
     * Esta función recibe un true o false y en función de true o false que recibe, muestra un mensaje diciendo
     * si se añadió el favorito o ya existía un favorito existente con el mismo código
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
     * @param isUpdate que será true o false
     */
    public void showIfUpdate(boolean isUpdate) {
        if (isUpdate) {
            System.out.println("El favorito fue actualizado correctamente");
        } else {
            System.out.println("No se encontró el favorito, no se actualizó nada");
        }
    }
}
