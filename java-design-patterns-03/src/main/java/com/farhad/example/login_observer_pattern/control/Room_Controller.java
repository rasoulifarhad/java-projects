package com.farhad.example.login_observer_pattern.control;

import java.time.Instant;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.farhad.example.login_observer_pattern.entity.SingletonDatabase;
import com.farhad.example.login_observer_pattern.reservation.ReservationStatus;
import com.farhad.example.login_observer_pattern.room.Room;

public class Room_Controller {

	private int roomNumber;
	private Room room;

	private List<Room> allRooms = SingletonDatabase.getInstance().getRooms();

	public Room_Controller() {
	}

	public Room_Controller(int roomNumber) {
		this.roomNumber = roomNumber;
		this.room = SingletonDatabase.getInstance().searchRooms(roomNumber);
	}

	public String displayAllRooms() {
		return allRooms.stream()
			.map(this::displayRoom)
			.collect(Collectors.joining("\n\n"));
	}

	public String displayOccupiedRooms() {
		return allRooms.stream()
				.filter(room -> room.getReservation().getStatus() == ReservationStatus.ACCEPTED)
				.map(this::displayRoom)
				.collect(Collectors.joining("\n\n"));
	}

	public String displayAvailableRooms() {
		return allRooms.stream()
				.filter(room -> room.getReservation().getStatus() == ReservationStatus.NEW)
				.map(this::displayRoom)
				.collect(Collectors.joining("\n\n"));
	}

	public String displayCancelledReservations() {
		return allRooms.stream()
				.filter(room -> room.getReservation().getStatus() == ReservationStatus.CANCELLED)
				.map(this::displayRoom)
				.collect(Collectors.joining("\n\n"));
	}

	private  String displayRoom(Room room) {
		StringJoiner stringJoiner = new StringJoiner("\n", "\n", "");
		stringJoiner
			.add("Room Number: " + room.getNumber())
			.add("Type: " + room.getRoomType())
			.add("Description" + room.getDescription())
			.add("Cost" + room.getCost());
		return stringJoiner.toString();
	}

	public void reserveRoom() {
		room.getReservation().accept();
		if (room.getReservation().getStatus() == ReservationStatus.NEW) {
			int i = (int) Math.random() * 100_000 + 1;
			JOptionPane.showMessageDialog(null,
					"Reserving room_: " + room.getNumber(),
					"Reservation Accepted",
					JOptionPane.INFORMATION_MESSAGE);
			room.getReservation().accept();
			room.getReservation().setPrice(room.getCost());
			room.getReservation().setName(Login_Controller.getUser().getUsername());
			room.getReservation().setId(1);
			room.getReservation().setDate(Instant.now());

			JOptionPane.showMessageDialog(null, "Reservation ID: "
					+ room.getReservation().getId() + "\nReservation Date: " + room	.getReservation().getDate()
					+ "\nName: " + room.getReservation().getName() + "\ncontrol.roomDecoratorPattern & Cost: "
					+ room.getNumber() + " "
					+ room.getReservation().getPrice(), "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void cancelReservation() {
		room.getReservation().cancel();
	}
}
