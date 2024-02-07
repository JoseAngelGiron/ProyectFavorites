package Interface;

public interface ILibrary {

    public String findAll();



    public Favorito findById(String ID);

    public Favorito[] findByClass(int option);



    public Favorito findByName();

    public Favorito addFav();


    public boolean addFav(Favorito fav);

    public void deletebyId(String id);

    public void Update(Favorito fav);


}
