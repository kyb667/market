package eunbi.kwon.marketBe.map.request_model;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class FilterData {
    List<String> selectFilter;
    Map<String, Double> center;
}
