package eunbi.kwon.marketBe.map.response_model;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import eunbi.kwon.marketBe.map.response_model.Country;
import eunbi.kwon.marketBe.map.response_model.Genre;
import eunbi.kwon.marketBe.map.response_model.Geometry;
import eunbi.kwon.marketBe.map.response_model.Station;
import eunbi.kwon.marketBe.map.response_model.Push;
import eunbi.kwon.marketBe.map.response_model.Coupon;
import eunbi.kwon.marketBe.map.response_model.Detail;

/**
"Property":{
    "Address":"\u795e\u5948\u5ddd\u770c\u6a2a\u6d5c\u5e02\u9752\u8449\u533a\u85e4\u304c\u4e182\u4e01\u76ee1-1",
    "Accuracy":"detail2",
    "GovernmentCode":"14117",
    "Country":{"Code":"JP", "Name":"\u65e5\u672c"},
    "AddressElement":[
        {"Code":"14", "Name":"\u795e\u5948\u5ddd\u770c",
            "Kana":"\u304b\u306a\u304c\u308f\u3051\u3093", "Level":"prefecture"},
        {"Code":"14117", "Name":"\u6a2a\u6d5c\u5e02\u9752\u8449\u533a",
            "Kana":"\u3088\u3053\u306f\u307e\u3057\u3042\u304a\u3070\u304f", "Level":"city"},
        {"Code":"", "Name":"\u85e4\u304c\u4e18",
            "Kana":"\u3075\u3058\u304c\u304a\u304b", "Level":"oaza"},
        {"Code":"", "Name":"2\u4e01\u76ee",
            "Kana":"2\u3061\u3087\u3046\u3081", "Level":"aza"},
        {"Code":"", "Name":"1", "Kana":"1", "Level":"detail1"},
        {"Code":"", "Name":"1", "Kana":"1", "Level":"detail2"}
    ]
}

 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Property{
    /**
        Uid	ユニークID	拠点に紐づくユニークなIDです。
        Yomi	名前の読み	拠点名称の読み方（カタカナ）です。
        Country	国データ	詳細は、「国データの出力について」を参照してください。
        Address	住所	住所文字列です。
        AddressElement	住所構造データ	詳細は、「住所構造データの出力について」を参照してください。
        Genre	ジャンルデータ	詳細は、「ジャンルデータの出力について」を参照してください。
        Station	駅データ	詳細は、「駅データの出力について」を参照してください。
        Tel[1-1000]	電話番号	一つだけの場合、要素名は Tel1 となります。複数ある場合は、Tel2、Tel3・・・のように連番で続きます。
        CatchCopy	キャッチコピー	拠点の説明を短い文字列で説明します。
        Price	値段	拠点に紐づく代表的な値段です。宿泊料金やメニュー料金などを整数型で指定します。
        AveragePriceComment	平均予算	拠点に紐づく平均予算です。（例：10,000円）
        LeadImage	代表画像	拠点の代表画像です。
        CreditcardFlag	クレジットカード利用可否	拠点（お店など）での支払時にクレジットカードが使えるかどうかをTrue（可）、False（不可）で指定します。
        ParkingFlag	駐車場の有無	拠点（お店など）に駐車場が併設されているかどうかをTrue（有）、False（無）で指定します。
        StampFlag	スタンプの有無	拠点（お店など）がYahoo!ロコ プレイスのスタンプに対応しているかどうかをTrue（有）、False（無）で指定します。
        CouponFlag	クーポンの有無	拠点（お店など）のクーポン有無をTrue（有）、False（無）で指定します。
        Coupon	クーポンデータ	詳細は、「クーポンデータの出力について」を参照してください。
        Push	プッシュデータ	詳細は、「プッシュデータの出力について」を参照してください。
        Ppc	コール課金用電話番号	コール課金用の電話番号です。
        PpcDescription	コール課金用電話番号補足説明	コール課金用の電話番号の説明文字列です。
        GovernmentCode	行政コード	最も詳細なレベルの行政コードです。部分住所レベルごとの行政コードは、AddressElementを利用します。
        Access[1-1000]	アクセス方法	文字列による説明です。（例：本庄駅北口から徒歩15分　本庄東高校そば）
        Rating	評価	5点満点評価です。（例：3.3）
        ReviewCount	投稿数	評価（Rating）の基となるデータ件数です。
        PublishStart	掲載開始日	YYYY-MM-DD形式で指定します。（例：2010-01-01）
        PublishEnd	掲載終了日	YYYY-MM-DD形式で指定します。（例：2010-01-11）
        EventStart	イベント開始日	YYYY-MM-DD形式で指定します。（例：2010-01-09）
        EventEnd	イベント終了日	YYYY-MM-DD形式で指定します。（例：2010-01-11）
        BusinessOpen	営業開始時間	24H:mm形式で指定します。（例：10:30）
        BusinessClose	営業終了時間	24H:mm形式で指定します。（例：21:00）
        MondayBusinessHour	月曜日の営業時間	月曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        TuesdayBusinessHour	火曜日の営業時間	火曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        WednesdayBusinessHour	水曜日の営業時間	水曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        ThursdayBusinessHour	木曜日の営業時間	木曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        FridayBusinessHour	金曜日の営業時間	金曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        SaturdayBusinessHour	土曜日の営業時間	土曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        SundayBusinessHour	日曜日の営業時間	日曜日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        HolidayBusinessHour	祝日の営業時間	祝日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        DayBeforeHolidayBusinessHour	祝前日の営業時間	祝前日の開店時間/閉店時間です。hh:mm/hh:mm、hh:mm/hh:mm,hh:mm/hh:mm形式で指定します。（例：10:00/18:00）
        Holiday	休日	文字列で指定します。（例：木曜定休日）
        CreateDate	作成日時	YYYY-MM-DD 24H:mm形式で指定します。（例：2009-12-11 14:30）
        UpdateDate	更新日時	YYYY-MM-DD 24H:mm形式で指定します。（例：2010-02-11 18:43）
        CassetteId	カセットID	カセットのIDです。
        CassetteOwner	カセットオーナー	カセットの提供者名です。
        CassetteHeader	カセットヘッダー	カセットのヘッダー情報です。
        CassetteFooter	カセットフッター	カセットのフッター情報です。
        CassetteOwnerUrl	カセットオーナーURL　	カセット提供者のページURLです。
        AdultFlag	アダルトフラグ	アダルト情報の有無をTrue（有）、False（無）で指定します。
        LandmarkCode	ランドマークコード	拠点のランドマークコードです。
        StorageUrl	詳細なデータがある位置のURL	 
        Detail	拠点詳細データ	詳細は、「拠点詳細データの出力について」を参照してください。
     */
    
    @JsonProperty
    String Uid;
    @JsonProperty
    String Yomi;
    @JsonProperty
    Country Country;
    @JsonProperty
    String Address;
    // AddressElement
    // @JsonProperty
    // Geometry Geometry;
    @JsonProperty
    List<Genre> Genre;
    @JsonProperty
    List<Station> Station;
    @JsonProperty
    String Tel1;
    @JsonProperty
    String Tel2;
    @JsonProperty
    String CatchCopy;
    @JsonProperty
    String Price;
    @JsonProperty
    String AveragePriceComment;
    @JsonProperty
    String LeadImage;
    @JsonProperty
    String CreditcardFlag;
    @JsonProperty
    String ParkingFlag;
    @JsonProperty
    String StampFlag;
    @JsonProperty
    String CouponFlag;
    @JsonProperty
    Coupon Coupon;
    @JsonProperty
    Push Push;
    @JsonProperty
    String Ppc;
    @JsonProperty
    String PpcDescription;
    @JsonProperty
    String GovernmentCode;
    // Access[1-1000]
    @JsonProperty
    String Access1;
    @JsonProperty
    String Access2;
    @JsonProperty
    String Access3;
    @JsonProperty
    String Rating;
    @JsonProperty
    String ReviewCount;
    @JsonProperty
    String PublishStart;
    @JsonProperty
    String PublishEnd;
    @JsonProperty
    String EventStart;
    @JsonProperty
    String EventEnd;
    @JsonProperty
    String BusinessOpen;
    @JsonProperty
    String BusinessClose;
    @JsonProperty
    String MondayBusinessHour;
    @JsonProperty
    String TuesdayBusinessHour;
    @JsonProperty
    String WednesdayBusinessHour;
    @JsonProperty
    String ThursdayBusinessHour;
    @JsonProperty
    String FridayBusinessHour;
    @JsonProperty
    String SaturdayBusinessHour;
    @JsonProperty
    String SundayBusinessHour;
    @JsonProperty
    String HolidayBusinessHour;
    @JsonProperty
    String DayBeforeHolidayBusinessHour;
    @JsonProperty
    String Holiday;
    @JsonProperty
    String CreateDate;
    @JsonProperty
    String UpdateDate;
    @JsonProperty
    String CassetteId;
    @JsonProperty
    String CassetteOwner;
    @JsonProperty
    String CassetteHeader;
    @JsonProperty
    String CassetteFooter;
    @JsonProperty
    String CassetteOwnerUrl;
    @JsonProperty
    String AdultFlag;
    @JsonProperty
    String LandmarkCode;
    @JsonProperty
    String StorageUrl;
    @JsonProperty
    Detail Detail;
}