package org.aim.gameshelf.title;

import org.aim.gameshelf.publisher;
import org.aim.gameshelf.designer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/gameshelf")
public class GameController {

    @Autowired
    private MovieRepository gameRepository;

    @GetMapping(path = "")
    public Iterable<Movie> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Game getGame(@PathVariable(value = "id") Integer id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.get();
    }

    @PostMapping(path = "/")
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

}