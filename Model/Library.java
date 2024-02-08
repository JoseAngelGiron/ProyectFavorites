package Model;

import Interface.ILibrary;

import java.util.ArrayList;
import java.util.Objects;


public class Library implements ILibrary {
    private ArrayList<Favorito> favoritos;

    public Library(){
        this(new ArrayList<>());
    }

    public Library(ArrayList<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public ArrayList<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<Favorito> favoritos) {
        this.favoritos = favoritos;
    }


    /**
     * Esta función recibe un ID y compara con todos los favoritos existentes por su ID.
     * @param ID recibe un ID con el que comparara con todos los ID de la lista
     * @return el favorito coincidente con el ID pasado. Si no encuentra, devuelve un favorito nulo.
     */
    @Override
    public Favorito findById(String ID) {
        Favorito favSearched = null;
        for (Favorito favorito:favoritos){

            if(Objects.equals(ID, favorito.getCod())){
                favSearched = favorito;

            }

        }
        return favSearched;
    }

    /**
     * Esta función se encarga de borrar favoritos de la lista.
     * @param id el id con el que hará comparaciones para borrar
     * @return
     */
    @Override
    public boolean deletebyId(String id) {
        boolean idFound = false;

        for(int i=0;i<favoritos.size() && !idFound;i++){
            if(favoritos.get(i).getName().equalsIgnoreCase(id)){
                favoritos.remove(i);
                idFound = true;
            }

        }

        return idFound;
    }

    /**
     * Esta función busca todos los elementos de una mismo tipo de favoritos. Si no hay ningún tipo, devuelve una lista
     * vacía
     * @param option la opción referente a los favoritos que se van a buscar
     * @return la lista con los favoritos que van a ser añadidos
     */
    @Override
    public ArrayList<Favorito> findByClass(int option) {
        ArrayList<Favorito> fav = new ArrayList<>();
        selectClassToSearch(option, fav);
        return fav;
    }

    /**
     * Esta función recibe un nombre de favorito y devuelve una lista con todos los favoritos que coincidan con
     * ese nombre. Si no encuentra coincidencias, devuelve una lista vacía.
     * @param name el nombre del favorito que se va a buscar
     * @return la lista de favoritos con los nombres que coinciden con el nombre dado.
     */
    @Override
    public ArrayList<Favorito> findByName(String name) {
        ArrayList<Favorito> favoriteNameList = new ArrayList<>();

        for (Favorito favorito : favoritos) {
            if (favorito.getName().equalsIgnoreCase(name)) {
                favoriteNameList.add(favorito);
            }
        }

        return favoriteNameList;
    }




    /**
     * Este metodo añade un favorito al ultimo índice de la lista, si no hay otro con el mismo ID
     * @param fav el favorito que va a recibir
     * @return true si se ha añadido, false si el fav que se ha intentado añadir ya existía porque había
     * un favorito con el mismo ID
     */
    @Override
    public boolean addFav(Favorito fav) {
        boolean noEquals = true;

        for (int i=0;i<favoritos.size() && noEquals ;i++){
            if (favoritos.get(i).equals(fav)){
                noEquals = false;
            }
        }

        if (noEquals) {
            favoritos.add(fav);
        }

        return noEquals;
    }



    @Override
    public boolean Update(Favorito fav) {

    }





    /*----- From here: Private Logic -----*/

    /**
     * Esta funcion se encarga de controlar que favortitos se van a buscar
     * @param option recibe una opción para saber que favoritos se van a buscar
     * @param fav el arreglo donde se van a a guardar los favoritos
     */
    private void selectClassToSearch(int option, ArrayList<Favorito> fav) {

        switch (option){
            case 1:
                 searchFavoriteMovies(fav);
                 break;
            case 2:
                searchFavoriteMusic(fav);
                break;
            case 3:
                searchFavoriteGames(fav);
                break;

        }



    }

    /**
     * Añade al arreglo solo los favoritos de juegos
     * @param fav el arreglo donde se van a meter los favoritos
     */
    private void searchFavoriteGames(ArrayList<Favorito> fav) {
        for(Favorito favorito:favoritos){
            if(favorito.getClass().equals(Juego.class)){
                fav.add(favorito);
            }

        }
    }

    /**
     * Añade al arreglo solo los favoritos de Movies
     * @param fav el arreglo donde se van a meter los favoritos
     */
    private void searchFavoriteMovies(ArrayList<Favorito> fav) {
        for(Favorito favorito:favoritos){
            if(favorito.getClass().equals(Pelicula.class)){
                fav.add(favorito);
            }

        }
    }

    /**
     * Añade al arreglo solo los favoritos de Música
     * @param fav el arreglo donde se van a meter los favoritos
     */
    private void searchFavoriteMusic(ArrayList<Favorito> fav) {
        for(Favorito favorito:favoritos){
            if(favorito.getClass().equals(Musica.class)){
                fav.add(favorito);
            }

        }
    }


}
