import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { NavigationComponent } from './components/navigation/navigation.component'
import { HeaderComponent } from './components/header/header.component'
import { FooterComponent } from './components/footer/footer.component'

import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon'
import { MatSidenavModule } from '@angular/material/sidenav'
import { MatListModule } from '@angular/material/list'
import { MatGridListModule } from '@angular/material/grid-list'
import { MatExpansionModule } from '@angular/material/expansion'
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatTableModule } from '@angular/material/table'
import { MatSnackBarModule } from '@angular/material/snack-bar'
import { MatDialogModule } from '@angular/material/dialog'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { FormsModule } from '@angular/forms'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { AboutComponent } from './pages/about/about.component'
import { HomeComponent } from './pages/home/home.component'
import { NationalitiesComponent } from './pages/nationalities/nationalities.component'
import { TeamsComponent } from './pages/teams/teams.component'
import { LeaguesComponent } from './pages/leagues/leagues.component'
import { AuthorComponent } from './pages/author/author.component'
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component'
import { HttpClientModule } from '@angular/common/http'
import { NationalitiesDialogComponent } from './components/nationalities-dialog/nationalities-dialog.component'
import { TeamsDialogComponent } from './components/teams-dialog/teams-dialog.component'
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core'
import { MatDatepickerModule } from '@angular/material/datepicker'
import { MatSelectModule } from '@angular/material/select'
import { PlayersComponent } from './pages/players/players.component'
import { PlayersDialogComponent } from './components/players-dialog/players-dialog.component'
import { LeaguesDialogComponent } from './components/leagues-dialog/leagues-dialog.component'
import { MatSortModule } from '@angular/material/sort'
import { MatPaginatorModule } from '@angular/material/paginator'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    FooterComponent,
    AboutComponent,
    HomeComponent,
    NationalitiesComponent,
    TeamsComponent,
    LeaguesComponent,
    LeaguesDialogComponent,
    AuthorComponent,
    PageNotFoundComponent,
    NationalitiesDialogComponent,
    TeamsDialogComponent,
    PlayersComponent,
    PlayersDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatExpansionModule,
    MatToolbarModule,
    MatTableModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatSelectModule,
    MatOptionModule,
    MatSortModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
