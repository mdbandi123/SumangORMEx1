package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.TimeSlotId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class TimeSlot {
	private Integer endHr;
	private Integer endMin;
	private TimeSlotId ids;
	
	@EmbeddedId
	public TimeSlotId getIds() {
		return ids;
	}

	public void setIds(TimeSlotId ids) {
		this.ids = ids;
	}

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
	
	@Override
	public String toString() {
		return "%d %d %s %s %d %d".formatted(ids.getStartHr(), ids.getStartMin(), ids.getDay(), ids.getTimeSlotId(), endHr, endMin);
	}

}
