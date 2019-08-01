package com.revature.movie.api.resources.movies;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.domain.Movie;
import com.revature.movie.api.domain.MovieService;
import com.revature.movie.api.entities.MovieDao;

/**
 * MovieController
 * 
 */
@Path(value = "movies")
public class MovieController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMoviesJSON() {
        Connection connection = new ConnectionUtil().getConnection();
		MovieDao dao = new MovieDao(connection);
        MovieService service = new MovieService(dao);
		return service.getAll();
	}
}