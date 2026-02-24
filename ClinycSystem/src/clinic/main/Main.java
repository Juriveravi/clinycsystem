package clinic.main;

import clinic.model.orders.*;
import clinic.model.people.*;
import clinic.enums.*;
import clinic.services.CreateOrderService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CreateOrderService service = new CreateOrderService();

      
        Patient patient = new Patient();
        patient.setIdNumber("123");
        patient.setFullName("Susana Pérez");
        
        User doctor = new User();
        doctor.setFullName("Dr. Gonzalo");
        doctor.setUsername("doctor1");
        doctor.setRole(Role.DOCTOR); 

        DiagnosticOrder diagnostic = new DiagnosticOrder();
        diagnostic.setQuantity(1);
        diagnostic.setType(OrderItemType.DIAGNOSTIC); 

        Order order = new Order();
        order.setOrderNumber(1);
        order.setPatient(patient);
        order.setDoctor(doctor);
        order.setItems(new ArrayList<>());

        order.getItems().add(diagnostic);

       
        service.createOrder(order);

        
        System.out.println("Cantidad de órdenes creadas: " + service.getOrders().size());
    }
}