package eunbi.kwon.marketBe.map.response_model;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import eunbi.kwon.marketBe.map.response_model.Geometry;
import eunbi.kwon.marketBe.map.response_model.Property;

/**
"Feature":[
    {
        "Id":"c9663446e499890051040b9c7cfbaf29",
        "Name":"\u6771\u4eac\u30df\u30c3\u30c9\u30bf\u30a6\u30f3",
        "Category":"\u5546\u696d\u65bd\u8a2d",
        "Geometry":{
            "Type":"point",
            "Coordinates":"139.7308854869,35.665615661963"
        },
        "Property":{
            "Address":"\u6771\u4eac\u90fd\u6e2f\u533a\u8d64\u57429-7-1\u4ed6",
            "Tel1":"03-0000-0000"
        }
    }
]
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature{
    // 子要素名         説明	                                                    簡易	標準	詳細
    // Id           要素を特定するための識別子                                          ○       ○       ○
    // Gid          複数のカセット間で共有する店舗識別子（店舗を扱わない場合はなし）        △       △       △
    // Name         拠点名称                                                            ○	○	○
    // Category     カテゴリ（複数指定可能）                                            ×	○	○
    // Description  拠点の説明（HTML指定可能）                                          ×	○	○
    // Geometry     拠点の場所を表すGeometry要素                                        ○	○	○
    // Property     拠点の各種データを表すProperty要素                                  ×	△	○
    // Style        拠点の表示スタイルを表すStyle要素                                   ×	○	○
    // RouteInfo    経路の情報を表すRouteInfo要素                                       ×	○	○
    @JsonProperty
    String Id;

    @JsonProperty
    String Gid;

    @JsonProperty
    String Name;

    @JsonProperty
    List<String> Category;

    @JsonProperty
    String Description;
    @JsonProperty
    Geometry Geometry;
    @JsonProperty
    Property Property;
    // Style;
    // RouteInfo
}