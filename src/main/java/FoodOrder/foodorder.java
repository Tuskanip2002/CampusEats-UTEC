package FoodOrder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class foodorder {
    id: Long
    customerld: Long
    productld: Long
    quantity: Integer
    totalAmount: BigDecimal
    createdAt: ZonedDateTime
    status: String

}
