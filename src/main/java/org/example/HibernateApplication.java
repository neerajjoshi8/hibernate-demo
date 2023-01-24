package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApplication {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        for (int i = 1; i < 50; ++i) {
            Student student = new Student();
            student.setName("abc" + i);
            student.setEmail("abc" + i + "@abc.com");
            student.setDepartment("IT" + i);
            session.save(student);
        }

        session.getTransaction().commit();
        List<Student> students = session.createQuery("from Student", Student.class)
                .getResultList();
        students.forEach(System.out::println);

        session.close();
    }
}
