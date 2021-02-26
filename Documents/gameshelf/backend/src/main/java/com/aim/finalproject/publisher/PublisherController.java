package org.aim.gameshelf.publisher;

import org.aim.gameshelf.title;
import org.aim.gameshelf.publisher;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping(path = "")
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Publisher getPublisher(@PathVariable(value = "id") Integer id, HttpServletResponse response) {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        try {

            return publisher.get();

        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }

        response.setStatus(HttpStatus.NOT_FOUND.value());
        return null;
    }

    @PostMapping(path = "/")
    public String createPublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisherr);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public String updatePublisher(@PathVariable(value = "id") Integer id, @RequestBody Publisher publisherDetails) {
        Optional<Pub> optionalPublisher = publisherRepository.findById(id);
        Publisher publisher = optionalPublisher.get();

        publisher.setFirstName(publisherDetails.getFirstName());
        publisher.setLastName(publisherDetails.getLastName());

        publisherRepository.save(publisher);
        return "Updated";

    }

    @DeleteMapping(path = "/{id}")
    public String deletePublisher(@PathVariable(value = "id") Integer id) {
        publisherRepository.deleteById(id);
        return "Deleted";
    }

}