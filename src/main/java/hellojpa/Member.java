package hellojpa;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USER_NAME")
	private String name;

//	@Column(name = "TEAM_ID")
//	private Long teamId;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
