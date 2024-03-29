import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MatGridListModule} from '@angular/material/grid-list';
import { HelloWorldComponent } from './components/hello-world/hello-world.component';
import { RadiusComponent } from './components/radius/radius.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { DatabaseComponent } from './components/database/database.component';

const routes: Routes = [
  {path: "welcome", component: WelcomeComponent},
  {path: "", redirectTo: "welcome", pathMatch: "full"},
  {path: "hello-world", component: HelloWorldComponent},
  {path: "circumference", component: RadiusComponent},
  {path: "database", component: DatabaseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [
    RouterModule,
    MatGridListModule
  ]
})
export class AppRoutingModule { }
