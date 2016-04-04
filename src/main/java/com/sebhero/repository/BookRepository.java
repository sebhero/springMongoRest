package com.sebhero.repository;

import com.sebhero.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Sebastian Börebäck on 2016-04-04.
 */

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends MongoRepository<Book,String>{

	//function name is connected to the variable in the model class.
	//findBy["name of variable"]
	List<Book> findByName(@Param("name") String name);


}
