package com.zenyoga.naveen.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenyoga.naveen.dto.response.Servicedto;
import com.zenyoga.naveen.service.Serviceservice;

import java.util.List;

@RequestMapping("/trainer")

@CrossOrigin(origins="*")
@Tag(name="Book trainer",description="trainer details")
@RestController
public class Servicecontroller {

    private final Serviceservice serviceservice;

    public Servicecontroller(Serviceservice serviceservice) {
        this.serviceservice = serviceservice;
    }
    @Transactional
    @GetMapping
    public ResponseEntity<List<Servicedto>> getAllServices() {
        List<Servicedto> services = serviceservice.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
    // @Tag(name="Trainer details",description="Listing details by name")
    @Transactional
    @GetMapping("/{name}")
    public ResponseEntity<Servicedto> getServiceByName(@PathVariable String name) {
        Servicedto service = serviceservice.getServiceByName(name);
        if (service != null) {
            return new ResponseEntity<>(service, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // @Tag(name="Post",description="Adding details")
    @Transactional
    @PostMapping
    public ResponseEntity<Servicedto> createService(@RequestBody Servicedto service) {
        Servicedto createdService = serviceservice.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }
    // @Tag(name="Update",description="Updating details by name")
    @Transactional
    @PutMapping("/{name}")
    public ResponseEntity<Servicedto> updateServiceByName(@PathVariable String name, @RequestBody Servicedto updatedService) {
        Servicedto updatedServiceDto = serviceservice.updateServiceByName(name, updatedService);
        if (updatedServiceDto != null) {
            return new ResponseEntity<>(updatedServiceDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // @Tag(name="Delete",description="Deleting details by name")
    @Transactional
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteServiceByName(@PathVariable String name) {
        serviceservice.deleteServiceByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

