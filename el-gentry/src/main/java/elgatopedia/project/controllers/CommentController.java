package elgatopedia.project.controllers;

import elgatopedia.project.entities.Comment;
import elgatopedia.project.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentsById(@PathVariable long id) {
        return commentRepository.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> saveComment(@RequestBody Comment comment) {
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}
