package elgatopedia.project.controllers;

import elgatopedia.project.entities.Cat;
import elgatopedia.project.repositories.CatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatRepository catRepository;


    @GetMapping()
    public String getCats(Model model) {
        List<Cat> cats = catRepository.findAll();
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping("/{id}")
    public String getCatById(@PathVariable long id, Model model) {
        Cat cat = catRepository.findById(id);
        model.addAttribute("cat", cat);
        return "cats-details";
    }

    @PostMapping("/add")
    public String saveCat(@ModelAttribute Cat cat, Model model) {
        try {
            catRepository.save(cat);
            return "redirect:/cats";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "cats";
        }
    }
}
