package onlineshopping.repo;

import onlineshopping.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

    @Query("SELECT SUM(oi.quantity) FROM OrderItem oi")
    int findTotalProduct();

}
