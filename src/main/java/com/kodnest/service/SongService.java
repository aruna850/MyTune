package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Song;

public interface SongService {
	
       void saveSong(Song song);

	boolean nameExists(Song song);

	List<Song> fetchAllSongs();

	void updateSong(Song song);
}
