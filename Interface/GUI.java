package Interface;

import java.util.ArrayList;

public interface GUI {

    public void showMainMenu();

    public void showFavorite(Favorito favToShow);

    public Favorito addFavorite();

    public Favorito removeFavorite();

    public void showResult(String resultado);

    public int leeEntero(String msg);

    public String leeString(String msg);

    public Favorito options(int o);

    public Favorito addMovie();

    public Favorito addSong();

    public Favorito addGame();

    public void solicitateNumber(int num, String msg);

    /**
     * Esta función muestra una lista, comprobando previamente si esta vacía. Si lo esta, muestra un mensaje génerico diciendo
     * que no se encontraron elementos coincidentes, de otra forma, muestra la lista que se le pasa, mostrando previamente el
     * mensaje que se le ha pasado
     * @param list la lista de favoritos que se le pasa
     * @param msg mensaje que previamente se muestra antes de imprimir la lista
     */
    public void showList(ArrayList<Favorito> list, String msg);

    /**
     * Esta función recibe un true o false y en función de true o false que recibe, muestra un mensaje diciendo
     * si se añadió el favorito o ya existía un favorito existente con el mismo código
     * @param isAdd que será true o false, para hacer la comparación
     */
    public void showIfFavoriteAdd(boolean isAdd);

    /**
     * Esta función muestra si el favorito fue borrado al pasarle un true, o false si el favorito no se encontró y
     * por tanto se muestra un mensaje diciendo que no se encontró nada que borrar
     * @param isDeleted que será true o false, true si fue borrado, false si no se encontró ninguno
     */
    public void showIfFavoriteIsDeleted(boolean isDeleted);

    /**
     * Esta función muestra si el favorito fue actualizado correctamente o si por el contrario no se encontro y no se
     * actualizo nada
     * @param isUpdate que sera true o false
     */
    public void showIfUpdate(boolean isUpdate);
}
