package com.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.survey.model.SurveyResult;

public interface SuervyResultRepo extends JpaRepository<SurveyResult, Long> {

	@Query(value="select COUNT(*)from(SELECT * FROM survey_result WHERE awnser = 'yes')",nativeQuery = true)
	public int getYesCount();
	
	@Query(value="select COUNT(*)from(SELECT * FROM survey_result WHERE awnser = 'no')" ,nativeQuery = true)
	public int getNoCount();
}
