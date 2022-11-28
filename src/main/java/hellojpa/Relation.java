package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Relation {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Member member = new Member();
			member.setName("Member1");
			member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
			em.persist(member);

			Member member2 = new Member();
			member2.setName("Member2");
			member2.setTeam(team); // 단방향 연관관계 설정, 참조 저장
			em.persist(member2);

			em.flush();
			em.clear();
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			List<Member> members = findTeam.getMembers();
			for (Member m : members) {
				System.out.println("m.getName() = " + m.getName());
			}
			tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
