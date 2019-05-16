package com.cognizant.gmdb_be.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="MOVIES")
@Data
public class Movie implements Serializable
{
    public Movie() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", unique = true, nullable = false)
    private Long MovieId;

    @Column(name="METASCORE")
    private String Metascore;

    @Column(name="BOXOFFICE")
    private String BoxOffice;

    @Column(name="WEBSITE")
    private String Website;

    @Column(name="IMDB_RATING")
    private String imdbRating;

    @Column(name="IMDB_VOTES")
    private String imdbVotes;

    @Column(name="RUNTIME")
    private String Runtime;

    @Column(name="LANGUAGE")
    private String Language;

    @Column(name="RATED")
    private String Rated;

    @Column(name="PRODUCTION")
    private String Production;

    @Column(columnDefinition = "date", name="RELEASED")
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date Released;

    @Column(name="IMDBID")
    private String imdbid;

    @Column(name="PLOT",columnDefinition = "LONGTEXT")
    private String Plot;

    @Column(name="DIRECTOR")
    private String Director;

    @Column(name="TITLE")
    private String title;

    @Column(name="ACTORS")
    private String Actors;

    @Column(name="RESPONSE")
    private String Response;

    @Column(name="TYPE")
    private String Type;

    @Column(name="AWARDS")
    private String Awards;

    @Column(columnDefinition = "date", name="DVD")
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date DVD;

    @Column(name="YEAR")
    private String year;

    @Column(name="POSTER")
    private String Poster;

    @Column(name="COUNTRY")
    private String Country;

    @Column(name="GENRE")
    private String Genre;

    @Column(name="WRITER",columnDefinition = "LONGTEXT")
    private String Writer;

    @OneToMany(mappedBy = "movie", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Review> reviews = new ArrayList<>();

    public Long getMovieId() {
        return MovieId;
    }

    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getProduction() {
        return Production;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public Date getReleased() {
        return Released;
    }

    public void setReleased(Date released) {
        Released = released;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public Date getDVD() {
        return DVD;
    }

    public void setDVD(Date DVD) {
        this.DVD = DVD;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        year = year;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

