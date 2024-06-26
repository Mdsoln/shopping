package onlineshopping.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CustomerOrderDetailsResponse {
    private String name;
    private String email;
    private String mobile;
    private String enrollNumber;
    private LocalDateTime accountCreatedDate;
    private int totalOrders;
    private List<OrderDetails> orders;
}
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrderDetailsResponse getCustomerOrderDetails(String enrollNumber) {
        Customer customer = userRepository.findByEnrollNumber(enrollNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Order> orders = orderRepository.findByCustomer(customer);

        CustomerOrderDetailsResponse response = new CustomerOrderDetailsResponse();
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setMobile(customer.getMobile());
        response.setEnrollNumber(customer.getEnrollNumber());
        response.setAccountCreatedDate(customer.getDate_created());
        response.setTotalOrders(orders.size());
        response.setOrders(orders.stream().map(order -> {
            CustomerOrderDetailsResponse.OrderDetails orderDetails = new CustomerOrderDetailsResponse.OrderDetails();
            orderDetails.setOrderNo(order.getOrderNo());
            orderDetails.setOrderCreatedDate(order.getDate_created());
            return orderDetails;
        }).collect(Collectors.toList()));

        return response;
    }
}

* */