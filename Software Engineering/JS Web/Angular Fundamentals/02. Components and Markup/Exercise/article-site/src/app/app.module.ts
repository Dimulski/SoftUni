import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { ArticleTitleComponent } from './components/article-title/article-title.component';
import { ArticleContentComponent } from './components/article-content/article-content.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleTitleComponent,
    ArticleContentComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
