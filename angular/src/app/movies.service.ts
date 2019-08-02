import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './Movie';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  private moviesUrl = 'http://localhost:8080/movie-api/v1/movies';

  constructor(private httpClient:HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(this.moviesUrl);
  }

  postMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.post<Movie>(this.moviesUrl, movie);
  }
}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};