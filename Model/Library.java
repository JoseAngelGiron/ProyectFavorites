package Model;



import Interface.ILibrary;

import java.util.Objects;

public class Library implements ILibrary {
    private Favorito[] favoritos;

    public Library() {
        favoritos = new Favorito[10];

    }


    public Favorito[] getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favorito[] favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public String findAll() {
        String listaFavoritos = " ";
        for (Favorito favorito:favoritos){
            listaFavoritos += favorito.toString();
        }

        return listaFavoritos;
    }

    @Override
    public Favorito findById(String ID) {
        Favorito favSearched = new Favorito();
        for (Favorito favorito:favoritos){

            if(Objects.equals(ID, favorito.getCod())){
                favSearched = favorito;

            }

        }
        return favSearched;
    }

    @Override
    public Favorito[] findByClass(int option) {
        Favorito[] fav = new Favorito[10];
        selectClassToSearch(option, fav);
        return fav;
    }


    @Override
    public Favorito findByName() {


        return null;
    }

    @Override
    public boolean addFav(Favorito fav) {
        boolean sea

        return true;
    }

    @Override
    public void addFav(Interface.Favorito fav) {

    }



    @Override
    public void deletebyId(String id) {

    }

    @Override
    public void Update(Interface.Favorito fav) {

    }



    /*----- From here: Private Logic -----*/

    /**
     * Esta funcion se encarga de controlar que favortitos se van a buscar
     * @param option recibe una opción para saber que favoritos se van a buscar
     * @param fav el arreglo donde se van a a guardar los favoritos
     */
    private void selectClassToSearch(int option, Favorito[] fav) {

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
    private void searchFavoriteGames(Favorito[] fav) {
        for(int i=0;i<favoritos.length;i++ ){
            if(favoritos[i].getClass().equals(Juego.class)){
                fav[i] = favoritos[i];
            }

        }
    }

    /**
     * Añade al arreglo solo los favoritos de Movies
     * @param fav el arreglo donde se van a meter los favoritos
     */
    private void searchFavoriteMovies(Favorito[] fav) {
        for(int i=0;i<favoritos.length;i++ ){
            if(favoritos[i].getClass().equals(Pelicula.class)){
                fav[i] = favoritos[i];
            }

        }
    }

    /**
     * Añade al arreglo solo los favoritos de Música
     * @param fav el arreglo donde se van a meter los favoritos
     */
    private void searchFavoriteMusic(Favorito[] fav) {
        for(int i=0;i<favoritos.length;i++ ){
            if(favoritos[i].getClass().equals(Musica.class)){
                fav[i] = favoritos[i];
            }

        }
    }


}
