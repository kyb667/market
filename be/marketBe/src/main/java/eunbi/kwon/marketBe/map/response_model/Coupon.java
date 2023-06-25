package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon{
    // Name	クーポン名	クーポンのタイトル文字列です。
    // Comment	クーポン内容	クーポンの詳細情報です。
    // Setting	クーポン設定	クーポンの利用期間を設定します。1（自動更新）または2（期間を指定）を指定します。
    // StartDay	クーポン開始日	YYYY-MM-DD形式で指定します。（例：2012-01-01）
    // EndDay	クーポン終了日	YYYY-MM-DD形式で指定します。（例：2012-03-31）
    // MobileFlag	クーポンモバイルフラグ	True（モバイルで表示）、False（モバイルで非表示）を指定します。
    // OtherMediaFlag	他媒体のクーポンプラグ	True（他の媒体で表示）、False（他の媒体で非表示）を指定します。
    // ParentPcUrl	クーポン一覧URL（PC)	クーポンが複数ある場合、複数クーポンの一覧ページのURL（PC向け）を指定します。
    // ParentSmartPhoneUrl	クーポン一覧URL（スマートフォン)	クーポンが複数ある場合、複数クーポンの一覧ページのURL（スマートフォン向け）を指定します。
    // ParentMobileUrl	クーポン一覧URL(モバイル)	クーポンが複数ある場合、複数クーポンの一覧ページのURL（モバイル向け）を指定します。

    @JsonProperty
    String Name;
    @JsonProperty
    String Comment;
    @JsonProperty
    String Setting;
    @JsonProperty
    String StartDay;
    @JsonProperty
    String EndDay;
    @JsonProperty
    String MobileFlag;
    @JsonProperty
    String OtherMediaFlag;
    @JsonProperty
    String ParentPcUrl;
    @JsonProperty
    String ParentSmartPhoneUrl;
    @JsonProperty
    String ParentMobileUrl;
}