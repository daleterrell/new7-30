package org.aim.gameshelf.publisher;

import org.aim.gameshelf.title;
import org.aim.gameshelf.designer;

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
@RequestMapping(path = "/api/designers")
public class DesignerController {

    @Autowired
    private DesignerRepository designerRepository;

    @GetMapping(path = "")
    public Iterable<Designer> getAllDesigners() {
        return designerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Designer getDesigner(@PathVariable(value = "id") Integer id, HttpServletResponse response) {
        Optional<Designer> designer = designerRepository.findById(id);

        try {

            return designer.get();

        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }

        response.setStatus(HttpStatus.NOT_FOUND.value());
        return null;
    }

    @PostMapping(path = "/")
    public String createDesigner(@RequestBody Designer designer) {
        designerRepository.save(designerr);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public String updateDesigner(@PathVariable(value = "id") Integer id, @RequestBody Designer designerDetails) {
        Optional<Designer> optionalDesigner = designerRepository.findById(id);
        Designer designer = optionalDesigner.get();

        designer.setFirstName(designerDetails.getFirstName());
        designer.setLastName(designerDetails.getLastName());

        designerRepository.save(designer);
        return "Updated";

    }

    @DeleteMapping(path = "/{id}")
    public String deleteDesigner(@PathVariable(value = "id") Integer id) {
        designerRepository.deleteById(id);
        return "Deleted";
    }

}