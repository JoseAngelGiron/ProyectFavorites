package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Musica extends Favorito implements Interface.Musica, Serializable {
    public Musica(String cod, String name, double duration, String category, LocalDate releaseDate, String author) {
        super(cod, name, duration, category, releaseDate, author);
    }

    @Override
    public String toString() {
        return "La canción"+ name +" tiene como datos: "+
                "Código: " + cod + '\'' +
                "Duración: " + duration +
                "Categoría: '" + category + '\'' +
                "Fecha de lanzamiento: " + releaseDate +
                "Estudio:" + author + '\'' +
                '}';
    }
}
