package Interface;

import java.util.ArrayList;
import Model.Favorito;

public interface ILibrary {



    public Favorito findById(String ID);

    public ArrayList<Model.Favorito> findByClass(int option);

    public ArrayList<Favorito> findByName(String name);


    public boolean addFav(Favorito favorito);




    public boolean deletebyId(String id);

    public void Update(Favorito fav);


}
