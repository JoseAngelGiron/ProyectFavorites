package Model;

import Persistence.Serializator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Favorito implements Interface.Favorito, Serializable {
    protected String cod;
    protected String name;
    protected double duration;
    protected String category;
    protected LocalDate releaseDate;
    protected String author;

    public Favorito(){
        this("", " ", 0, "", LocalDate.parse(""), "");
    }

    public Favorito(String cod, String name, double duration, String category, LocalDate releaseDate, String author) {
        this.cod = cod;
        this.name = name;
        this.duration = duration;
        this.category = category;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Favorito)) return false;
        Favorito favorito = (Favorito) o;
        return Objects.equals(cod, favorito.cod);
    }
}
