package hellojpa;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	@Column(name = "USERNAME")
	private String name;

	@Column(name = "TEAM_ID")
	private Long teamId;
}
