import { Component, OnInit, Input, Output, EventEmitter, OnChanges } from '@angular/core';

@Component({
  selector: 'article-content',
  templateUrl: './article-content.component.html',
  styleUrls: ['./article-content.component.scss']
})
export class ArticleContentComponent implements OnChanges {

  @Input() article;
  @Output() deleteArticleEmitter: EventEmitter<any> = new EventEmitter();
  
  limit: number;
  counter: number = 1;
  hide: boolean = false;
  displayImage: boolean = false;

  constructor() {}

  ngOnChanges(): void {
    this.counter = 1;
    this.limit = 0;
    this.hide = false;
    this.displayImage = false;
  }

  trunc(string): string {
    if (string) {
      return string.slice(0, this.counter * 250);
    }
  }

  readMore(): void {
    this.limit = Math.ceil(this.article.text.length / 250);
    if (this.limit === this.counter) {
      this.hide = true;
    }
    this.counter++;
  }

  hideText(): void {
    this.hide = false;
    this.counter = 1;
  }

  hideImage(): void {
    this.displayImage = false;
  }

  showImage(): void {
    this.displayImage = true;
  }

  deleteArticle(targetId: number): void {
    this.deleteArticleEmitter.emit(targetId);
  } 
}
