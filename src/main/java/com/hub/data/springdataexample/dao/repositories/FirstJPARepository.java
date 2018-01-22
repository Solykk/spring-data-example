package com.hub.data.springdataexample.dao.repositories;

import com.hub.data.springdataexample.domain.entities.First;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public interface FirstJPARepository extends JpaRepository<First, Long>{
}
