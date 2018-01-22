package com.hub.data.springdataexample.services.middle;

import com.hub.data.springdataexample.dao.repositories.FirstRepository;
import com.hub.data.springdataexample.domain.entities.First;
import com.hub.data.springdataexample.services.MiddleCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class MiddleCrudServiceImpl implements MiddleCrudService<First, String>{

    private final static Logger LOGGER = LoggerFactory.getLogger(MiddleCrudServiceImpl.class);

    @Autowired
    private FirstRepository firstRepository;

    @Override
    public First findUnique(String attribute) {
        LOGGER.info("Find first by name -> [{}]", attribute);
        return firstRepository.findByName(attribute);
    }
}
