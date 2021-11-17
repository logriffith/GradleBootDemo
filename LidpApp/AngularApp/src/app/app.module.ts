import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetComponent } from './components/get/get.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HelloWorldComponent } from './components/hello-world/hello-world.component';
import { RadiusComponent } from './components/radius/radius.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { HomepageComponent } from './components/homepage/homepage.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { DatabaseComponent } from './components/database/database.component';
import { UsersComponent } from './components/users/users.component';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import { ChooseColorComponent } from './components/choose-color/choose-color.component';
import { GetColorComponent } from './components/get-color/get-color.component';
import { UpdateColorComponent } from './components/update-color/update-color.component';
import { DeleteColorComponent } from './components/delete-color/delete-color.component';
import {MatFormFieldModule} from '@angular/material/form-field';
//import {MatInputModule} from '@angular/material/input';


@NgModule({
  declarations: [
    AppComponent,
    GetComponent,
    HelloWorldComponent,
    RadiusComponent,
    HomepageComponent,
    NavBarComponent,
    WelcomeComponent,
    DatabaseComponent,
    UsersComponent,
    ChooseColorComponent,
    GetColorComponent,
    UpdateColorComponent,
    DeleteColorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
