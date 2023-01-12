package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.CalendarVO;

public interface CalendarRepository extends CrudRepository<CalendarVO, Integer> {

	// 달력에 입력된 db값을 List화
	@Query(value="SELECT cal_id, cal_title, cal_start,cal_end, t_id "
			+ "FROM CALENDAR", nativeQuery=true)
	List<CalendarVO> CalendarSearch();
	
}