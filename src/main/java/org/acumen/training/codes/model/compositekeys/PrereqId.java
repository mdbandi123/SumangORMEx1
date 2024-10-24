package org.acumen.training.codes.model.compositekeys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PrereqId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String courseId;
	private String prereqId;

	@Column(name = "course_id", unique = true, length = 8)
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "prereq_id", unique = true, length = 8)
	public String getPrereqId() {
		return prereqId;
	}

	public void setPrereqId(String prereqId) {
		this.prereqId = prereqId;
	}

}
