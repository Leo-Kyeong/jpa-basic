package hellojpa.entity;

import hellojpa.entity.Product;
import hellojpa.entity.Team;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "MEMBER_NAME")
	private String name;

	@ManyToMany
	@JoinTable(name = "MEMBER_PRODUCT")
	private List<Product> products = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
