package org.aim.gameshelf.title;

import org.aim.gameshelf.publisher;
import org.aim.gameshelf.title;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/titleshelf")
public class TitleController {

    @Autowired
    private MovieRepository titleRepository;

    @GetMapping(path = "")
    public Iterable<Movie> getAllTitles() {
        return titleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Title getTitle(@PathVariable(value = "id") Integer id) {
        Optional<Title> title = titleRepository.findById(id);
        return title.get();
    }

    @PostMapping(path = "/")
    public Title createTitle(@RequestBody Title title) {
        return titleRepository.save(title);
    }

}