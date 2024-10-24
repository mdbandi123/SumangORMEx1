package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.TakesId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Takes {
	private TakesId ids;
	private String grade;

	@EmbeddedId
	public TakesId getIds() {
		return ids;
	}

	public void setIds(TakesId ids) {
		this.ids = ids;
	}

	@Column(name = "grade", length = 2)
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "%s %s %s %s %d %s".formatted(ids.getCourseId(), ids.getId(), ids.getSecId(), ids.getSemester(),
				ids.getYear(), grade);
	}

}
