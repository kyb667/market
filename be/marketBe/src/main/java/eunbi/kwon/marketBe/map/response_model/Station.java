package eunbi.kwon.marketBe.map.response_model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import eunbi.kwon.marketBe.map.response_model.Geometry;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station{
    // Id	駅ID	
    // SubId	駅サブID	
    // Name	駅名	
    // StaitionHiragana	駅名読み（ひらがな）	
    // ExitId	駅出口ID	
    // Exit	駅出口	
    // ExitName	駅出口名称	
    // Railway	路線名	
    // Distance	距離	駅までの距離を指定します。
    // Time	時間（分）	駅までの時間（分）を指定します。
    // StationComment	駅備考	

    @JsonProperty
    String Id;
    @JsonProperty
    String SubId;
    @JsonProperty
    String Name;
    @JsonProperty
    String StaitionHiragana;
    @JsonProperty
    String ExitId;
    @JsonProperty
    String Exit;
    @JsonProperty
    String ExitName;
    @JsonProperty
    String Railway;
    @JsonProperty
    String Distance;
    @JsonProperty
    String Time;
    @JsonProperty
    String StationComment;
    // StationGeometry Geometry;
}