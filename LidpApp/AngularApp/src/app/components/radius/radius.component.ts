import { Component, OnInit } from '@angular/core';
import { RadiusService } from 'src/app/services/radius.service';

@Component({
  selector: 'Radius',
  templateUrl: './radius.component.html',
  styleUrls: ['./radius.component.css']
})
export class RadiusComponent implements OnInit {

  radius: number;
  circumference: number;

  constructor(private service: RadiusService) { }

  ngOnInit(): void {
  }

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
