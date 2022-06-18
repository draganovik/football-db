import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { AboutComponent } from './components/views/about/about.component'
import { HomeComponent } from './components/views/home/home.component'
import { LeaguesComponent } from './components/views/leagues/leagues.component'
import { NationalitiesComponent } from './components/views/nationalities/nationalities.component'
import { PageNotFoundComponent } from './components/views/page-not-found/page-not-found.component'
import { TeamsComponent } from './components/views/teams/teams.component'

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
    data: { title: 'Početna' }
  },
  {
    path: 'info',
    component: AboutComponent,
    data: { title: 'Informacije' }
  },
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
