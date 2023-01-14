package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.CalendarVO;

public interface CalendarRepository extends CrudRepository<CalendarVO, Integer> {

	
	
	// 달력에 입력된 db값을 List화
	@Query(value="SELECT cal_id, cal_title, cal_start,cal_end, t_id, cal_reserve FROM calendar WHERE cal_reserve = 0;", nativeQuery=true)
	List<CalendarVO> CalendarSearch();
	
	@Query(value="UPDATE calendar SET cal_reserve = 1 WHERE cal_id = ?1", nativeQuery = true)
	Integer reservation();
	
}
