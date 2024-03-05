package com.zenyoga.naveen.service;

import org.springframework.stereotype.Service;

import com.zenyoga.naveen.dto.response.Enrolldto;
import com.zenyoga.naveen.entity.Enrollentity;
import com.zenyoga.naveen.mapper.Enrollmapper;
import com.zenyoga.naveen.repository.EnrollRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Enrollservice {

    private final EnrollRepo enrollRepo;

    public Enrollservice(EnrollRepo enrollRepo) {
        this.enrollRepo = enrollRepo;
    }

    public List<Enrolldto> getAllServices() {
        List<Enrollentity> services = enrollRepo.findAll(); // Corrected method call
        return services.stream()
                .map(Enrollmapper::maptoServicedto)
                .collect(Collectors.toList());
    }


    public Enrolldto getServiceByName(String name) {
        Enrollentity enrollentity = EnrollRepo.findByName(name);
        return Enrollmapper.maptoServicedto(enrollentity);
    }

    public Enrolldto createService(Enrolldto enrolldto) {
        Enrollentity enrollentity = Enrollmapper.maptoServiceentity(enrolldto);
        enrollentity = enrollRepo.save(enrollentity);
        return Enrollmapper.maptoServicedto(enrollentity);
    }

    public Enrolldto updateServiceByName(String name,Enrolldto updatedServicedto) {
        Enrollentity existingService = EnrollRepo.findByName(name);

        if (existingService != null) {
            // Update the fields you want to allow updating
            existingService.setEmail(updatedServicedto.getEmail());
            existingService.setMobile(updatedServicedto.getMobile());
            existingService.setDate(updatedServicedto.getDate());
            existingService.setGender(updatedServicedto.getGender());
            existingService.setAddress(updatedServicedto.getAddress());
            existingService.setCity(updatedServicedto.getCity());
            existingService.setRegion(updatedServicedto.getRegion());
            existingService.setPostal(updatedServicedto.getPostal());
            existingService = enrollRepo.save(existingService);
            return Enrollmapper.maptoServicedto(existingService);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteServiceByName(String name) {
        enrollRepo.deleteByName(name);
    }
}

