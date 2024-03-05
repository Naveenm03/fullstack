package com.zenyoga.naveen.mapper;

import com.zenyoga.naveen.dto.response.Servicedto;
import com.zenyoga.naveen.entity.Serviceentity;

public class Servicemapper {

    public static Servicedto maptoServicedto(Serviceentity serviceentity) {
        // Implement the mapping logic
        return new Servicedto(
                serviceentity.getId(),
                serviceentity.getName(),
                serviceentity.getEmail(),
                serviceentity.getMobile(),
                serviceentity.getTrainer(),
                serviceentity.getGoal()
        );
    }

    public static Serviceentity maptoServiceentity(Servicedto servicedto) {
        // Implement the mapping logic
        return new Serviceentity(
                servicedto.getId(),
                servicedto.getName(),
                servicedto.getEmail(),
                servicedto.getMobile(),
                servicedto.getTrainer(),
                servicedto.getGoal()
        );
    }
}

