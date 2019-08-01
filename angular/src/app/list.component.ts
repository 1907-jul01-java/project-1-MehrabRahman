import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from './movie';
import { MoviesService } from './movies.service'

@Component({
  selector: 'app-list',
  template: `
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Year</th>
        </tr>
        <tr *ngFor="let movie of movies | async">
          <td>{{movie.id}}</td>
          <td>{{movie.title}}</td>
          <td>{{movie.year}}</td>
        </tr>
    </table>
  `,
  styles: []
})
export class ListComponent implements OnInit {

  movies:Observable<Movie[]>

  constructor(private moviesService: MoviesService) { }

  ngOnInit() {
    this.movies = this.moviesService.getMovies();
  }

}
