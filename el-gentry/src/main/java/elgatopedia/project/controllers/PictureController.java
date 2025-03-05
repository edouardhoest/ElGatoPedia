package elgatopedia.project.controllers;

import elgatopedia.project.entities.Cat;
import elgatopedia.project.entities.Picture;
import elgatopedia.project.services.CatService;
import elgatopedia.project.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CatService catService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPicture(@PathVariable Long id) {
        Optional<Picture> picture = pictureService.getPictureById(id);
        if (picture.isPresent() && picture.get().getPictureData() != null) {
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(picture.get().getPictureData());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/add")
    public String savePictures(@PathVariable("id") Long catId, @RequestParam("picture_name") String pictureName,
                               @RequestParam("picture") MultipartFile pictureFile) {
        try {
            Cat cat = catService.findById(catId);
            Picture picture = Picture.builder()
                    .pictureData(pictureFile.getBytes())
                    .pictureName(pictureName)
                    .cat(cat)
                    .build();
            pictureService.savePicture(picture);
        } catch (Exception e) {
            return "redirect:/cats-list/" + catId;
        }
        return "redirect:/cats-list/" + catId;
    }
}
