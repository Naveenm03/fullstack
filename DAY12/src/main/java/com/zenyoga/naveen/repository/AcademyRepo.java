package com.zenyoga.naveen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenyoga.naveen.entity.Academyentity;

@Repository
public interface AcademyRepo extends JpaRepository<Academyentity, Long> {
    Academyentity findByName(String name) ;
    
    void deleteByName(String name);
    // Other methods...
}
