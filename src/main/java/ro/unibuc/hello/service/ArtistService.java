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
}
