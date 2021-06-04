import { Component, OnInit } from '@angular/core';
import { GetChallengeServiceService } from '../get-challenge-service.service';

@Component({
  selector: 'app-get-info',
  templateUrl: './get-info.component.html',
  styleUrls: ['./get-info.component.css']
})
export class GetInfoComponent implements OnInit {

  appInfo: string;

  constructor(public info: GetChallengeServiceService) { }

  ngOnInit(): void {
  }

  displayInfo(){
    this.info.getInfo().subscribe(
      (response: string) => {
        this.appInfo = response
      },
      (err) =>{
        console.log("Error status code from back end");
        console.log(err);
      }
    );
  }

}
