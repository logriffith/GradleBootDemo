import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import {User} from 'src/app/models/user';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

    users: User[];
    columnsToDisplay: string[] = ['firstName', 'lastName', 'color'];
    dataSource: any;
    
    @ViewChild('paginator') paginator!: MatPaginator;

  //@ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.displayUsers();
  }

  ngAfterViewInit(){
  }

  displayUsers(){
    this.service.getUsers().subscribe(
      (response: User[]) => {
        console.log(response);
        this.users = response;
      },

      (err) => {
        console.log("Error status code from the back end: ");
        console.log(err);
      }
    );
  }

}
