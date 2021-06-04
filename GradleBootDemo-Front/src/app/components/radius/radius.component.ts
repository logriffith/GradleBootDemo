import { Component, OnInit } from '@angular/core';
import { RadiusServiceService } from 'src/app/services/radius-service.service';

@Component({
  selector: 'Radius',
  templateUrl: './radius.component.html',
  styleUrls: ['./radius.component.css']
})

/**
 * This is the optional challenge that calculates the circumference of a circle given a radius.
 */
export class RadiusComponent implements OnInit {

  radius: number;
  circumference: number;

  constructor(public service: RadiusServiceService) { }

  ngOnInit(): void {
  }
  //(Math.round(val * 100) / 100).toFixed(2);
  getRadius(){
    this.service.sendRadius(this.radius).subscribe(
      (result: number) => {
        this.circumference = Math.round(result * 1000)/1000;
      },
      (err) => {
        console.log("There was and error:");
        console.log(err);
      }
    );
  }

}
