package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Entity {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			Member memberA = new Member();
			memberA.setUsername("A");
			memberA.setRoleType(RoleType.USER);

			em.persist(memberA);

			Member memberB = new Member();
			memberB.setUsername("B");
			memberB.setRoleType(RoleType.ADMIN);

			em.persist(memberB);

			tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
