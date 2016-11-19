package app.service;

import app.domain.Comment;
import app.repositories.CommentRepository;
import app.service.contracts.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void create(Comment comment) {
        this.commentRepository.saveAndFlush(comment);
    }
}
