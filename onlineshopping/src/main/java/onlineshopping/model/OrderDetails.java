package onlineshopping.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OrderDetails {
    private String orderNo;
    private LocalDateTime orderCreatedDate;
}
