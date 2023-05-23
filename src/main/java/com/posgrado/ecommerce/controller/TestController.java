package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.OrderItemDto;
import com.posgrado.ecommerce.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/total")
public class TestController {

  private OrderRepository orderRepository;

  @GetMapping("/{orderId}")
  public String getTotalPrice(@PathVariable UUID orderId) {
    double totalPriceSQL = orderRepository.getTotalPriceByOrderId(orderId.toString());
    double totalPriceJPQL = orderRepository.getTotalPrice(orderId);
    return "Total price SQL: " + totalPriceSQL + " Total price JPQL: " + totalPriceJPQL;
  }

  @GetMapping("/items/{orderId}")
  public List<OrderItemDto> getListItems(@PathVariable UUID orderId) {
    List<OrderItemDto> items = orderRepository.getItemsWithTotalPrice(orderId);
    return items;
  }
}
