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
    public String findByClass(int option) {
        String favoriteClass;
        //logica privada que devuelva la clase referida y devuelva cuantas opciones
        Favorito TestFav = searchClass(option);

        favoriteClass

        return favoriteClass;
    }


    @Override
    public Favorito findByName() {
        return null;
    }

    @Override
    public Favorito addFav() {
        return null;
    }

    @Override
    public void addFav(Interface.Favorito fav) {

    }

    @Override
    public void addFav(Favorito fav) {

    }

    @Override
    public void deletebyId(String id) {

    }

    @Override
    public void Update(Interface.Favorito fav) {

    }

    @Override
    public void Update(Favorito fav) {

    }

    private Favorito searchClass(int option) {

        return Favorito;
    }

}
