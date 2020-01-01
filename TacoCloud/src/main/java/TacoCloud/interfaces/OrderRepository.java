package TacoCloud.interfaces;

import TacoCloud.Pojo.Order;

public interface OrderRepository {
    Order save (Order order);
}
