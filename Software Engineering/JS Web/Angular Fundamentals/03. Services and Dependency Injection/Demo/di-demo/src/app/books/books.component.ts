import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  public books: Book[];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.books = this.bookService.getAllBooks();
  }
} 