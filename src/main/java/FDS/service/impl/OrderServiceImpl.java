package FDS.service.impl;

import FDS.entity.Order;
import FDS.repository.OrderRepository;
import FDS.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void placeOrder(Order order) {

    }
}
