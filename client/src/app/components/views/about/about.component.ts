import { Component, OnInit } from '@angular/core'

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  constructor() {}

  public year: string = new Date().getFullYear().toString()

  ngOnInit(): void {}
}
