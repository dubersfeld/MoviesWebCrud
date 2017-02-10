package com.dub.movies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dub.entities.Director;
import com.dub.entities.DisplayMovie;
import com.dub.entities.Movie;
import com.dub.exceptions.ActorNotFoundException;
import com.dub.exceptions.DuplicateActorException;
import com.dub.exceptions.DuplicateMovieException;
import com.dub.exceptions.MovieNotFoundException;
import com.dub.repositories.DirectorRepository;
import com.dub.repositories.MovieRepository;

@Service
public class DefaultMovieServices implements MovieServices {

	@Resource
	private MovieRepository movieRepository;
	
	@Resource
	private DirectorRepository directorRepository;
	
	
	@Override
	public List<DisplayMovie> getAllMovies() {
		List<Movie> movies = (List<Movie>)movieRepository.findAll();
		List<DisplayMovie> list = new ArrayList<>();
		
		for (Movie movie : movies) {		
			Director director = 
					directorRepository.findOne(movie.getDirectorId());
			String name = 
					director.getFirstName() + " " + director.getLastName();
			DisplayMovie movieDisplay = new DisplayMovie(movie);
			movieDisplay.setDirectorName(name);
			list.add(movieDisplay);			
		}
		
		return list;
	}

	@Override
	public long numberOfMovies() {		
		return movieRepository.count();
	}

	@Override
	public List<DisplayMovie> getMovie(String title) 
	{			
		List<Movie> movies = movieRepository.findByTitle(title);
		
		List<DisplayMovie> list = new ArrayList<>();
		
		for (Movie movie : movies) {		
			Director director = 
					directorRepository.findOne(movie.getDirectorId());
			String name = 
					director.getFirstName() + " " + director.getLastName();
			DisplayMovie movieDisplay = new DisplayMovie(movie);
			movieDisplay.setDirectorName(name);
			list.add(movieDisplay);			
		}
		
		return list;				
	}

	@Override
	public void createMovie(Movie movie) {
		try {
			movieRepository.save(movie);
		} catch (DataIntegrityViolationException e) {	
			String ex = ExceptionUtils.getRootCauseMessage(e);
			if (ex.contains("movie_unique")) {
				throw new DuplicateMovieException();
			} else {
				throw e;
			}
		}
	}

	@Override
	public DisplayMovie getMovie(String title, Date releaseDate) {
		List<Movie> movies = movieRepository.findByTitleAndReleaseDate(title, releaseDate);
		if (!movies.isEmpty()) {
			Movie movie = movies.get(0);
			Director director = 
				directorRepository.findOne(movie.getDirectorId());
			String name = director.getFirstName() + " " + director.getLastName();
			DisplayMovie displayMovie = new DisplayMovie(movie);
			displayMovie.setDirectorName(name);
			return displayMovie;
		} else {
			throw new MovieNotFoundException();
		}
	}
	
	@Override
	public void deleteMovie(long id) {
		try {
			movieRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new MovieNotFoundException();
		}
	}
	
	@Override
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
		if (movieRepository.exists(movie.getId())) {
			movieRepository.save(movie);
		} else {
			throw new MovieNotFoundException();
		}
	}

	@Override
	public Movie getMovie(long id) {				
		Movie movie = movieRepository.findOne(id);
		if (movie != null) {
			return movie;
		} else {
			throw new MovieNotFoundException();
		}
	}
}
