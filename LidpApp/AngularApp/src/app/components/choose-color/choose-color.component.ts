import { Component, OnInit } from '@angular/core';
import { FavoriteColor } from 'src/app/models/favorite-color';
import { User } from 'src/app/models/user';
import { ChooseColorService } from 'src/app/services/choose-color.service';

@Component({
  selector: 'app-choose-color',
  templateUrl: './choose-color.component.html',
  styleUrls: ['./choose-color.component.css']
})
export class ChooseColorComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public color: FavoriteColor;

  constructor(private service: ChooseColorService) { }

  ngOnInit(): void {
  }

  chooseFavorite(){
    let user: User = new User(0, this.firstName, this.lastName, this.color);
    this.service.chooseFavorite(user).subscribe(
      () => {
        console.log("Favorite Color Chosen.");
      },
      (err) => {
        console.log("Did not save user/color.")
      }
    );
  }

}
