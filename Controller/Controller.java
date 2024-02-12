package Controller;

import GUI.GUI;
import Model.Library;

public class Controller {
    public static GUI vista = new GUI();
    public static Library library = new Library();

    public static void startApp() {
        int option = vista.showMainMenu();
        mainController(option);



    }

    private static void mainController(int option) {
        switch (option){
            case 1:
                selectWhatToSearch();
                break;
            case 2:
                vista.showIfFavoriteAdd(library.addFav(vista.addFavorite()));
                break;
            case 3:
                vista.showIfFavoriteIsDeleted(library.deletebyId(vista.removeFavorite()));
                break;
            case 4:
                vista.showIfUpdate(library.Update(vista.updateFavorite()));






        }
    }

    private static void selectWhatToSearch() {
        int option = vista.solicitateNumber("como desea buscar: \n" +
                "1 - Buscar por ID \n" +
                "2 - Buscar por CLASE \n" +
                "3 - Buscar por NOMBRE ", 1, 3);
        switch (option){
            case 1:
                vista.showFavorite(library.findById(vista.leeString("inserte el identificador")));
                break;
            case 2:
                vista.showList(
                        library.findByClass(
                        vista.solicitateNumber("seleccione la opcion de favorito que desea buscar " +
                        "peliculas " +
                        "2 - Musica \n"  +
                        "3 - Juego",1,3)), "todos los favoritos de la misma clase son: ");

                break;
            case 3:
                vista.showList(library.findByName(vista.leeString("inserte el nombre que desea añadir: "))
                        ,"la lista de coincidencias son:");
                break;
        }
    }

}
