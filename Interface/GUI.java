package Interface;

import java.util.ArrayList;
import Model.Favorito;

public interface GUI {

    public  int showMainMenu();

    public void showFavorite(Favorito favToShow);

    public Favorito addFavorite();

    public String removeFavorite();

    public String leeString(String msg);



    public Favorito addFav(int num);


    public int solicitateNumber( String msg, int num1, int num2);


    public void showList(ArrayList<Favorito> list, String msg);


    public void showIfFavoriteAdd(boolean isAdd);


    public void showIfFavoriteIsDeleted(boolean isDeleted);


    public void showIfUpdate(boolean isUpdate);

    public double solicitateDouble(String msg, double num1, double num2);
    public Model.Favorito updateFavorite();
}
