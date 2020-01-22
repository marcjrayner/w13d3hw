package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    List<Whisky> findWhiskyByYear(int year );
    public List<Whisky> findWhiskyThatHasDistilleryAndYear (String distilleryName, int year);
    List<Whisky> findWhiskyByDistilleryIdAndYear(Long id, int year);
    List<Whisky> findWhiskyByDistilleryRegion(String region);


}
