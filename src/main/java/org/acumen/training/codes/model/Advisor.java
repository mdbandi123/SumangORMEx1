package org.acumen.training.codes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Advisor {
	private String sId;
	private String iId;

	@Id
	@Column(name = "s_id", unique = true, length = 5)
	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	@Column(name = "i_id", length = 5)
	public String getiId() {
		return iId;
	}

	public void setiId(String iId) {
		this.iId = iId;
	}
	
	@Override
	public String toString() {
		return "%s %s".formatted(sId, iId);
	}
}
