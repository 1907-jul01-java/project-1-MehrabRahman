package com.revature.movie.api.resources.movies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
		List<Movie> movies = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			MovieDao dao = new MovieDao(connection);
			MovieService service = new MovieService(dao);
			movies = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movies;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertMovie(@FormParam("id") String id, @FormParam("title") String title, @FormParam("year") int year,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			MovieDao dao = new MovieDao(connection);
			MovieService service = new MovieService(dao);
			service.insert(new Movie(0, title, year));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/movie-api");
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertMovieJSON(Movie movie) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			MovieDao dao = new MovieDao(connection);
			MovieService service = new MovieService(dao);
			service.insert(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}