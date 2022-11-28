package hellojpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "products")
	private List<Member> members = new ArrayList<>();
}
