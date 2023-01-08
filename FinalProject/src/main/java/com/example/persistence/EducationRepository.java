package com.example.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.EducationVO;

public interface EducationRepository extends CrudRepository<EducationVO, Integer>{

   //Pageable : Pagination 요청 정보를 담기위한 추상 인터페이스
   //Education 테이블을 페이징하는 메서드
   //전체검색을 페이징
   List<EducationVO> findAll();
   
   
   
      //0106 찬주
       //마리아디비는 문자열 연결할때 CONCAT을 사용합시다!
      //카테고리별, 메인에서 전문검색, 셀렉박스 선택용 검색 
      //네이티브 쿼리로 구현해서 페이징까지 완성된 최종본
   //AllSearchAndPagingQuery 라는 이름은 제가 만든것입니다 이해하기 쉽게~
      @Query(value="SELECT *  "
            + "FROM education "
            + "WHERE lower(ed_title) LIKE CONCAT('%',?1,'%')"
            + "OR ed_name LIKE CONCAT('%',?1,'%')"  ,
            countQuery="SELECT count(*)  "
                   + "FROM education "
                   + "WHERE lower(ed_title) LIKE CONCAT('%',?1,'%')"
                   + "OR ed_name LIKE CONCAT('%',?1,'%') ",
                   //+ "ORDER BY ed_days DESC",
            nativeQuery=true)
      Page<EducationVO> AllSearchAndPagingQuery(Pageable paging, 
            String keywords);
     
}