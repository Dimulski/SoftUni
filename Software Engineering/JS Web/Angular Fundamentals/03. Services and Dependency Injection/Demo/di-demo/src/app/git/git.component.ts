import { Component } from '@angular/core';
import { GitService } from './git.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';


@Component({
  selector: 'git',
  templateUrl: './git.component.html',
  styleUrls: [ './git.component.css' ]
})
export class GitComponent implements OnInit{
  public profileData: Object;

  constructor(private gitService: GitService) {}
  
  ngOnInit(): void {
    this.gitService.getProfileInfo().subscribe(data => this.profileData = data);
  }
}