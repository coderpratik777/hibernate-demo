package com.pratiti.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pratiti.dao.MovieSongsDao;
import com.pratiti.entity.Movie;
import com.pratiti.entity.Song;

public class MovieSongApp {
	
	
	
	private static MovieSongsDao dao=new MovieSongsDao();
	public static void main(String[] args) {
		
		//addMovie();	
		//addSong();
		//
		//addMovieWithSong();
		//getSongByArtist();
		getMovieByArtist();
	}
	
	private static void getMovieByArtist() {
		
		List<Object[]> list=dao.fetchAlbumsByArtist("Arijit Singh");
		for(Object[] s:list) {
			Movie m = (Movie) s[0];
			String title = (String) s[1];
			System.out.println(m.getName()+" "+title);
		}
	}
	
	private static void getSongByArtist(){
		List<Song> list=dao.fetchSongsSungBy("Arijit Singh");
		for(Song s:list) {
			System.out.println(s.getTitle());
		}
	}
	private static void addMovie() {
		Movie m=new Movie();
		m.setName("Dilwale Dulhania le Jayenge");
		m.setReleasedDate(LocalDate.of(1995, 4, 2));
		dao.save(m);

		
	}
	private static void addSong() {
		Movie movie=(Movie)dao.fetchData(Movie.class, 5);
		Song s=new Song();
		s.setTitle("Mehndi laga ke rakhna");
		s.setArtist("Lata mangeshkar");
		s.setMovie(movie);
		dao.save(s);
		
	}
	private static void addMovieWithSong() {
		
		Movie m=new Movie();
		m.setName("Dhadkan");
		m.setReleasedDate(LocalDate.of(2001, 2, 3));
		
		Song s1=new Song();
		s1.setTitle("Dulhe ka sehra");
		s1.setArtist("Fateh Ali khan");
		s1.setMovie(m);
		
		Song s2=new Song();
		s2.setTitle("tum dil ki dhadkan mein");
		s2.setArtist("Kumar sanu");
		s2.setMovie(m);
		
		List<Song> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		m.setSongs(list);
		
		dao.save(m);//ensure cascade has been set up in the Movie class
		
		
		
		
		
	}

}
