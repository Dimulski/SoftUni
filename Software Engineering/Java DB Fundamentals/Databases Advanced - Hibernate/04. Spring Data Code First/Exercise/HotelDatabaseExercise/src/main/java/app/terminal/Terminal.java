package app.terminal;

import app.domain.*;
import app.service.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BedTypeService bedTypeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OccupancyService occupancyService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomStatusService roomStatusService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Override
    public void run(String... strings) throws Exception {

        BedType bedType = new BedType();
        bedType.setBedType("Double");
        bedType.setNotes("Very heavy, should not be moved.");
        Customer customer = new Customer();
        customer.setAccountNumber(1);
        customer.setFirstName("Pesho");
        customer.setLastName("Peshev");
        customer.setPhoneNumber("(387) 670-6390");
        customer.setEmergencyName("Batman");
        customer.setEmergencyNumber("228744625");
        Employee employee = new Employee();
        employee.setFirstName("Ivan");
        employee.setLastName("Ivanov");
        employee.setTitle("Receptionist");
        Occupancy occupancy = new Occupancy();
        occupancy.setDateOccupied(new Date());
        occupancy.setAccountNumber(1);
        occupancy.setRoomNumber(1);
        occupancy.setRateApplied(150);
        occupancy.setPhoneCharge(3.20);
        Payment payment = new Payment();
        payment.setPaymentDate(new Date());
        payment.setAccountNumber(1);
        payment.setFirstDateOccupied(new Date());
        payment.setLastDateOccupied(new Date());
        payment.setTotalDays(1);
        payment.setAmountCharged(100);
        RoomType roomType = new RoomType();
        roomType.setRoomType("Suite");
        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setRoomStatus("Occupied");
        Room room = new Room();
        room.setRoomNumber(1);
        room.setRoomType(roomType);
        room.setBedType(bedType);
        room.setRate(100);
        room.setRoomStatus(roomStatus);

        this.bedTypeService.create(bedType);
        this.customerService.create(customer);
        this.employeeService.create(employee);
        this.occupancyService.create(occupancy);
        this.paymentService.create(payment);
        this.roomTypeService.create(roomType);
        this.roomStatusService.create(roomStatus);
        this.roomService.create(room);
    }
}
