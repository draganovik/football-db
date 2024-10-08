import { Component } from '@angular/core'
import { Title } from '@angular/platform-browser'
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router'
import { filter, map } from 'rxjs'

@Component({
  selector: '#app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  year = new Date().getFullYear()
  constructor(private router: Router, public titleService: Title) {}

  ngOnInit() {
    this.router.events
      .pipe(
        filter((event) => event instanceof NavigationEnd),
        map(() => {
          let route: ActivatedRoute = this.router.routerState.root
          let routeTitle = ''
          while (route!.firstChild) {
            route = route.firstChild
          }
          if (route.snapshot.data['title']) {
            routeTitle = route!.snapshot.data['title'] + ' | RVA Fudbal Veb'
          }
          return routeTitle
        })
      )
      .subscribe((title: string) => {
        if (title) {
          this.titleService.setTitle(title)
        }
      })
  }
}
