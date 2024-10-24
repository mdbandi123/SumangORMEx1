package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.PrereqId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Prereq {
	private PrereqId ids;

	@EmbeddedId
	public PrereqId getIds() {
		return ids;
	}

	public void setIds(PrereqId ids) {
		this.ids = ids;
	}
	
	@Override
	public String toString() {
		return "%s %s".formatted(ids.getCourseId(), ids.getPrereqId());
	}
}
