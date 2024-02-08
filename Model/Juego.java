package Model;

public class Juego extends Favorito implements Interface.Juego  {

    @Override
    public String toString() {
        return "El juego"+ name +" tiene como datos: "+
                "Código: " + cod + '\'' +
                "Duración: " + duration +
                "Categoría: '" + category + '\'' +
                "Fecha de lanzamiento: " + releaseDate +
                "Estudio:" + author + '\'' +
                '}';
    }
}
