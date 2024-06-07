package com.kodnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{
	Playlist findByname(String name);
	
}
