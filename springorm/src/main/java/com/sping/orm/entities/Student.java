package com.sping.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "rollNo")
	private String rollNo;
	@Column(name = "marks")
	private String marks;

	/**
	 * @param id
	 * @param name
	 * @param rollNo
	 * @param marks
	 */
	public Student(int id, String name, String rollNo, String marks) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	/**
	 * 
	 */
	public Student() {
	}

}
