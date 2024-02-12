package Interface;

import java.util.ArrayList;

public interface FuncionesVista {

    //Esta la usaremos en conjunción con la de solicitar string
    /**
     * Esta función muestra los datos del favorito que recibe. Si el favorito es nulo,
     * muestra un mensaje diciendo que el favorito no se encontro
     * @param favToShow el favorito sobre el que se muestran datos
     */
    public void showFavorite(Favorito favToShow);

    //Lo mismo, pero para la de solicitar enteros
    /**
     * Esta función muestra una lista, comprobando previamente si esta vacía. Si lo esta, muestra un mensaje génerico diciendo
     * que no se encontraron elementos coincidentes, de otra forma, muestra la lista que se le pasa, mostrando previamente el
     * mensaje que se le ha pasado
     * @param list la lista de favoritos que se le pasa
     * @param msg mensaje que previamente se muestra antes de imprimir la lista
     */
    public void showList(ArrayList<Favorito> list, String msg);


    //Estas 3 podría haberlas simplificado en una sola, pero lo vamos a dejar así, por ahora.
    //La otra forma sería que una sola función recibiese dos mensajes que se le pasasen en el controlador
    //y sacase por pantalla el msg1 si verdadero y el msg2 si falso. Luego te digo especifico mas si hace falta

    /**
     * Esta función recibe un true o false y en función de true o false que recibe, muestra un mensaje diciendo
     * si se añadio el favorito o ya existia un favorito existente con el mismo código
     * @param isAdd que será true o false, para hacer la comparación
     */
    public void showIfFavoriteAdd(boolean isAdd);

    /**
     * Esta función muestra si el favorito fue borrado al pasarle un true, o false si el favorito no se encontro y
     * por tanto se muestra un mensaje diciendo que no se encontro nada que borrar
     * @param isDeleted que será true o false, true si fue borrado, false si no se encontro ninguno
     */
    public void showIfFavoriteIsDeleted(boolean isDeleted);

    /**
     * Esta función muestra si el favorito fue actualizado correctamente o si por el contrario no se encontro y no se
     * actualizo nada
     * @param isUpdate que sera true o false
     */
    public void showIfUpdate(boolean isUpdate);

}
