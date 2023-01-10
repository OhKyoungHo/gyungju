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
	
	private Date calDate;
	private String calTime;
	private Integer tId;
}