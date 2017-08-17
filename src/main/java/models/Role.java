package models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLES")
public class Role  implements Serializable, GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(unique=true)
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="role_permissions",
			joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")}
			)
	
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Permission> permission;
	
	
	public Role() {}
	
	public Role(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}

	@Override
	public String getAuthority() {
		return  getName();
	}

	@Override
	public String toString() {
		return "Role [Id=" + Id + ", name=" + name + ", permission=" + permission + "]";
	}
}
