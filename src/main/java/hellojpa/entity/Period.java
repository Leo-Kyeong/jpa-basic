package hellojpa.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
