package org.acumen.training.codes.model.compositekeys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SectionId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String courseId;
	private String secId;
	private String semester;
	private Integer year;
	
	@Column(name = "course_id", unique = true, length = 8)
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "sec_id", unique = true, length = 8)
	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	@Column(name = "semester", unique = true, length = 6)
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Column(name = "year", unique = true)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
