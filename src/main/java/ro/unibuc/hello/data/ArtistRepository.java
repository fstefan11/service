package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<ArtistEntity, String>{
}
