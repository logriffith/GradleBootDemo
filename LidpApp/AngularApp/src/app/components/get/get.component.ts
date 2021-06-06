import { Component, OnInit } from '@angular/core';
import { GetInfo } from 'src/app/models/get-info';
import { GetService } from 'src/app/services/get.service';

@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrls: ['./get.component.css']
})

/**
 * The Get Info Component represents the option to get the current date and the name of the application.
 */
export class GetComponent implements OnInit {

  appInfo: GetInfo = {
    date: "",
    appName: ""
  };

  constructor(private service : GetService) { }

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
