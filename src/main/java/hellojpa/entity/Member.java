package hellojpa.entity;

import hellojpa.entity.Product;
import hellojpa.entity.Team;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Embedded
	private Period workPeriod;

	@Embedded
	private Address homeAddress;

	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns =
		@JoinColumn(name = "MEMBER_ID")
	)
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "ADDRESS", joinColumns =
		@JoinColumn(name = "MEMBER_ID")
	)
	private List<Address> addressHistory = new ArrayList<>();

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "city",
					column = @Column(name = "WORK_CITY")),
			@AttributeOverride(name = "street",
					column = @Column(name = "WORK_STREET")),
			@AttributeOverride(name = "zipcode",
					column = @Column(name = "WORK_ZIPCODE")),
	})
	private Address workAddress;

	@ManyToMany
	@JoinTable(name = "MEMBER_PRODUCT")
	private List<Product> products = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
