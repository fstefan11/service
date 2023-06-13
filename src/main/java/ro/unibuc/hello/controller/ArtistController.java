package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.dto.ArtistDTO;
import ro.unibuc.hello.service.ArtistService;


import java.util.ArrayList;
@Controller

public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @PostMapping("/artist/create")
    @ResponseBody
    public ArtistDTO createArtist(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "genre") String genre, @RequestParam(name = "popularity") int popularity, @RequestParam(name = "hitSongs") String[] hitSongs) {
        return artistService.createArtist(name, age, genre, popularity, hitSongs);
    }

    @GetMapping("/artist/getAll")
    @ResponseBody
    public ArrayList<ArtistDTO> getArtists() {
        return artistService.getArtists();
    }

    @GetMapping("/artist/get")
    @ResponseBody
    public ArtistDTO getArtist(@RequestParam(name = "id") String id) {
        return artistService.getArtist(id);
    }

    @PutMapping("/artist/edit")
    @ResponseBody
    public ArtistDTO editArtist(@RequestParam(name = "id") String id, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "age", required = false) Integer age, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "popularity", required = false) Integer popularity, @RequestParam(name = "hitSongs", required = false) String[] hitSongs) {
        return artistService.editArtist(id, name, age, genre, popularity, hitSongs);
    }

    @DeleteMapping("/artist/delete")
    @ResponseBody
    public String deleteArtist(@RequestParam(name="id") String id) {
        return artistService.deleteArtist(id);
    }


}

