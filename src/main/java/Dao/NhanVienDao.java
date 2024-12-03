package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entity.NhanVien;

public class NhanVienDao {
	// kết nối csdl
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Java4_QuanLy");
	// truy vấn csdl
	EntityManager em = factory.createEntityManager();
	
	public List<NhanVien> getAll() {
		String jpql = "SELECT o FROM NhanVien o";
		TypedQuery<NhanVien> query = em.createQuery(jpql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list;
	}
	
	public void createNV(NhanVien nv) {
		try {
			em.getTransaction().begin();
			em.persist(nv);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
