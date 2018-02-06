package com.hub.data.springdataexample.services.simple;

import com.hub.data.springdataexample.dao.repositories.FirstRepository;
import com.hub.data.springdataexample.domain.entities.First;
import com.hub.data.springdataexample.services.SimpleCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class FirstServiceImpl implements SimpleCrudService<First, Long> {

    private final static Logger LOGGER = LoggerFactory.getLogger(FirstServiceImpl.class);

    @Autowired
    private FirstRepository firstRepository;

    @Override
    public First create(First first) {
        LOGGER.info("Create new First -> [{}]", first.toString());
        return firstRepository.save(first);
    }

    @Override
    public First read(Long aLong) {
        LOGGER.info("Find first with id -> [{}]", aLong);
        return firstRepository.findOne(aLong);
    }

    @Override
    public List<First> readAll() {
        LOGGER.info("Find all first");
        return (List<First>) firstRepository.findAll();
    }

    @Override
    public First update(First first) {
        LOGGER.info("Update first -> [{}]", first.toString());
        return firstRepository.save(first);
    }

    @Override
    public void delete(Long aLong) {
        LOGGER.info("Delete first with id-> [{}]", aLong);
        firstRepository.delete(aLong);
    }
}
