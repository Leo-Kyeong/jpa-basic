package hellojpa;

import hellojpa.entity.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
@Slf4j
public class Entity {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			Member member = new Member();
			member.setName("A");

			log.info("============================");
			log.info("member id = {}",member.getId());

			em.persist(member);

			log.info("member id = {}",member.getId());
			log.info("============================");

			tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
