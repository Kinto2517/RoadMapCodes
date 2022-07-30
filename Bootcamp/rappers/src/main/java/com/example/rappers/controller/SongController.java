package com.example.rappers.controller;

import com.example.rappers.entity.Song;
import com.example.rappers.entity.enums.Type;
import com.example.rappers.response.CatSong;
import com.example.rappers.response.RapperSong;
import com.example.rappers.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        songService.createSong(song);
        return ResponseEntity.status(HttpStatus.CREATED).body(song);
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable Long id) {
        return songService.getSong(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        songService.updateSong(id, song);
        return ResponseEntity.status(HttpStatus.OK).body(song);
    }

    @GetMapping("/rappers")
    public List<RapperSong> getRapperSongs() {
        List<Song> songs = songService.getSongs();
        List<RapperSong> rapperSongs = songs.stream().filter(song -> song.getRapper() != null)
                .filter(song -> song.getType() == Type.RAP)
                .map(song -> new RapperSong(song.getName(), song.getType(), song.getRapper().getName()))
                .collect(java.util.stream.Collectors.toList());

        return rapperSongs;
    }


    @GetMapping("/cats")
    public List<CatSong> getCatSongs() {
        List<Song> songs = songService.getSongs();
        List<CatSong> catSongs = songs.stream()
                .filter(song -> song.getCat() != null)
                .filter(song -> song.getType() == Type.JAZZ)
                .map(song -> new CatSong(song.getName(), song.getType(), song.getCat().getName()))
                .collect(java.util.stream.Collectors.toList());
        return catSongs;
    }


}
