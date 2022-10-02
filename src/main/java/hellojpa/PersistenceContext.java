package hellojpa;

import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceContext {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
//			// 비영속
//			Member member = new Member();
//			member.setId(100L);
//			member.setUsername("HelloB");
//
//			// 영속
//			em.persist(member);
//
//			// 준영속 (영속성 컨텍스트에서 분리)
//			em.detach(member);
//
//			// 객체를 삭제한 상태
//			em.remove(member);

            tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
