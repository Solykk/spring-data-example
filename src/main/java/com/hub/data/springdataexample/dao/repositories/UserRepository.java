package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
