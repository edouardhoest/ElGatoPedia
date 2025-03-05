package elgatopedia.project.services;

import elgatopedia.project.entities.Cat;
import elgatopedia.project.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;


    public Cat findById(long id) {
        return catRepository.findById(id);
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public void save(Cat cat) {
        catRepository.save(cat);
    }
}
