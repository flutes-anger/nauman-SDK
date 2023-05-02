package com.sdk.lotr.api;

import com.sdk.lotr.model.Movie;
import com.sdk.lotr.model.Quote;
import com.sdk.lotr.service.LotrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LotrController {

    @Autowired
    private LotrService lotrService;

    @GetMapping("/movie")
    public Movie getMovie() {
        return lotrService.getMovie();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        return lotrService.getMovieById(id);
    }

    @GetMapping("/movie/{id}/quote")
    public Movie getMovieByQuote(@PathVariable String id) {
        return lotrService.getMovieByIdAndQuote(id);
    }

    @GetMapping("/quote")
    public Quote getQuote() {
        return lotrService.getQuote();
    }

    @GetMapping("/quote/{id}")
    public Quote getQuote(@PathVariable String id) {
        return lotrService.getQuote(id);
    }

}
