import { Component, OnInit } from '@angular/core';
import { Content } from '../content';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  contents: Content[] = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {

    this.getContent();
  }

  public getContent(): void {

    this.dataService.getAllcontent().subscribe(
      data => {
        this.contents.push(...data);
      }
    );

  }

}
