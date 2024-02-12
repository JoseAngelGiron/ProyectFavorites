package Controller;

import GUI.GUI;
import Model.Library;
import Persistence.Serializator;

public class Controller {
    public static GUI vista = new GUI();
    public static Library library = new Library();
    public static Library load;

    /**
     * Función encargada de iniciar el programa y cargar los datos, en caso de que existan
     *
     * Hace uso de la función mainController para poner en marcha cada una de las funcionalidades del programa
     */
    public static void startApp() {
        int option;

        if(load==null){
            load = Serializator.desearize("Biblioteca.bin");
            if(load!=null){
                library = load;
                System.out.println("\nSe han encontrado datos de favoritos y se han cargado. " +
                        "\nEstos se encuentran disponibles para su consulta.\n");
            }

        }

        do {
            option = vista.showMainMenu();
            mainController(option);
        } while (option != 5);


    }

    /**
     * Función encargada de poner en marcha las funciones del programa y de guardar los datos una vez se modifican
     * @param option que será el valor que decidira que opción se pone en marcha
     */
    private static void mainController(int option) {
        switch (option) {
            case 1:
                selectWhatToSearch();
                break;
            case 2:
                vista.showIfFavoriteAdd(library.addFav(vista.addFavorite()));
                Serializator.serialize(library, "biblioteca.bin");
                break;
            case 3:
                vista.showIfFavoriteIsDeleted(library.deletebyId(vista.removeFavorite()));
                Serializator.serialize(library, "biblioteca.bin");
                break;
            case 4:
                vista.showIfUpdate(library.Update(vista.updateFavorite()));
                Serializator.serialize(library, "biblioteca.bin");
                break;
            case 5:
                System.out.println("Ha elegido salir del programa, ¡muchas gracias y pase buen día!");
                break;
            default:
                System.out.println("La opcion introducida no se contempla");


        }
    }

    /**
     * Función encargada de decidir como se va a buscar un favorito. Hace uso de la función de la vista
     * solicitateNumber para pedir un número al usuario y poner en marcha la función de busqueda.
     */
    private static void selectWhatToSearch() {
        int option = vista.solicitateNumber("¿Como desea buscar?: \n" +
                "1 - Buscar por ID \n" +
                "2 - Buscar por CLASE \n" +
                "3 - Buscar por NOMBRE ", 1, 3);

        switch (option) {
            case 1:
                vista.showFavorite(library.findById(vista.leeString("Inserte el identificador que desea buscar")));
                break;
            case 2:
                vista.showList(library.findByClass(vista.solicitateNumber(
                        "seleccione la clase de favorito que desea buscar \n" +
                                        "1 - Peliculas \n" +
                                        "2 - Canciones \n" +
                                        "3 - Juegos", 1, 3)),
                        "Los favoritos de la clase seleccionada son: ");

                break;
            case 3:
                vista.showList(library.findByName(vista.leeString("Inserte el nombre por el que desea buscar: "))
                        , "La lista de coincidencias es: ");
                break;
        }
    }

}
