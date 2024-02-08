package Interface;

public interface GUI {

    public void showMainMenu();

    public void showFavorite(Favorito f);

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
     * funcion que lea el arreglo, no devuelva nada y muestre los datos de los favoritos hasta que encuentre un nulo
     */
    public void

    
}
