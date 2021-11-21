import { Component, OnInit } from '@angular/core';
import { ChooseColor } from 'src/app/models/choose-color';
import { UpdateFavoriteService } from 'src/app/services/update-favorite.service';

@Component({
  selector: 'app-update-color',
  templateUrl: './update-color.component.html',
  styleUrls: ['./update-color.component.css']
})
export class UpdateColorComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public color: string;
  public message: string;

  constructor(private service: UpdateFavoriteService) { }

  ngOnInit(): void {
  }

  updateFavorite(){
    const newFavorite = new ChooseColor(this.firstName.trim(), this.lastName.trim(), this.color);
    this.service.updateColor(newFavorite).subscribe(
      () => {
        this.message = "Thank you for the update!";
      },
      (err) => {
        console.log("update unsuccessful");
        console.log(err)
      }
    );
  }

}
