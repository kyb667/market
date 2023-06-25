package eunbi.kwon.marketBe.map.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.databind.ObjectMapper;

import eunbi.kwon.marketBe.common.Config;
import eunbi.kwon.marketBe.map.request_model.ReqLocalSearch;

import eunbi.kwon.marketBe.map.response_model.Feature;
import eunbi.kwon.marketBe.map.response_model.LocalSearch;
import eunbi.kwon.marketBe.map.response_model.Geometry;
import eunbi.kwon.marketBe.util.RequestApi;

@RequiredArgsConstructor
@Service
@Transactional
public class MapService {

    @Autowired
    private RequestApi requestApi;

    @Value("${yahooapis.appid}")
    private String appid;

    @Value("${yahooapis.localSearch.url}")
    private String localSearchUrl;

    @Value("${yahooapis.localSearch.contentType}")
    private String contentType;

    @Value("${yahooapis.localSearch.param.dist}")
    private String paramDist;

    @Value("${yahooapis.localSearch.param.results}")
    private String paramResults;

    @Value("${yahooapis.localSearch.param.output}")
    private String paramOutput;

    final String LogName = "Service";

    /**
     * 
     * @param logger
     * @param filterData
     * @return
     * @throws Exception
     */
    public Integer checkValid(Logger logger, String ParentLogName, ReqLocalSearch filterData) throws Exception {

        // map-LocalSearch
        String LogFuncName = ParentLogName + "-" + LogName + "-checkValid";

        logger.log(Level.INFO, LogFuncName + " start");

        Integer check = Config.STATE_NG;

        if (filterData.getFilterData() == null){
            logger.log(Level.WARNING, LogFuncName+ " | " + " no FilterData");
            return check;
        }

        if (filterData.getFilterData().getCenter() == null){
            logger.log(Level.WARNING, LogFuncName+ " | " + " no Center");
            return check;
        }

        if (filterData.getFilterData().getSelectFilter() == null){
            logger.log(Level.WARNING, LogFuncName+ " | " + " no SelectFilter");
            return check;
        }

        check = Config.STATE_OK;

        logger.log(Level.INFO, LogFuncName + " end");

        return check;
    };

    /**
     * 
     * @param logger
     * @param filterData
     * @return
     * @throws Exception
     */
    public Map<String, Object> LocalSearch(Logger logger, String ParentLogName,  ReqLocalSearch filterData) throws Exception {
        
        // map-LocalSearch
        String LogFuncName = ParentLogName + "-" + LogName + "-LocalSearch";

        logger.log(Level.INFO, LogFuncName + " start");

        Map<String, Object> response = new HashMap<>();

        List<Map<String, Double>> locations = new ArrayList<Map<String, Double>>();

        // Make LocalSearch Url
        String url = this.makeUrl(logger, LogFuncName, filterData);

        // Make LocalSearch Headers
        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", contentType);

        // LocalSearch Request
        String res_body = requestApi.sendGetRequest(logger, LogFuncName, LogName, url, headers);

        LocalSearch result = null;

        // 成功？
        if (!(res_body == null)) {

            ObjectMapper objmapper = new ObjectMapper();

            result = objmapper.readValue(res_body, LocalSearch.class);
        }

        logger.log(Level.FINER, LogFuncName+ " | " + "result : " + result.toString());

        if (result.getFeature() == null){
            // TODO
        }else{
            for (Feature i : result.getFeature()){
                logger.log(Level.FINER, LogFuncName+ " | " + "result : " + i.toString());

                Geometry Geometry = i.getGeometry();

                if (Geometry == null){
                    continue;
                }
                else{
                    if (Geometry.getType().contains("point") || Geometry.getType().contains("circle") || Geometry.getType().contains("ellipse")){
                        // 경도, 위도
                        String[] arrOfStr = Geometry.getCoordinates().split(",", 2);

                        double[] results = Arrays.asList(arrOfStr).stream().mapToDouble(Double::parseDouble).toArray();

                        Map<String, Double> map = new HashMap<>();

                        map.put("lng", results[0]);
                        map.put("lat", results[1]);

                        locations.add(map);
                    }

                    logger.log(Level.INFO, LogFuncName+ " | " + "Geometry : " + Geometry.toString());
                }
            }
        }

        response.put("locations", locations);

        logger.log(Level.INFO, LogFuncName+ " | " + "response : " + response.toString());
        logger.log(Level.INFO, LogFuncName + " end");

        return response;
    }

    /** LocalSearch 用 URL 作成
     * 
     * @param filterData
     * @return
     * @throws Exception
     */
    public String makeUrl(Logger logger, String ParentLogName, ReqLocalSearch filterData) throws Exception{

        String LogFuncName = ParentLogName + "-" + LogName + "-makeUrl";

        logger.log(Level.INFO, LogFuncName + " start");

        String url = localSearchUrl;

        // appid（必須）    string  Client ID（アプリケーションID）。
        url += "?appid=" + appid;

        // device	string	APIの結果をモバイル端末に掲載する場合は「mobile」を指定してください。モバイル端末で掲載できない情報が非表示になります。

        // query	string	（UTF-8でエンコードされた）検索クエリーです。検索対象は、地域・拠点情報名称および業種（カセットによってはない場合があります）です。

        // cid      string      カセットIDです。カセットIDを用いて店舗データを検索できます。
        //                                     コンマ「,」区切りで複数指定が可能です。
        //                                     電話帳のcidは「d8a23e9e64a4c817227ab09858bc1330」です。
        //                                     指定しない場合は、公開されているカセット全体が検索対象です。

        // uid	string	ユニークIDです。
        // コンマ「,」区切りで複数指定できます。

        // gid	string	名寄せされた店舗IDです。
        // コンマ「,」区切りで複数指定が可能です。

        // id	string	カセット内で設定されたIDです。
        // コンマ「,」区切りで複数指定が可能です。
        // ※カセットID（cid）と併せてご利用ください。

        // bid	string	ビルIDです。
        // コンマ「,」区切りで複数指定が可能です。
        // ※ビルIDは変更になる場合があります。

        // group	string	gidを指定すると名寄せされた同一店舗をまとめて表示します。
        // ※名寄せされた店舗の中でsortで指定した並び順の上位一件のみ表示されます。
        // ※すべての店舗が必要な場合はdistinct=falseを指定してください。

        // distinct	boolean	group=gid時に重複レコードの表示を指定します。
        // デフォルトはtrueです。
        // 名寄せされた店舗すべてが必要な場合にfalseをセットしてください。
        // ※false の場合、リクエストパラメータのresultsは店舗のユニークの件数となるため、リクエストパラメータのresultsとレスポンスの<Count>の件数が異なります。

        // sort	string
        // デフォルトは昇順で、先頭に"-"（半角マイナス）を付けることで降順になります。
        // ex) sort=-review で口コミ件数の多い順にソート
        //      rating（デフォルト）
        //          ratingは、星の数順にソートします。
        //      score
        //          scoreは、スコア順にソートします。
        //      hybrid
        //          hybridは、口コミ件数や星の数などを重み付けした値の順にソートします。
        //      review
        //          reviewは、口コミ件数にソートします。
        //      kana
        //          kanaは、アイウエオ順にソートします。
        //      price
        //          priceは、金額順にソートします。
        //      dist
        //          distは、2点間の直線距離順にソートします。（geoより高速です）
        //      geo
        //          geoは、球面三角法による2点間の距離順にソートします。 ※距離順（dist/geo）を有効にするためには、lat,lonを指定してください。
        //      match	ソートの方法を指定します:
        //          matchは、適合度順にソートします。

        // start	int	取得開始位置を指定します（最大3000）。

        // results	int	取得件数を指定します（最大100）。
        url += "&results=" + paramResults;

        // detail	string
        //      simple,
        //      standard（デフォルト）,
        //      full	出力項目数を増減できます。詳細はこちらをご覧ください。

        // output	string
        //      xml（デフォルト）,
        //      json
        //      出力形式を指定します：
        //      xml - XML形式
        //      json - JSON形式
        url += "&output=" + paramOutput;

        // callback	string	JSONPとして出力する際のコールバック関数名を入力するためのパラメータ。UTF-8でエンコードした文字列を入力します。

        // lat	float	中心の緯度。
        url += "&lat=" + filterData.getFilterData().getCenter().get("lat").toString();

        // lon	float	中心の経度。
        url += "&lon=" + filterData.getFilterData().getCenter().get("lng").toString();

        // dist	float	検索距離（km）です。
        //      最大20km、小数点も指定できます。
        //      中心の緯度、中心の経度のパラメータが必須です。
        url += "&dist=" + paramDist;

        // bbox	string	矩形範囲の左下経度、左下緯度、右上経度、右上緯度を世界測地系十進形式で指定（コンマ区切り）。
        
        // ac	string	住所コード（日本工業規格（JIS） X 0401）または国コード（国際標準化機構（ISO） 3166-1 alpha-2）です。
        //      住所コードは都道府県（2けた）と市町村（5けた）を指定可能です。
        //      ex) 北海道:01, 札幌市中央区:01101
        //      国コードは、2文字を指定してください。
        //      ex) 日本:JP、アメリカ：US

        // gc	string	業種コードを指定します。YOLP業種コードをご覧ください。

        // coupon	boolean	trueを指定すると、クーポンが利用できる店舗データを対象に検索します。falseは無効です。
        //      ※モバイル向けサイトでは掲載不可なクーポンがあります。APIの結果をモバイル端末に掲載する場合は、リクエストパラメータ「device」をセットし「mobile」を指定してください。モバイル端末で掲載不可なクーポンが非表示になります。
        //      ※クーポンの利用についてはクーポン提供元サイトの利用条件（画面を印刷して提示など）に準じます。
        if (filterData.getFilterData().getSelectFilter().contains("coupon")){
            url += "&coupon=true";
        }
        
        // parking	boolean	trueを指定すると、駐車場がある店舗データを対象に検索します。falseは無効です
        if (filterData.getFilterData().getSelectFilter().contains("parking")){
            url += "&parking=true";
        }
        
        // creditcard	boolean	trueを指定すると、クレジットカードが利用できる店舗データを対象に検索します。falseは無効です。
        if (filterData.getFilterData().getSelectFilter().contains("creditcard")){
            url += "&creditcard=true";
        }

        // smoking	string	喫煙の可否を指定して検索ができます。
        //      コンマ「,」区切りで複数指定できます。
        //      1 - 禁煙
        //      2 - 分煙
        //      3 - 喫煙可
        if (filterData.getFilterData().getSelectFilter().contains("smoking")){
            url += "&smoking=1,2,3";
        }

        // reservation	string	1を指定すると、予約ができる店舗データを対象に検索します。
        if (filterData.getFilterData().getSelectFilter().contains("reservation")){
            url += "&reservation=1";
        }

        // image	boolean	trueを指定すると、画像があるデータを対象に検索します。falseは無効です。

        // open	string	特定の日時に開店している施設を検索します。
        //      日付と時間による検索 - date,hourで指定します。ex）5日の19時:5,19
        //      ・24時は0時として指定してください。
        //      ・指定できる日付は現在時刻から1週間後までです。
        //      曜日と時間による検索 - week,hourで指定します。ex）月曜日の12時:Mon,12
        //      ・曜日はMon,Tue,Wed,Thu,Fri,Sat,Sunのいずれかで指定します。
        //      現在時刻で開店している施設を検索 - nowで指定します。ex）現在時刻:now
        url += "&open=now";

        // loco_mode	boolean	Yahoo!ロコと同等の検索機能を有効にします。
        //      ・3文字以下のひらがなまたはカタカナでのクエリのロジックが変更になります。より絞り込まれた結果が返ってくるようになります。
        //      ・「ランチ」「飲み放題」「食べ放題」「女子会」「個室」で検索した場合、自動的にフラグ検索に切り替わります。
        //      「ランチ」の場合は、LunchFlagがtrueのものが対象です。
        //      「飲み放題」の場合は、AllYouCanDrinkFlagがtrueのものが対象です。
        //      「食べ放題」の場合は、AllYouCanEatFlagがtrueのものが対象です。
        //      「女子会」の場合は、LadysPartyFlagがtrueのものが対象です。
        //      「個室」の場合は、PrivateDiningFlagがtrueのものが対象です。
        //      デフォルト値はtrueで、falseを指定すると無効です。

        // maxprice	int	Priceタグの最大値を指定します。

        // minprice	int	Priceタグの最小値を指定します。

        logger.log(Level.INFO, LogFuncName+ " | " + "url : " + url);

        logger.log(Level.INFO, LogFuncName + " end");

        return url;
    }

    
    
}
