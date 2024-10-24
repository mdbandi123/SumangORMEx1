package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.ClassroomId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Classroom {

	private ClassroomId ids;
	private Integer capacity;

	@EmbeddedId
	public ClassroomId getIds() {
		return ids;
	}

	public void setIds(ClassroomId ids) {
		this.ids = ids;
	}

	@Column(name = "capacity")
	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "%s %s %d".formatted(ids.getBuilding(), ids.getClass(), capacity);
	}

}
