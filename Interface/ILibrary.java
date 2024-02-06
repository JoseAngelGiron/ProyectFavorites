package Interface;

public interface ILibrary {

    public String findAll();



    public Favorito findById(String ID);

    public Favorito findByClass();
    public Favorito findByName();

    public Favorito addFav();


    public void addFav(Favorito fav);

    public void deletebyId(String id);

    public void Update(Favorito fav);


}
