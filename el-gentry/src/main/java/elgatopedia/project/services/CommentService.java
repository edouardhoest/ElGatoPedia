package elgatopedia.project.services;

import elgatopedia.project.entities.Comment;
import elgatopedia.project.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByCatId(long catId) {
        return commentRepository.findAllByCatId(catId);
    }

}
