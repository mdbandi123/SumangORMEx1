package org.acumen.training.codes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class TimeSlot {
	private Integer endHr;
	private Integer endMin;

	@Column(name = "end_hr")
	public Integer getEndHr() {
		return endHr;
	}

	public void setEndHr(Integer endHr) {
		this.endHr = endHr;
	}

	@Column(name = "end_min")
	public Integer getEndMin() {
		return endMin;
	}

	public void setEndMin(Integer endMin) {
		this.endMin = endMin;
	}

}
