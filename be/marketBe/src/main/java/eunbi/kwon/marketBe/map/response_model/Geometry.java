package eunbi.kwon.marketBe.map.response_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
"Geometry":{
    "Type":"linestring",
    "Coordinates":"139.69902,35.53503 139.69899,35.53531 139.69903,35.5356"
}
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry{
    // Id	要素を特定するための識別子	 
    // Target	参照するGeometry要素の識別子	 
    // Type	図形種別	point、linestring、polygon、circle、ellipse、multigeometryのいずれかを指定します。
    // Coordinates	座標	「経度,緯度」形式の十進度で指定します。複数ある場合はスペース（0x20）で区切ります。
    // BoundingBox	表示範囲	図形を囲う矩形領域の左下座標と右上座標をスペースで区切って、「経度,緯度」形式の十進度で指定します。
    // Compress	圧縮座標	座標データが非常に多い場合、圧縮して指定します。
    // CompressType	圧縮仕様	Compress要素の圧縮仕様を指定します。
    // Datum	座標測地系	wgs、tkyのいずれかで指定します。
    // Exterior	polygonの外側座標	子要素に1個のCoordinatesを持ちます。
    // Interior	polygonの内側座標	子要素に1個のCoordinatesを持ちます。
    // Radius	半径（メートル）	図形種別がcircleの場合は1個、ellipseの場合は「横半径,縦半径」形式で指定します。
    // GeodesicFlag	測地系の有無	Geometryがpolylineの場合、測地系を考慮した線かどうかを表します。trueまたはfalseで指定します。
    // Distance	距離（キロメートル）	Geometryがpolylineの場合、始点から終点までの距離をkm単位で表します。
    @JsonProperty
    String Type;
    @JsonProperty
    String Coordinates;
}