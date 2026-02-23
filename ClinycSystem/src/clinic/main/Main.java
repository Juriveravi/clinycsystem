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
        patient.setFullName("Ana López");
        
        User doctor = new User();
        doctor.setFullName("Dr. Pérez");
        doctor.setUsername("doctor1");
        doctor.setRole(Role.DOCTOR); // si tienes ese valor en el enum

        DiagnosticOrder diagnostic = new DiagnosticOrder();
        diagnostic.setQuantity(1);
        diagnostic.setType(OrderItemType.DIAGNOSTIC); // necesitas el setter en OrderItem

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