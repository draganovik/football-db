import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { AboutComponent } from './pages/about/about.component'
import { AuthorComponent } from './pages/author/author.component'
import { HomeComponent } from './pages/home/home.component'
import { LeaguesComponent } from './pages/leagues/leagues.component'
import { NationalitiesComponent } from './pages/nationalities/nationalities.component'
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component'
import { TeamsComponent } from './pages/teams/teams.component'

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'about',
    component: AboutComponent
  },
  { path: 'author', component: AuthorComponent },
  { path: 'teams', component: TeamsComponent },
  { path: 'leagues', component: LeaguesComponent },
  { path: 'nationalities', component: NationalitiesComponent },
  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
