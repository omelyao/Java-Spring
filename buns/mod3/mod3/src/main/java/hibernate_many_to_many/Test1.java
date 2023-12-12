package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Child.class).
                addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try{
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Danse");
//            Child child1 = new Child("Vika",5);
//            Child child2 = new Child("Lera",6);
//            Child child3 = new Child("Sasha",7);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
            //**************************
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("voleyball");
//            Section section2 = new Section("basketball");
//            Section section3 = new Section("chess");
//            Child child1 = new Child("Victor",12);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
            //******************************************
//
            //*******************************
//
            //*****************************
            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 7);

            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally{
            session.close();
            factory.close();

        }
    }
}
