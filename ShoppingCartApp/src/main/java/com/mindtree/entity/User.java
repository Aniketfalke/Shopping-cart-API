package com.mindtree.entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	@OrderColumn
	private String[] roles;

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, userId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& userId == other.userId && Objects.equals(userName, other.userName);
	}

}
