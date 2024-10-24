package org.acumen.training.codes.model.compositekeys;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClassroomId implements Serializable{
	private static final long serialVersionUID = 1L;
	private String building;
	private String roomNumber;
	
	@Column(name = "building", unique = true, length = 15)
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	@Column(name = "room_number", unique = true, length = 7)
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String room_number) {
		this.roomNumber = room_number;
	}
	
	
}
