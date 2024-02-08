package Model;

public class Juego extends Favorito implements Interface.Juego  {

    @Override
    public String toString() {
        return "Juego{" +
                "cod='" + cod + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                ", releaseDate=" + releaseDate +
                ", author='" + author + '\'' +
                '}';
    }
}
