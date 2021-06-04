import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})

/**
 * This Component is the Hello World optional challenge.
 */
export class HelloWorldComponent implements OnInit {

  userInput: string = "";

  constructor() { }

  ngOnInit(): void {
  }

}
