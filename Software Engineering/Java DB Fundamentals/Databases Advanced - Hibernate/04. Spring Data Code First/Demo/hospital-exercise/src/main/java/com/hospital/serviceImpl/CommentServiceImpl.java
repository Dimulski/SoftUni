package com.hospital.serviceImpl;

import com.hospital.dao.CommentDao;
import com.hospital.domain.Comment;
import com.hospital.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;


    @Override
    public void create(Comment comment) {
        this.commentDao.saveAndFlush(comment);
    }
}
