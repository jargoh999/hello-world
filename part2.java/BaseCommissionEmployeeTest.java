import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseCommissionEmployeeTest {
    @Test
    void calculateDeliveryInRange_0_to_49() {
        assertEquals(BaseCommissionEmployee.calculateDelivery(5),5800);
    }
    @Test
    void calculateDeliveryInRange_50_to_59(){
        assertEquals(BaseCommissionEmployee.calculateDelivery(51),15200);
    }
    @Test
    void calculateDeliveryInRange_60_to_69(){
        assertEquals(BaseCommissionEmployee.calculateDelivery(61),20250);
    }
    @Test
    void calculateDeliveryInRange_70_to_79(){
        assertEquals(BaseCommissionEmployee.calculateDelivery(71),40500);
    }
    @Test
    void calculateDeliveryInRange_0__throwsException(){
        assertThrows(IllegalArgumentException.class,()->BaseCommissionEmployee.calculateDelivery(-1));
    }
}

