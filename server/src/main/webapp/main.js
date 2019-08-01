let movies = [];
let moviesElement = document.querySelector('#movies');

function ListMovies(movies) {
    return `<ul>${movies.map(ListMovie).join('')}</ul>`;
}

function ListMovie(movie) {
    return `<li>
                <p>Id: ${movie.id}</p>
                <p>Title: ${movie.title}</p>
                <p>Year: ${movie.year}</p>
            </li>`;
}

function updateMoviesElement() {
    moviesElement.innerHTML = ListMovies(movies);
}

function getMovies() {
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'v1/movies/');
    xhr.onload = function() { movies = JSON.parse(xhr.responseText); };
    xhr.send();
}

getMovies();