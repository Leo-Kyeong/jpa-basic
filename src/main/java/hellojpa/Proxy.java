package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Proxy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			Team team = new Team();
			team.setName("team");
			em.persist(team);

			Member member = new Member();
			member.setName("student");
			member.setTeam(team);
			em.persist(member);

			em.flush();
			em.clear();

//			Member refMember = em.getReference(Member.class, 1L);
//			System.out.println("refMember.getClass() = " + refMember.getClass());

			// 강제 초기화
			// org.hibernate.Hibernate.initialize(refMember);

			// 강제 호출
			// refMember.getName();

			 Member findMember = em.find(Member.class, 1L);
			 printMemberAndTeam(member);

			tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

	private static void printMemberAndTeam(Member member) {
		String userName = member.getName();
		System.out.println("userName = " + userName);

		Team team = member.getTeam();
		System.out.println("team = " + team.getClass());
	}
}
