package clinic.services;

import clinic.model.orders.Order;
import clinic.model.orders.OrderItem;
import clinic.enums.OrderItemType;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderService {


    private List<Order> orders = new ArrayList<>();

    public void createOrder(Order order) {



        for (Order existingOrder : orders) {
            if (existingOrder.getOrderNumber() == order.getOrderNumber()) {
                throw new IllegalArgumentException("Ya existe una orden con ese número");
            }
        }


        if (order.getPatient() == null) {
            throw new IllegalArgumentException("La orden debe tener paciente");
        }


        if (order.getDoctor() == null) {
            throw new IllegalArgumentException("La orden debe tener médico");
        }


        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("La orden debe tener al menos un ítem");
        }

        boolean tieneDiagnostico = false;
        boolean tieneOtro = false;

        for (OrderItem item : order.getItems()) {

            if (item.getType() == OrderItemType.DIAGNOSTIC) {
                tieneDiagnostico = true;
            } else {
                tieneOtro = true;
            }
        }

        if (tieneDiagnostico && tieneOtro) {
            throw new IllegalArgumentException(
                    "No se puede mezclar diagnóstico con otros tipos de orden");
        }

        orders.add(order);

        System.out.println("Orden creada correctamente");
    }


    public List<Order> getOrders() {
        return orders;
    }
}