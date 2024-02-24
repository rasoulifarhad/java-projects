package com.farhad.example.design_principles02.parking_lot;

import com.farhad.example.design_principles02.parking_lot.parking.EntrancePannel;
import com.farhad.example.design_principles02.parking_lot.parking.ExitPannel;
import com.farhad.example.design_principles02.parking_lot.parking.ParkingFloor;
import com.farhad.example.design_principles02.parking_lot.parking.ParkingLot;
import com.farhad.example.design_principles02.parking_lot.parkingspot.CompactSpot;
import com.farhad.example.design_principles02.parking_lot.parkingspot.MotorbikeSpot;

// ## Set of requirements while designing the parking lot:
// 
// - The parking lot should have multiple floors where customers can park their cars.
// 
// - The parking lot should have multiple entry and exit points.
// 
// - Customers can collect a parking ticket from the entry points and can pay the parking fee at 
//   the exit points on their way out.
// 
// - Customers can pay the tickets at the automated exit panel or to the parking attendant.
// 
// - Customers can pay via both cash and credit cards.
// 
// - Customers should also be able to pay the parking fee at the customer'sinfo portal on each 
//   floor.If the customer has paid at the info portal,they don'thave to pay at the exit.
// 
// - The system should not allow more vehicles than the maximum capacity of the parking lot.If the 
//   parking is full,the system should be able to show a message at the entrance panel and on the 
//   parking display board on the ground floor.
// 
// - Each parking floor will have many parking spots.The system should support multiple types of 
//   parking spots such as Compact,Large,Handicapped,Motorcycle,etc.
// 
// - The Parking lot should have some parking spots specified for electric cars.These spots should 
//   have an electric panel through which customers can pay and charge their vehicles.
// 
// - The system should support parking for different types of vehicles like car,truck,van,motorcycle,etc.
// 
// - Each parking floor should have a display board showing any free parking spot for each spot type.
// 
// - The system should support a per-hour parking fee model.For example,customers have to pay $4 for the 
//   first hour,$3.5for the second and third hours,and $2.5for all the remaining hours.
//
// ## Main actor:
//
// - Admin
//   - Add parking floor
//   - Add parking display board
//   - Add parking spot
//   - Add electriv panel
//   - Add parking attendent
//   - Add/Modify parking rate
//   - Add enterance/exit panel
//   - Login/Logout
//   - View account
//   - Update accounbt
// - Customer
//   - Take ticket
//   - Scan ticket
//   - Pay ticket
//   - Credit card payment
// - Parking attendant
//   - Login/Logout
//   - View account
//   - Update accounbt
//   - Cash payment
// - System
//   - Assign a parking slot to a vehicle
//   - Remove a vehicle from a parking slot
//   - Show parking  full message
// 	 - Show available parking spot message
// 	
// ## Top use cases:
//
// - Add/Remove/Edit parking floor
// - Add/Remove/Edit parking spots 
// - Add/Remove parking attendant
// - Take ticket
// - Scan ticket
// - Credit card payment
// - Cash payment
// - Add/Modify parking rate
// 
// ## Objects
//
// - ParkingLot
// - ParkingFloor
// - ParkingSpot
//   different parking spot:
//
//    - Handicapped
//    - Compact
//    - Large
//    - Motorcycle
//    - Electric 
//   
// - Account
// 
//    - One for admin
//    - Other for parking attendant 
// 
// - ParkingTicket
// - Vehicle
// 
//   - CAr
//   - Trunk
//   - Electric
//   - Van
//   - Motorcycle
// 
// - EntrancePanel and ExitPanel
// - Payment
// - Parking rate
// - ParkingDisplayBoard
// - ParkingAttendantPortal
// - CustomerInfoPortal
// - ElectricPanel
//
// ## Activity
//
// - Customer paying for parking ticket
// 
//   1. Customer inserts the parking ticket	in the exit pannel
//   2. System scans the parking ticket and fetches ticket's details
//   3. if ticket not paid ?
//      3.1 system calculates the total parking fee
//      3.2 System shows the total parking 	fee on the display panel and ask for credit card details
//      3.3 Customer inserts the credit card in card reader
//      3.4 System reads the credit card details and processes the payment.
//      3.5 If paymet sucessfull?: 
//          3.5.1 System shows success message
//          3.5.2 System ask print receipt? 
//          3.5.3 System send signal to open the parking gate
//          3.5.4 END
//      3.6 If paymet faild?: 
//          3.6.1 System shows the error
//          3.6.2 System ask for try again?
//          3.6.3 if no End
//          3.6.4 If yes go to 3.3
//      3.4 System reads the credit card details and processes the payment.
//   4. if ticket paid?
//      4.1 System send signal to open the parking gate
//      4.2 END

public class App {

	public static void main(String[] args) {
		Location location = new Location("atreet", "city", "state", "country", "123456");

		ParkingLot parkingLot = new ParkingLot("myParkingLot", location);

		Person adminPerson = new Person("person 01", location, "person01@example.com", "09121111111");
		Admin admin = new Admin("admin1", "admin1", adminPerson, AccountStatus.Active);

		ParkingFloor parkingFloor1 = new ParkingFloor("1");
		admin.addParkingFloor(parkingLot, parkingFloor1);
		ParkingFloor parkingFloor2 = new ParkingFloor("1");
		admin.addParkingFloor(parkingLot, parkingFloor2);

		EntrancePannel entrancePannel = new EntrancePannel("1");
		admin.addEntrancePanel(parkingLot, entrancePannel);

		ExitPannel exitPannel = new ExitPannel("1");
		admin.addExitPanel(parkingLot, exitPannel);

		CompactSpot compactSpot1 = new CompactSpot("c1");
		admin.addParkingSpot(parkingLot, parkingFloor1.getFloorId(), compactSpot1);

		CompactSpot compactSpot2 = new CompactSpot("c2");
		admin.addParkingSpot(parkingLot, parkingFloor1.getFloorId(), compactSpot2);

		MotorbikeSpot motorbikeSpot01 = new MotorbikeSpot("b1");
		admin.addParkingSpot(parkingLot, parkingFloor1.getFloorId(), motorbikeSpot01);
	}
}
