package com.zenyoga.naveen.service;

import org.springframework.stereotype.Service;

import com.zenyoga.naveen.dto.response.Academydto;
import com.zenyoga.naveen.entity.Academyentity;
import com.zenyoga.naveen.mapper.Academymapper;
import com.zenyoga.naveen.repository.AcademyRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Academyservice {

    private final AcademyRepo academyRepo;

    public Academyservice(AcademyRepo academyRepo) {
        this.academyRepo = academyRepo;
    }

    public List<Academydto> getAllAcademies() {
        List<Academyentity> academies = academyRepo.findAll();
        return academies.stream()
                .map(Academymapper::mapToServiceDto)
                .collect(Collectors.toList());
    }

    public Academydto getAcademyByName(String name) {
        Academyentity academyEntity = academyRepo.findByName(name);
        return Academymapper.mapToServiceDto(academyEntity);
    }

    public Academydto createAcademy(Academydto academyDto) {
        Academyentity academyEntity = Academymapper.mapToServiceEntity(academyDto);
        academyEntity = academyRepo.save(academyEntity);
        return Academymapper.mapToServiceDto(academyEntity);
    }

    public Academydto updateAcademyByName(String name, Academydto updatedAcademyDto) {
        Academyentity existingAcademy = academyRepo.findByName(name);

        if (existingAcademy != null) {
            // Update the fields you want to allow updating
            existingAcademy.setPlace(updatedAcademyDto.getPlace());
           
            existingAcademy = academyRepo.save(existingAcademy);
            return Academymapper.mapToServiceDto(existingAcademy);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteAcademyByName(String name) {
        academyRepo.deleteByName(name);
    }
}
