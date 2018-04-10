package org.learn.mongodb.data.video;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movieDetails")
public class MovieDetails {

    @Id
    private String id;
    private String title;
    private double year;
    private String rated;
    private double runtime;
    private List<String> countries;
    private List<String> genres;
    private String director;
    private List<String> writers;
    private List<String> actors;
    private String plot;
    private String poster;
    private IMDB imdb;
    private Tomato tomato;
    private double metacritic;
    private Awards awards;
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public IMDB getImdb() {
        return imdb;
    }

    public void setImdb(IMDB imdb) {
        this.imdb = imdb;
    }

    public Tomato getTomato() {
        return tomato;
    }

    public void setTomato(Tomato tomato) {
        this.tomato = tomato;
    }

    public double getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(double metacritic) {
        this.metacritic = metacritic;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rated='" + rated + '\'' +
                ", runtime=" + runtime +
                ", countries=" + countries +
                ", genres=" + genres +
                ", director='" + director + '\'' +
                ", writers=" + writers +
                ", actors=" + actors +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", imdb=" + imdb +
                ", tomato=" + tomato +
                ", metacritic=" + metacritic +
                ", awards=" + awards +
                ", type='" + type + '\'' +
                '}';
    }
}

class IMDB {

    private String id;
    private double rating;
    private double votes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }
}

class Tomato {

    private double meter;
    private String image;
    private double rating;
    private double reviews;
    private double fresh;
    private String consensus;
    private double userMeter;
    private double userRating;
    private double userReviews;

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getReviews() {
        return reviews;
    }

    public void setReviews(double reviews) {
        this.reviews = reviews;
    }

    public double getFresh() {
        return fresh;
    }

    public void setFresh(double fresh) {
        this.fresh = fresh;
    }

    public String getConsensus() {
        return consensus;
    }

    public void setConsensus(String consensus) {
        this.consensus = consensus;
    }

    public double getUserMeter() {
        return userMeter;
    }

    public void setUserMeter(double userMeter) {
        this.userMeter = userMeter;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public double getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(double userReviews) {
        this.userReviews = userReviews;
    }
}

class Awards {
    private double wins;
    private double nominations;
    private String text;

    public double getWins() {
        return wins;
    }

    public void setWins(double wins) {
        this.wins = wins;
    }

    public double getNominations() {
        return nominations;
    }

    public void setNominations(double nominations) {
        this.nominations = nominations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}