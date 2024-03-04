
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		System.out.println("--INICIO DEL PROGRAMA--");
		
		//Para indicar que queremos usar hibernate definimos las interfaces
		Configuration cfg = new Configuration().configure();
		
		//Unica instancia de SessionFactory en nuestra sesion
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		
		System.out.println("--CONFIGURACION REALIZADA--");
		
		//Insertar datos en la BD
		Transaction tx = session.beginTransaction();
		Alumno a = new Alumno();
		a.setNombre("Lorenzo");
		a.setEdad(20);
		session.save(a);
		Alumno a2 = new Alumno("Paloma",21);
		session.save(a2);
		
		tx.commit();
		System.out.println("--DATOS INSERTADOS CON ÉXITO--");
		
		//Recuperar datos de la BD
		tx = session.beginTransaction();
		List<?> list = session.createQuery("FROM Alumno").list();
		for(Object p:list) {
			System.out.println(p.toString());
		}
		
		//Cerramos conexiones
		session.close();
		sessionFactory.close();
		

	}

}
