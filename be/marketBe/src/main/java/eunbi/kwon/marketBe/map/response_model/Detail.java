package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail{
//     BusinessHour	営業時間	文字列で指定します。（例：月火水金土　9：00～18：00、日・祝　9：00～12：00）
//     Fax[1-1000]	FAX番号	一つだけの場合、要素名は Fax1 となります。複数ある場合は、Fax2、Fax3・・・のように連番で続きます。
//     ZipCode	郵便番号	 
//     DisplayAddress	住所	文字列で指定します。
//     Payment	支払い方法	文字列による説明です。（例：クレジットカードOK、VISA、MASTER）
//     KaraokeFlag	カラオケがあるお店	True（あり）または False（なし）または（Null）が入ります。
    @JsonProperty
    String BusinessHour;
    @JsonProperty
    String Fax1;
    @JsonProperty
    String ZipCode;
    @JsonProperty
    String DisplayAddress;
    @JsonProperty
    String Payment;
    @JsonProperty
    String KaraokeFlag;
}