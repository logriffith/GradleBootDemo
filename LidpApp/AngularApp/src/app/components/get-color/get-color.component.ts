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
  public favoriteColor: string;

  constructor(private service: GetFavoriteService) { }

  ngOnInit(): void {
  }

  getFavorite(){
    let nameOfUser = new Name(this.firstName.trim(), this.lastName.trim());
    this.service.getFavorite(nameOfUser).subscribe(
      (response: any) => {
        const color = response.body;
        if(color == null){
          this.favoriteColor = "unknown";
        }else{ 
          this.favoriteColor = response.body;
        }
      },
      (err) => {
        console.log("No favorite Color Found For User");
        console.log(err);
      }
    );
  }

}
