package hellojpa.entity;

import lombok.*;

import javax.persistence.Embeddable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
