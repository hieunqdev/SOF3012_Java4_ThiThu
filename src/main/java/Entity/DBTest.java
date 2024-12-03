package Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBTest {
	public static void main(String[] args) {
		// kết nối csdl
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Java4_QuanLy");
		// truy vấn csdl
		EntityManager em = factory.createEntityManager();

		System.out.println("Kết nối thành công");
	}

}
