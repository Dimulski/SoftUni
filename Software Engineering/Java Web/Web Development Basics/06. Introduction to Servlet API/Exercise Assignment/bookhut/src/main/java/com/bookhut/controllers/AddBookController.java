package com.bookhut.controllers;

import com.bookhut.models.bindingModels.AddBookModel;
import com.bookhut.service.BookService;
import com.bookhut.serviceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookController extends HttpServlet {

    private BookService bookService;

    public AddBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/add-book.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add = req.getParameter("add");
        if (add != null) {
            String title = req.getParameter("title");
            String content = req.getParameter("author");
            int pages = Integer.valueOf(req.getParameter("pages"));
            AddBookModel addBookModel = new AddBookModel(title,content,pages);
            this.bookService.saveBook(addBookModel);
            req.getRequestDispatcher("templates/add-book.jsp").forward(req,resp);
        }
    }
}
