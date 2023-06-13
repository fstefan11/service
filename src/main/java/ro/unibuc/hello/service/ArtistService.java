package ro.unibuc.hello.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.ArtistEntity;
import ro.unibuc.hello.dto.ArtistDTO;

import java.util.ArrayList;

@Component
public class ArtistService {
    @Autowired
    private ro.unibuc.hello.data.ArtistRepository artistRepository;

    public ArtistDTO createArtist(String name, int age, String genre, int popularity, String[] hitSongs) {
        ArtistEntity artist = new ArtistEntity(name, age, genre, popularity, hitSongs);
        return new ArtistDTO(artistRepository.save(artist));
    }

    public ArrayList<ArtistDTO> getArtists() {
        ArrayList<ArtistDTO> artistDTO = new ArrayList();
        artistRepository.findAll().forEach(artistEntity -> artistDTO.add(new ArtistDTO(artistEntity)));
        return artistDTO;
    }

    public ArtistDTO getArtist(String id) {
        ArtistEntity artistEntity = artistRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
        if (artistEntity != null) {
            return new ArtistDTO(artistEntity);
        } else {
            return null;
        }
    }
    public ArtistDTO editArtist(String id, String name, Integer age, String genre, Integer popularity, String[] hitSongs) {
        ArtistEntity artist = artistRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
        if (artist != null) {
            if (name != null) {
                artist.setName(name);
            }
            if (age != null) {
                artist.setAge(age);
            }
            if (genre != null) {
                artist.setGenre(genre);
            }
            if (popularity != null) {
                artist.setPopularity(popularity);
            }
            if (hitSongs != null) {
                artist.setHitSongs(hitSongs);
            }
            return new ArtistDTO(artistRepository.save(artist));
        } else {
            return null;
        }
    }

    public String deleteArtist(String id) {
        artistRepository.deleteById(String.valueOf(new ObjectId(id)));
        return "Artist " + id + " has been successfully deleted.";



    }

}
