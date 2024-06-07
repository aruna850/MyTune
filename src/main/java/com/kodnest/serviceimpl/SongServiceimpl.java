package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Song;
import com.kodnest.entity.User;
import com.kodnest.repository.SongRepository;
import com.kodnest.service.SongService;

@Service
public class SongServiceimpl implements SongService{

	@Autowired
	SongRepository songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
		
	}


	@Override
	public boolean nameExists(Song song) {
		Song existingsong = songRepository.findByname(song.getName());
		if(existingsong!=null) {
		
			System.out.println("present");
			return true;
		}
	    else {
		     System.out.println("absent");
		     return false;
	    }
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}


	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
		
	}
	

}
