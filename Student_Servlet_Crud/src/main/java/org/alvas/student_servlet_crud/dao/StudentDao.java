package org.alvas.student_servlet_crud.dao;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.alvas.student_servlet_crud.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pratheeka");
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	Student stu = new Student();
	
	public Student saveStudent(Student stu) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(stu);
		entityTransaction.commit();
		
		return stu;
	}
	public List<Student> getAllStudent(){
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		String select="Select s From Student s";
		Query query=entityManager.createQuery(select);
		List<Student> std=query.getResultList();
		return std;

		}
	
	public Student updateStudent(int studentId, String StudentName,String StudentEmail) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Student stu = entityManager.find(Student.class, studentId);
		
		stu.setStudentName(StudentName);
		stu.setStudentEmail(StudentEmail);
		
		entityTransaction.begin();
		entityManager.merge(stu);
		entityTransaction.commit();
		
		return stu;
	}
	public Student getStudentById(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);
		
	}
	
	public Student updateStudentById(Student student, int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Student student2 = entityManager.find(Student.class, id);
		if(student2 != null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
		else {
			return null;
		}
		return student;
		
	}
	
	public Student deleteStudent(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Student student = entityManager.find(Student.class, id);
		
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		
		return student;
	}

}
