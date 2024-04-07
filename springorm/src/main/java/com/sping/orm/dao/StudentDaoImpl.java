package com.sping.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sping.orm.entities.Student;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
public class StudentDaoImpl implements StudentDao {

	HibernateTemplate hibernateTemplate;

	@Transactional
	@Override
	public int insert(Student student) {
		Integer in = (Integer) hibernateTemplate.save(student);
		return in;
	}

	@Override
	public int update(Student student) {
		hibernateTemplate.update(student);
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public Student getStudent(int id) {
		return null;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
