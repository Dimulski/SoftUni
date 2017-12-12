import { Component, OnInit } from '@angular/core';

import { seed } from './../../seed';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  data: Array<any>;
  selectedArticle: Object;

  ngOnInit(): void {
    this.data = seed;
  }

  showDetails(targetId): void {
    this.selectedArticle = this.data.find(x => x.id === targetId);
  }

  deleteTargetArticle(targetId): void {
    this.data = this.data.filter(e => Number(e.id) !== Number(targetId));
    this.selectedArticle = {};
  }
}
