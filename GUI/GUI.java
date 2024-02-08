package GUI;

import Interface.Favorito;
import Interface.Juego;
import Interface.Musica;
import Interface.Pelicula;

import java.util.Scanner;

public class GUI implements Interface.GUI {

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
    public void showFavorite(Favorito f) {
        if (f != null) {
            System.out.println("|----------------------------------------------------|");
            System.out.println("|" + f + "                                               |");
            System.out.println("|----------------------------------------------------|");
        } else {
            System.out.println("|----------------------------------------------------|");
            System.out.println("| Estante disponible, es posible colocar favoritos   |");
            System.out.println("|----------------------------------------------------|");
        }

    }

    @Override
    public Favorito addFavorite() {

        System.out.println("|----------------------------------------------------|");
        System.out.println("| ¿Que favorito es el que deseas añadir              |");
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
        Pelicula pelicula = new Pelicula();
        System.out.println("inserte el nombre de la pelicula: ");

        pelicula.setPelicula();
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

}
