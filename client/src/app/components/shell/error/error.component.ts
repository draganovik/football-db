import { Component, Input, OnInit } from '@angular/core'

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  @Input() icon!: String | 'warning'
  @Input() title!: String | 'Error name'
  @Input() message!: String | 'An error has occurred'
  @Input() redirect!: boolean | false
}
