package hellojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
	USER("회원"), ADMIN("관리자");
	private String name;
}
