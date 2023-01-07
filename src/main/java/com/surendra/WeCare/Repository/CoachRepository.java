package com.surendra.WeCare.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.surendra.WeCare.Entity.CoachEntity;

public interface CoachRepository extends CrudRepository<CoachEntity, String>{

	 public Optional<CoachEntity> findByCoachId(String coachId);
}
