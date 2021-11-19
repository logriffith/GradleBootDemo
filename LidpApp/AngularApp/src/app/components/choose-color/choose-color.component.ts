import { Component, OnInit } from '@angular/core';
import { ChooseColor } from 'src/app/models/choose-color';
import { ChooseColorService } from 'src/app/services/choose-color.service';

@Component({
  selector: 'app-choose-color',
  templateUrl: './choose-color.component.html',
  styleUrls: ['./choose-color.component.css']
})
export class ChooseColorComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public color: string;
  public message: string;

  constructor(private service: ChooseColorService) { }

  ngOnInit(): void {
  }

  chooseFavorite(){
    let newUser = new ChooseColor(this.firstName, this.lastName, this.color);
    this.service.chooseFavorite(newUser).subscribe(
      () => {
        console.log("Favorite Color Chosen.");
        this.message = "Thank You For Sharing!"
      },
      (err) => {
        console.log("Did not save user/color.")
        console.log(err);
      }
    );
  }

}
