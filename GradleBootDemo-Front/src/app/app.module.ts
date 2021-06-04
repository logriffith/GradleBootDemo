import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetInfoComponent } from './components/get-info/get-info.component';
import { GetInfoServiceService } from './services/get-info-service.service';
import { HttpClientModule } from '@angular/common/http';
import { HelloWorldComponent } from './components/hello-world/hello-world.component';
import { FormsModule } from '@angular/forms';
import { RadiusComponent } from './components/radius/radius.component';

@NgModule({
  declarations: [
    AppComponent,
    GetInfoComponent,
    HelloWorldComponent,
    RadiusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
