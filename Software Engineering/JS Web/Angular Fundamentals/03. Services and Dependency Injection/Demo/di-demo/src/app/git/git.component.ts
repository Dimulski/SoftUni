import { Component } from '@angular/core';
import { GitService } from './git.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { GitProfile } from './git.profile';

@Component({
  selector: 'git',
  templateUrl: './git.component.html',
  styleUrls: [ './git.component.css' ]
})
export class GitComponent implements OnInit{
  public profileData: GitProfile;
  public location: string;

  constructor(private gitService: GitService) {}
  
  ngOnInit(): void {
    this.gitService.getProfileInfo()
      .subscribe(data => {
        this.profileData = data;
      },
      err => {
        console.log(JSON.stringify(err.message))
      });
  }
}