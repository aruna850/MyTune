package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Song;
import com.kodnest.entity.User;
import com.kodnest.service.SongService;

@Controller
public class SongController {
      @Autowired
      SongService songService;
 
      
      
	@PostMapping("/addsongs")
	public String addsong(@ModelAttribute Song song) {
		
		
		boolean songExists = songService.nameExists(song);
		if(songExists==false){
			
		     songService.saveSong(song);
		     System.out.println("song added successfully");
		}
		else {
			System.out.println("Duplicate song");
		}
		return "adminhome";
	}
	@GetMapping("/playsongs")
	public String playsong(Model model) {
		boolean paymentstatus = false;
		if(paymentstatus) {
			List<Song> songsList =songService.fetchAllSongs();
			model.addAttribute("songs",songsList);
			return "veiw";
		}
		else {
			return "pay";
		}
	}
	
	@GetMapping("/veiwsongs")
	public String veiwsong(Model model) {
		
		
			List<Song> songsList =songService.fetchAllSongs();
			model.addAttribute("songs",songsList);
			return "veiw";
		
	}
}
