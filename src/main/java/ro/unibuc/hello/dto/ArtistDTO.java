package ro.unibuc.hello.dto;

import org.springframework.data.annotation.Id;
import ro.unibuc.hello.data.ArtistEntity;
import java.util.Arrays;
public class ArtistDTO {
    @Id
    private String id;

    private String name;
    private int age;
    private String genre;
    private int popularity;
    private String[] hitSongs;

    public ArtistDTO() {}

    public ArtistDTO(ArtistEntity artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.age = artist.getAge();
        this.genre = artist.getGenre();
        this.popularity = artist.getPopularity();
        this.hitSongs = artist.getHitSongs();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        if (popularity < 0 || popularity > 100) {
            throw new IllegalArgumentException("Popularity must be between 0 and 100");
        }
        this.popularity = popularity;
    }

    public String[] getHitSongs() {
        return hitSongs;
    }
    public void setHitSongs(String[] hitSongs) {
        this.hitSongs = hitSongs;
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "id='" + id + '\'' +
                ", title='" + name + '\'' +
                ", author='" + age + '\'' +
                ", genre='" + genre + '\'' +
                ", popularity='" + popularity + '\'' +
                ", hitSongs='" + Arrays.toString(hitSongs) + '\'' +
                '}';
    }
}