package elgatopedia.project.controllers;

import elgatopedia.project.entities.Cat;
import elgatopedia.project.entities.Comment;
import elgatopedia.project.repositories.CommentRepository;
import elgatopedia.project.services.CatService;
import elgatopedia.project.services.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CatService catService;


    @PostMapping("/{id}/add")
    public String saveComment(@PathVariable("id") Long catId,
                              @RequestParam("username") String username,
                              @RequestParam("comment") String content) {
        try {
            Cat cat = catService.findById(catId);
            commentService.addComment(Comment.builder().comment(content).username(username).cat(cat).build());
            return "redirect:/cats/" + catId;

        } catch (Exception e) {
            return "redirect:/cats/" + catId;
        }
    }
}
