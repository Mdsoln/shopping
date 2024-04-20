package onlineshopping.repo;

import onlineshopping.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findByItemNo(String itemNo);

    @Query("SELECT DISTINCT i.itemName FROM Item i"
    )
    List<String> findAllItems();

    @Query("SELECT i FROM Item i " +
            "LEFT JOIN i.sizes s " +
            "LEFT JOIN i.colors c " +
            "ORDER BY i.itemName")
    List<Item> findAllItem();
}
