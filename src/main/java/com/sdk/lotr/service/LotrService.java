package com.sdk.lotr.service;

import com.sdk.lotr.model.Movie;
import com.sdk.lotr.model.Quote;
import org.springframework.stereotype.Service;

@Service
public class LotrService {

    public Movie getMovie() {
        return new Movie("1", "The Fellowship of the Ring");
    }

    public Movie getMovieById(String Id) {
        return new Movie("1", "The Fellowship of the Ring");
    }

    public Movie getMovieByIdAndQuote(String id) {
        return new Movie("1", "The Fellowship of the Ring");
    }

    public Quote getQuote() {
        return new Quote("1", "No living man can kill him");
    }

    public Quote getQuote(String id) {
        return new Quote("1", "No living man can kill him");
    }
}
