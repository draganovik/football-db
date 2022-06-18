import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { NavigationComponent } from './components/shell/navigation/navigation.component'
import { HeaderComponent } from './components/shell/header/header.component'

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
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { MatCardModule } from '@angular/material/card'
import { FormsModule } from '@angular/forms'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { AboutComponent } from './components/views/about/about.component'
import { HomeComponent } from './components/views/home/home.component'
import { NationalitiesComponent } from './components/views/nationalities/nationalities.component'
import { TeamsComponent } from './components/views/teams/teams.component'
import { LeaguesComponent } from './components/views/leagues/leagues.component'
import { PageNotFoundComponent } from './components/views/page-not-found/page-not-found.component'
import { HttpClientModule } from '@angular/common/http'
import { NationalitiesDialogComponent } from './components/modals/nationalities-dialog/nationalities-dialog.component'
import { TeamsDialogComponent } from './components/modals/teams-dialog/teams-dialog.component'
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core'
import { MatDatepickerModule } from '@angular/material/datepicker'
import { MatSelectModule } from '@angular/material/select'
import { PlayersComponent } from './components/views/players/players.component'
import { PlayersDialogComponent } from './components/modals/players-dialog/players-dialog.component'
import { LeaguesDialogComponent } from './components/modals/leagues-dialog/leagues-dialog.component'
import { MatSortModule } from '@angular/material/sort'
import { MatPaginatorModule } from '@angular/material/paginator'
import { ErrorComponent } from './components/shell/error/error.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    AboutComponent,
    HomeComponent,
    NationalitiesComponent,
    TeamsComponent,
    LeaguesComponent,
    LeaguesDialogComponent,
    PageNotFoundComponent,
    NationalitiesDialogComponent,
    TeamsDialogComponent,
    PlayersComponent,
    PlayersDialogComponent,
    ErrorComponent
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
    MatPaginatorModule,
    MatCardModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
