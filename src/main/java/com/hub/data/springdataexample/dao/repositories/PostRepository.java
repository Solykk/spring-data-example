package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface PostRepository extends CrudRepository<Post, String> {
}
