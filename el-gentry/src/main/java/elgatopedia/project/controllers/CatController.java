package elgatopedia.project.controllers;

import elgatopedia.project.entities.Cat;
import elgatopedia.project.services.CatService;
import elgatopedia.project.services.CommentService;
import elgatopedia.project.services.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cats-list")
public class CatController {

    @Autowired
    private CatService catService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public String getCats(Model model) {
        List<Cat> cats = catService.findAll();
        model.addAttribute("cats", cats);
        return "cats-list";
    }

    @GetMapping("/{id}")
    public String getCatById(@PathVariable long id, Model model) {
        Cat cat = catService.findById(id);
        model.addAttribute("cat", cat);
        model.addAttribute("pictureList", pictureService.getPicturesByCatId(cat.getId()));
        model.addAttribute("commentList", commentService.getCommentsByCatId(cat.getId()));
        return "cats-details";
    }

    @PostMapping("/add")
    public String saveCat(@ModelAttribute Cat cat, Model model) {
        try {
            catService.save(cat);
            return "redirect:/cats-list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "cats-list";
        }
    }
}
