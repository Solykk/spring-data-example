package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.model.Credentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
}
