package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Push{
    // Id	プッシュID	
    // Title	プッシュタイトル	プッシュ配信情報のタイトル文字列です。
    // Description	プッシュ本文	プッシュ配信情報の詳細ないようです。
    // Image[1-1000]	プッシュ画像	画像のパスを指定します。
    // ImageFlag	プッシュ画像有無	True（あり）または False（なし）または（Null）が入ります。
    // UpdateDate	プッシュ更新日付	YYYY-MM-DD形式で指定します。（例：2011-03-31）

    @JsonProperty
    String Id;
    @JsonProperty
    String Title;
    @JsonProperty
    String Description;
    @JsonProperty
    String Image1;
    @JsonProperty
    String ImageFlag;
    @JsonProperty
    String UpdateDate;
}