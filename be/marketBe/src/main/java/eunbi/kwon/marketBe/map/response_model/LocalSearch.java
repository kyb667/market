package eunbi.kwon.marketBe.map.response_model;

import lombok.Data;

import eunbi.kwon.marketBe.map.response_model.ResultInfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import eunbi.kwon.marketBe.map.response_model.Feature;

@Data
// @JsonIgnoreProperties(ignoreUnknown = true)
public class LocalSearch {
    // ResultInfo   レスポンスのまとめ情報です。
    // Feature      検索結果1件分のデータ群です。
    // Dictionary   
    @JsonProperty
    ResultInfo ResultInfo;
    @JsonProperty
    List<Feature> Feature;
    // List<Dictionary> Dictionary;                 TODO 要らない
}