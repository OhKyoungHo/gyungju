package com.example.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="calendar")
public class CalendarVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer calId;
	
	private Date calStart;
	private Date calEnd;
	private String calTitle;
	private Integer tId;
	
	private Integer calReserve;


}
