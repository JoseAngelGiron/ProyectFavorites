package Model;

import java.time.LocalDate;

public class Favorito implements Interface.Favorito {
    protected String cod;
    protected String name;
    protected double duration;
    protected String category;
    protected LocalDate releaseDate;
    protected String author;

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
    public void addFav(Interface.Favorito fav) {

    }

    @Override
    public void deletebyId(String id) {

    }

    @Override
    public String findById() {
        return null;
    }

    @Override
    public void Update(Interface.Favorito fav) {

    }
}
