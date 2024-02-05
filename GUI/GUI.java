package GUI;

import Interface.Favorito;

public class GUI  implements Interface.GUI {

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
    public Favorito showFavorite() {
        return null;
    }

    @Override
    public Favorito addFavorite() {
        return null;
    }

    @Override
    public Favorito removeFavorite() {
        return null;
    }

    @Override
    public void showResult() {

    }
}
