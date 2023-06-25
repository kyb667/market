package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country{
    // 　　　　Code	国コード（国際標準化機構（ISO） 3166-1）です。
    
    @JsonProperty
    String Code;
    // 　　　　Name	国名です。
    @JsonProperty
    String Name;
}