package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.TeachesId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Teaches {
	private TeachesId ids;
	private Instructor instructor;

	@EmbeddedId
	public TeachesId getIds() {
		return ids;
	}

	public void setIds(TeachesId ids) {
		this.ids = ids;
	}
	
	@ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public String toString() {
		return "%s %s %s %s %d".formatted(ids.getId(), ids.getCourseId(), ids.getSecId(), ids.getSemester(), ids.getYear());
	}
}
