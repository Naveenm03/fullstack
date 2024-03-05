package com.zenyoga.naveen.mapper;

import com.zenyoga.naveen.dto.response.Trainerdto;
import com.zenyoga.naveen.entity.Trainerentity;

public class Trainermapper {

    public static Trainerdto mapToTrainerDto(Trainerentity trainerEntity) {
        // Implement the mapping logic
        return new Trainerdto(
                trainerEntity.getId(),
                trainerEntity.getName(),
                trainerEntity.getMobile(),
                trainerEntity.getAge(),
                trainerEntity.getSpecialist()
        );
    }

    public static Trainerentity mapToTrainerEntity(Trainerdto trainerDto) {
        // Implement the mapping logic
        return new Trainerentity(
                trainerDto.getId(),
                trainerDto.getName(),
                trainerDto.getMobile(),
                trainerDto.getAge(),
                trainerDto.getSpecialist()
        );
    }
}
