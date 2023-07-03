package eunbi.kwon.marketBe.map.request_model;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class SelectFilter {
    String creditcard;
    String parking;
    List<String> smoking;
    String coupon;
    String reservation;
    String open;
    Map<String, String> price;
}
