package eunbi.kwon.marketBe.dummy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import eunbi.kwon.marketBe.map.response_model.ResultInfo;

import eunbi.kwon.marketBe.map.response_model.Feature;
import eunbi.kwon.marketBe.map.response_model.Geometry;


@RequiredArgsConstructor
@Service
@Transactional
public class DummyService {

    /** データがない場合のリターン
     * 
     * @return
     * @throws Exception
     */
    public Map<String, Object> NoData() throws Exception{

        Map<String, Object> ResultInfo = new HashMap<>();

        ResultInfo ResultInfoBody = this.SetResultInfoBody();

        ResultInfo.put("ResultInfo", ResultInfoBody);

        List<Map<String, Object>> FeatureBodyList = new ArrayList<Map<String, Object>>();

        ResultInfo.put("Feature", FeatureBodyList);

        return ResultInfo;
    }

    /** データがある場合のリターン
     * 
     * @return
     * @throws Exception
     */
    public Map<String, Object> ReturnData(Integer results, BigDecimal lat, BigDecimal lon, Map<String, Object> filters) throws Exception{

        Map<String, Object> ResultInfo = new HashMap<>();

        ResultInfo ResultInfoBody = this.SetResultInfoBody();

        ResultInfo.put("ResultInfo", ResultInfoBody);

        List<Feature> FeatureBodyList = new ArrayList<Feature>();
        
        for(Integer i = 0; i < results; i ++){

            if (filters.containsKey("creditcard") && i < 10){
                continue;
            }

            if (filters.containsKey("parking") && i >= 10 && i < 20){
                continue;
            }

            if (filters.containsKey("coupon") && i >= 20 && i < 30){
                continue;
            }

            if (filters.containsKey("reservation") && i >= 30 && i < 40){
                continue;
            }

            if (filters.containsKey("open") && i >= 40 && i < 50){
                continue;
            }

            if (filters.containsKey("min_price") && i >= 50 && i < 60){
                continue;
            }

            if (filters.containsKey("max_price") && i >= 60 && i < 70){
                continue;
            }

            if (filters.containsKey("smoking")){
                if (filters.get("smoking").equals("1") && i >= 70 && i < 80){
                    continue;
                }else if (filters.get("smoking").equals("2") && i >= 80 && i < 90){
                    continue;
                }else if (filters.get("smoking").equals("3") && i >= 90 && i < 100){
                    continue;
                }else if (filters.get("smoking").equals("1,2") && i >= 70 && i < 90){
                    continue;
                }else if (filters.get("smoking").equals("2,3") && i >= 80 && i < 100){
                    continue;
                }else if (filters.get("smoking").equals("1,2,3") && i >= 70 && i < 100){
                    continue;
                }
            }

            FeatureBodyList.add(this.SetFeatureBody(i, lat, lon));
        }

        ResultInfo.put("Feature", FeatureBodyList);

        return ResultInfo;
    }

    /** ResultInfoのリターン
     * 
     * @return
     * @throws Exception
     */
    public ResultInfo SetResultInfoBody() throws Exception {
        ResultInfo ResultInfoBody = new ResultInfo();

        ResultInfoBody.setStatus(0);
        ResultInfoBody.setCount(0);
        ResultInfoBody.setTotal(0);
        ResultInfoBody.setStart(0);
        ResultInfoBody.setLatency(0.0);
        ResultInfoBody.setDescription("");
        ResultInfoBody.setCopyright("");

        return ResultInfoBody;
    }

    /** Featureのリターン
     * 
     * @return
     * @throws Exception
     */
    public Feature SetFeatureBody(Integer IdNum, BigDecimal lat, BigDecimal lon) throws Exception {
        Feature FeatureBody = new Feature();

        FeatureBody.setName("test_" + IdNum.toString());
        FeatureBody.setGeometry(this.SetGeometry(IdNum, lat, lon));

        return FeatureBody;
    }

    public Geometry SetGeometry(Integer IdNum, BigDecimal lat, BigDecimal lon) throws Exception {
        Geometry GeometryBody = new Geometry();

        BigDecimal num = new BigDecimal(IdNum.toString());

        lat = lat.add(num);

        if (IdNum % 6 == 0){
            GeometryBody.setType("point");
            GeometryBody.setCoordinates(lat.toString() + "," + lon.toString());
        }else if (IdNum % 6 == 1){
            GeometryBody.setType("circle");
            GeometryBody.setCoordinates(lat.toString() + "," + lon.toString());
        }else if (IdNum % 6 == 2){
            GeometryBody.setType("ellipse");
            GeometryBody.setCoordinates(lat.toString() + "," + lon.toString());
        }else if (IdNum % 6 == 3){
            GeometryBody.setType("linestring");
            GeometryBody.setCoordinates("");
        }else if (IdNum % 6 == 4){
            GeometryBody.setType("polygon");
            GeometryBody.setCoordinates("");
        }else if (IdNum % 6 == 5){
            GeometryBody.setType("multigeometry");
            GeometryBody.setCoordinates("");
        }

        return GeometryBody;
    }

}
