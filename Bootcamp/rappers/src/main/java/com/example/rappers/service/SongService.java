package com.example.rappers.service;

import com.example.rappers.entity.Song;
import com.example.rappers.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song getSong(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public void updateSong(Long id, Song song) {
        Song oldSong = songRepository.findById(id).orElse(null);
        oldSong.setName(song.getName());
        oldSong.setType(song.getType());
        oldSong.setRapper(song.getRapper());
        songRepository.save(oldSong);
    }
}
