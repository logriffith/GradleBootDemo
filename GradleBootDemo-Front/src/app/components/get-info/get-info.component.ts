import { Component, OnInit } from '@angular/core';
import { GetInfo } from 'src/app/models/get-info';
import { GetInfoServiceService } from 'src/app/services/get-info-service.service';

@Component({
  selector: 'app-get-info',
  templateUrl: './get-info.component.html',
  styleUrls: ['./get-info.component.css']
})
export class GetInfoComponent implements OnInit {

  appInfo: GetInfo = {
      date: "",
      appName: ""
  };

  constructor(private service: GetInfoServiceService) { }

  ngOnInit(): void {
    this.displayInfo();
  }

  displayInfo() {
    this.service.getInfo().subscribe(
      (response: GetInfo) => {
        console.log(response)
        this.appInfo.date = response.date;
        this.appInfo.appName = response.appName;
      },
      (err) => {
        console.log("Error status code from back end: ");
        console.log(err);
      }
    );
  }

}
