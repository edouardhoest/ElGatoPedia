package elgatopedia.project.controllers;

import elgatopedia.project.entities.Picture;
import elgatopedia.project.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping()
    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Picture getPictureById(@PathVariable long id) {
        return pictureRepository.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> savePictures(@RequestBody Picture picture) {
        try {
            pictureRepository.save(picture);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}
