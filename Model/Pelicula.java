package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula extends Favorito implements Interface.Pelicula, Serializable {

    public Pelicula(String cod, String name, double duration, String category, LocalDate releaseDate, String author) {
        super(cod, name, duration, category, releaseDate, author);
    }

    @Override
    public String toString() {
        return "La pelicula "+ name +" tiene como datos: \n\n"+
                "Código: " + cod + "\n" +
                "Duración: " + duration +"\n"+
                "Categoría: '" + category + "\n" +
                "Fecha de lanzamiento: " + releaseDate + "\n"+
                "Estudio:" + author + "\n";
    }
}
