package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.entities.First;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface FirstRepository extends CrudRepository<First, Long>{

    First findByName(String name);

}
