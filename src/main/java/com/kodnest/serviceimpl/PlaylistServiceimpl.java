package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;
import com.kodnest.repository.PlaylistRepository;
import com.kodnest.service.PlaylistService;

@Service
public class PlaylistServiceimpl implements PlaylistService{
	  @Autowired
      PlaylistRepository playlistRepository;


	@Override
	public void addPlaylist(Playlist playlist) {
		Playlist existplaylist = playlistRepository.findByname(playlist.getName());
		if(existplaylist==null) {
		      playlistRepository.save(playlist);
		}
		else {
			System.out.println("Playlist already exist");
		}
	}


	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> playlists = playlistRepository.findAll();
		return playlists;
		
	}

}
