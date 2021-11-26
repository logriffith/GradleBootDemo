import { Component, OnInit } from '@angular/core';
import { Name } from 'src/app/models/name';
import { DeleteFavoriteService } from 'src/app/services/delete-favorite.service';

@Component({
  selector: 'app-delete-color',
  templateUrl: './delete-color.component.html',
  styleUrls: ['./delete-color.component.css']
})
export class DeleteColorComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public message: string;

  constructor(private service: DeleteFavoriteService) { }

  ngOnInit(): void {
  }

  deleteFavorite(){
    const user = new Name(this.firstName.trim(), this.lastName.trim());
    this.service.deleteColor(user).subscribe(
      () => {
        this.message = "Deletion Successful";
      },
      (err) => {
        console.log("deletion unsuccessful");
        console.log(err);
      }
    );
  }

}
