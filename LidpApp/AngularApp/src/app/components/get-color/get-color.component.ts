import { Component, OnInit } from '@angular/core';
import { Name } from 'src/app/models/name';
import { GetFavoriteService } from 'src/app/services/get-favorite.service';

@Component({
  selector: 'app-get-color',
  templateUrl: './get-color.component.html',
  styleUrls: ['./get-color.component.css']
})
export class GetColorComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public favoriteColor: any;

  constructor(private service: GetFavoriteService) { }

  ngOnInit(): void {
  }

  getFavorite(){
    let nameOfUser = new Name(this.firstName, this.lastName);
    this.service.getFavorite(nameOfUser).subscribe(
      (response: any) => {
        this.favoriteColor = response;
      },
      (err) => {
        console.log("No favorite Color Found For User");
        console.log(err);
      }
    );
  }

}
