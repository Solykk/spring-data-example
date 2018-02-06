package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
