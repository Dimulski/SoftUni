import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { GitComponent } from './git/git.component';

import { BookService } from './book.service';
import { GitService } from './git/git.service';

import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    GitComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ BookService, GitService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
