package elgatopedia.project.services;


import elgatopedia.project.entities.Picture;
import elgatopedia.project.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;


    public Optional<Picture> getPictureById(long id) {
        return Optional.of(pictureRepository.findById(id));
    }

    public void savePicture(Picture picture) {
        pictureRepository.save(picture);
    }

    public List<Picture> getPicturesByCatId(Long catId) {
        return pictureRepository.findAllByCatId(catId);
    }
}
