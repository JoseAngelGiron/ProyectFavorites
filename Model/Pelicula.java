package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula extends Favorito implements Interface.Pelicula, Serializable {

    public Pelicula(String cod, String name, double duration, String category, LocalDate releaseDate, String author) {
        super(cod, name, duration, category, releaseDate, author);
    }

    @Override
    public String toString() {
        return "La pelicula"+ name +" tiene como datos: "+
                "Código: " + cod + '\'' +
                "Duración: " + duration +
                "Categoría: '" + category + '\'' +
                "Fecha de lanzamiento: " + releaseDate +
                "Estudio:" + author + '\'' +
                '}';
    }
}
