package com.start.spring.aula141124.Controller;

import com.start.spring.aula141124.Entities.Customer;
import com.start.spring.aula141124.Entities.Order;
import com.start.spring.aula141124.Entities.Product;
import com.start.spring.aula141124.Repository.CustomerRepository;
import com.start.spring.aula141124.Repository.OrderRepository;
import com.start.spring.aula141124.Repository.ProductRepository;
import com.start.spring.aula141124.Services.OrderTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderTotalService orderTotalService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // ... (métodos para Order e Product)

    // Criar um novo pedido para um cliente
    @PostMapping("/customers/{customerId}/orders")
    public ResponseEntity<Order> createOrderForCustomer(@PathVariable Long customerId, @RequestBody Order order) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setId(null); // Garante que um novo ID seja gerado

        // Calcula o total do pedido usando o serviço
        double total = orderTotalService.calculateOrderTotal(order);
        order.setTotal(total);

        order = orderRepository.save(order);
        customer.getOrderList().add(order);
        customerRepository.save(customer);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // Adicionar um produto a um pedido existente
    @PostMapping("/orders/{orderId}/products")
    public ResponseEntity<Order> addProductToOrder(@PathVariable Long orderId, @RequestBody Product product) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        product.setId(0); // Garante que um novo ID seja gerado para o produto
        product = productRepository.save(product);
        order.getProductList().add(product);
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}