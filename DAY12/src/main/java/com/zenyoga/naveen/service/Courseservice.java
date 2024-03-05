package com.zenyoga.naveen.service;

import org.springframework.stereotype.Service;

import com.zenyoga.naveen.dto.response.Coursedto;
import com.zenyoga.naveen.entity.Academyentity;
import com.zenyoga.naveen.entity.Courseentity;
import com.zenyoga.naveen.mapper.Coursemapper;
import com.zenyoga.naveen.repository.CourseRepo;
import com.zenyoga.naveen.repository.AcademyRepo;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Courseservice {

    private final CourseRepo courseRepo;
    private final AcademyRepo academyRepo;
    public Courseservice(CourseRepo courseRepo, AcademyRepo academyRepo) {
        this.courseRepo = courseRepo;
        this.academyRepo = academyRepo;
    }

    public List<Coursedto> getAllCourses() {
        List<Courseentity> courses = courseRepo.findAll();
        return courses.stream()
                .map(Coursemapper::mapToServiceDto)
                .collect(Collectors.toList());
    }

    public Coursedto getCourseByName(String name) {
        Courseentity courseEntity = courseRepo.findByName(name);
        return Coursemapper.mapToServiceDto(courseEntity);
    }

    public Coursedto createCourse(Coursedto courseDto) {
        Courseentity courseEntity = Coursemapper.mapToServiceEntity(courseDto);
        courseEntity = courseRepo.save(courseEntity);
        return Coursemapper.mapToServiceDto(courseEntity);
    }

    public Coursedto updateCourseByName(String name, Coursedto updatedCourseDto) {
        Courseentity existingCourse = courseRepo.findByName(name);

        if (existingCourse != null) {
            // Update the fields you want to allow updating
            existingCourse.setDuration(updatedCourseDto.getDuration());
            existingCourse.setTimings(updatedCourseDto.getTimings());
           
            existingCourse = courseRepo.save(existingCourse);
            return Coursemapper.mapToServiceDto(existingCourse);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteCourseByName(String name) {
        courseRepo.deleteByName(name);
    }

    // Add this method to Courseservice.java
   


   
}
