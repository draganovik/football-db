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
  { path: '', component: HomeComponent, data: { title: 'Home' } },
  {
    path: 'info',
    component: AboutComponent,
    data: { title: 'Informacije' }
  },
  { path: 'autor', component: AuthorComponent, data: { title: 'Autor' } },
  { path: 'timovi', component: TeamsComponent, data: { title: 'Timovi' } },
  { path: 'lige', component: LeaguesComponent, data: { title: 'Lige' } },
  {
    path: 'nacionalnosti',
    component: NationalitiesComponent,
    data: { title: 'Nacionalnosti' }
  },
  {
    path: '**',
    component: PageNotFoundComponent,
    data: { title: 'Stranica nije pronađena' }
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
