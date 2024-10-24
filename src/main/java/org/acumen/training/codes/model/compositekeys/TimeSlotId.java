package org.acumen.training.codes.model.compositekeys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TimeSlotId implements Serializable{
	private static final long serialVersionUID = 1L;
	private String timeSlotId;
	private String day;
	private Integer startHr;
	private Integer startMin;

	@Column(name = "time_slot_id", unique = true, length = 4)
	public String getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(String timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	@Column(name = "day", unique = true, length = 1)
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Column(name = "start_hr", unique = true)
	public Integer getStartHr() {
		return startHr;
	}

	public void setStartHr(Integer startHr) {
		this.startHr = startHr;
	}

	@Column(name = "start_min", unique = true)
	public Integer getStartMin() {
		return startMin;
	}

	public void setStartMin(Integer startMin) {
		this.startMin = startMin;
	}

}
