package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Genre{
    // Name	ジャンル名	業種名を文字列で指定します。（例：駅、飲食店、公園）
    // Level	ジャンルレベル	業種が階層構造になっている場合はレベルを指定します。
    // Code	ジャンルコード	業種のコードを整数型で指定します。
    // Type	ジャンルタイプ	業種のタイプを指定します。（例：loco）
    @JsonProperty
    String Code;
    @JsonProperty
    String Name;
    @JsonProperty
    String Level;
    @JsonProperty
    String Type;
}
