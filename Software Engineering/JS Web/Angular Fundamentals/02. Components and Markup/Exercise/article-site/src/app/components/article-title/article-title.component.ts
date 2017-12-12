import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'article-title',
  templateUrl: './article-title.component.html',
  styleUrls: ['./article-title.component.scss']
})
export class ArticleTitleComponent implements OnInit {

  @Input() incomingArticle;
  @Output() selection: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit() : void {}

  sendData(targetId) : void {
    this.selection.emit(targetId);
  }
}
