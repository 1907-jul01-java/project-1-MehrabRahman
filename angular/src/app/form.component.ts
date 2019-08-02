import { Component, OnInit } from '@angular/core';
import { MoviesService } from './movies.service';
import { Movie } from './movie';

@Component({
  selector: 'app-form',
  template: `
    <form #newMovie="ngForm" (ngSubmit)="postMovie(newMovie.value)" >
      <input type="text" name="title" placeholder = "Title" ngModel>
      <br/>
      <input type="number" name="year" placeholder = "2019" ngModel>
      <br/>
      <input type="submit" value="submit">
    </form>
  `,
  styles: []
})
export class FormComponent implements OnInit {

  constructor(private moviesService: MoviesService) { }

  ngOnInit() {
  }
  
  postMovie(formData) {
    let movie = new Movie(0, formData.title, formData.year);
    this.moviesService.postMovie(movie)
      .subscribe();
  }
}
