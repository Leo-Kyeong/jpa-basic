package hellojpa;

import hellojpa.entity.Member;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			// INSERT
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloA");
            em.persist(member);

            // SELECT(단건 조회)
            Member findMember = em.find(Member.class, 1L);

            // SELECT(다중건 조회)
            // setFirstResult(int startPosition) : 조회 시작 위치
            // setMaxResults(int maxResult) : 조회할 데이터 수
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member memberFind : result) {
                System.out.println("member.getName = "+ memberFind.getName());
            }

            // DELETE
            em.remove(findMember);

            // UPDATE(dirty checking)
            findMember.setName("HelloJPA");

            tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
