package br.com.ezequielprojets.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	
	private String roleName;
	
	private Set<User> users = new HashSet<>();

	public Role(Long id, String roleName) {
		super();
		Id = id;
		this.roleName = roleName;
	}

	public Role() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public Set<User> getUsers() {
		return users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
	

}
