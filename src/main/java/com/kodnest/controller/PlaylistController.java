package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;
import com.kodnest.service.PlaylistService;
import com.kodnest.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList );
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		 
			playlistService.addPlaylist(playlist);
			return "createplaylist";
		
	}
		
		@GetMapping("/veiwplaylist") 
		public String getplaylist(Model model) {
			List<Playlist> playList = playlistService.fetchAllPlaylists();
			model.addAttribute("playlists", playList);
			return "veiwplaylist";
		}
		
	
}
