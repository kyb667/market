package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
"ResultInfo":{
    "Count":10,
    "Total":78,
    "Start":1,
    "Latency":0.024,
    "Status":200,
    "Description":"Yahoo!\u30b0\u30eb\u30e1\u304c\u63d0\u4f9b\u3059\u308b\u5168\u56fd\u306e\u98f2\u98df\u5e97\u60c5\u5831",
    "Copyright":"<b>&copy; Yahoo Japan</b>"
}
*/

@Data
// @JsonIgnoreProperties(ignoreUnknown = true)
// @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class ResultInfo{
    // Status       必須です。リクエスト元に処理結果を伝えるためのコードです。正常終了の場合、200を出力します。エラー時は、下記エラー項目を参照してください。
    // Count        必須です。レスポンス情報に含まれるデータ件数です。
    // Total        出力されている住所情報以外も含めた全データ件数です。
    // Start        レスポンス情報に含まれるデータの、全データからの取得開始位置です。
    // Latency      レスポンス情報を生成するのに要した時間です。
    // Description  YDFデータ全体の説明です。
    // Copyright    データ提供元等のコピーライト表示です。
    @JsonProperty
    Integer Status;
    @JsonProperty
    Integer Count;
    @JsonProperty
    Integer Total;
    @JsonProperty
    Integer Start;
    @JsonProperty
    Double Latency;
    @JsonProperty
    String Description;
    @JsonProperty
    String Copyright;
}