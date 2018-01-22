package com.hub.data.springdataexample.controllers;

import com.hub.data.springdataexample.domain.entities.First;
import com.hub.data.springdataexample.services.MiddleCrudService;
import com.hub.data.springdataexample.services.SimpleCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class MainController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SimpleCrudService<First, Long> firstCrudService;

    @Autowired
    private MiddleCrudService<First, String> middleCrudService;

    @GetMapping(value = "/firsts")
    public ResponseEntity<?> getAllFirst(){
        return ResponseEntity.ok(firstCrudService.readAll());
    }

    @GetMapping(value = "/firsts/{id}")
    public ResponseEntity<?> getFirstById(@PathVariable Long id){
        return ResponseEntity.ok(firstCrudService.read(id));
    }

    @GetMapping(value = "/firsts/find")
    public ResponseEntity<?> getFirstByName(@RequestParam(value = "attribute") String name){
        return ResponseEntity.ok(middleCrudService.findUnique(name));
    }

    @PostMapping(value = "/firsts/create")
    public ResponseEntity<?> createFirstById(@RequestBody First first){
        return ResponseEntity.ok(firstCrudService.create(first));
    }

    @PostMapping(value = "/firsts/update")
    public ResponseEntity<?> updateFirstById(@RequestBody First first){
        return ResponseEntity.ok(firstCrudService.update(first));
    }

    @DeleteMapping(value = "/firsts/delete/{id}")
    public ResponseEntity<?> deleteFirstById(@PathVariable Long id) {
        firstCrudService.delete(id);
        return ResponseEntity.ok("First with id " + id + " was deleted!");
    }
}
