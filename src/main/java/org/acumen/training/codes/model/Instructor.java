package org.acumen.training.codes.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Instructor {
	private String id;
	private String name;
	private String deptName;
	private Double salary;
	
	private Set<Teaches> teaches;

	@Id
	@Column(name = "id", unique = true, length = 5)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dept_name", length = 20)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String dept_name) {
		this.deptName = dept_name;
	}

	@Column(name = "salary")
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	public Set<Teaches> getTeaches() {
		return teaches;
	}
	
	public void setTeaches(Set<Teaches> teaches) {
		this.teaches = teaches;
	}
	
	@Override
	public String toString() {
		return "%s %s %s %f".formatted(id, name, deptName, salary);
	}

}
