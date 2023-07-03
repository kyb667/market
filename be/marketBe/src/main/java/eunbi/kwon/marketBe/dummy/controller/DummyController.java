package eunbi.kwon.marketBe.dummy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eunbi.kwon.marketBe.common.Config;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import eunbi.kwon.marketBe.dummy.service.DummyService;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/dummy")
public class DummyController {

	private final DummyService dummyService;
    
    private final Level LogLevel = Level.INFO;

	/*
	"ResultInfo" : {
    "Count" : 21,
    "Total" : 21,
    "Start" : 1,
    "Status" : 200,
    "Description" : "",
    "Copyright" : "",
    "Latency" : 0.167
  },
  "Feature" : [ {
    "Id" : "111231",
    "Gid" : "jeUdWfTChKs",
    "Name" : "\u8D64\u8EAB\u306B\u304F\u304C\u3068\u3046 \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.72918,35.660427"
    },
    "Category" : [ "\u713C\u8089" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "d0600760576cdae0f18eb56648371a540c2b0cbb",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30A2\u30AB\u30DF\u30CB\u30AF\u30AC\u30C8\u30A6 \u30ED\u30C3\u30DD\u30F3\u30AE\u30D2\u30EB\u30BA\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u68EE\u30BF\u30EF\u30FC 5F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-6434-0829",
      "Genre" : [ {
        "Code" : "0108001",
        "Name" : "\u713C\u8089"
      } ],
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "198",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "450",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5",
        "ExitId" : "4915",
        "Distance" : "814",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.724857,35.665752"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5F92\u6B692\u5206",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5F92\u6B692\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 \u5F92\u6B6910\u5206",
      "CatchCopy" : "\u4E16\u754C\u3067\u4E00\u756A\u306E\u8D64\u8EAB\u5C02\u9580\u5E97\u3092\u76EE\u6307\u3057\u3001\u304A\u8089\u3092\u53B3\u9078\u3057\u3054\u7D39\u4ECB\u3055\u305B\u3066\u3044\u305F\u3060\u304D\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData111500\/r111231\/111231ga10000008.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false"
    }
  }, {
    "Id" : "105600",
    "Gid" : "LSIUuQkoK_I",
    "Name" : "\u30B1\u30F3\u30BE\u30FC\u30A8\u30B9\u30C6\u30A4\u30C8\u30EF\u30A4\u30CA\u30EA\u30FC \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730584,35.6588490"
    },
    "Category" : [ "\u30D5\u30E9\u30F3\u30B9\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "b720d2ff22413fd1d26399efb9f82bdbbd10e394",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30B1\u30F3\u30BE\u30FC\u30A8\u30B9\u30C6\u30A4\u30C8\u30EF\u30A4\u30CA\u30EA\u30FC \u30ED\u30C3\u30DD\u30F3\u30AE\u30D2\u30EB\u30BA\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-12-4 \u516D\u672C\u6728\u30D2\u30EB\u30BA\u30EC\u30B8\u30C7\u30F3\u30B9D\u68DF 1F\uFF652F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-3408-1215",
      "Genre" : [ {
        "Code" : "0102005",
        "Name" : "\u30D5\u30E9\u30F3\u30B9\u6599\u7406\uFF08\u30D5\u30EC\u30F3\u30C1\uFF09"
      } ],
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "423",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "557",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "655",
        "Time" : "8",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5F92\u6B696\u5206",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5F92\u6B698\u5206",
      "Access3" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u9EBB\u5E03\u5341\u756A \u5F92\u6B698\u5206",
      "CatchCopy" : "\u4E16\u754C\u3092\u5E2D\u5DFB\u3059\u308B\u9AD8\u7D1A\u30EF\u30A4\u30F3\u300C\u30B1\u30F3\u30BE\u30FC \u30A8\u30B9\u30C6\u30A4\u30C8\u300D\u3092\u30B0\u30E9\u30B91\u676F\u304B\u3089\u3001\u3053\u3060\u308F\u308A\u306E\u7F8E\u98DF\u3068\u3068\u3082\u306B\u6109\u3057\u3081\u308B\u30EF\u30A4\u30CA\u30EA\u30FC\u76F4\u55B6\u30EC\u30B9\u30C8\u30E9\u30F3\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData106000\/r105600\/105600ga10000019.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "8"
    }
  }, {
    "Id" : "104886",
    "Gid" : "0o58I7DfAsA",
    "Name" : "\u30B4\u30FC\u30EB\u30C7\u30F3 \u30BF\u30A4\u30AC\u30FC \u516D\u672C\u6728\u5E97(GOLDEN TIGER)",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730069,35.6606927"
    },
    "Category" : [ "\u4E2D\u56FD\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "96c38b59eaaf2af35eeb9b6fb0a0094d9da36dd7",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30B4\u30FC\u30EB\u30C7\u30F3 \u30BF\u30A4\u30AC\u30FC \u30ED\u30C3\u30DD\u30F3\u30AE\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA \u30D2\u30EB\u30B5\u30A4\u30C91F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0104001",
        "Name" : "\u4E2D\u83EF\u6599\u7406"
      } ],
      "Rating" : "3.82",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "167",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "400",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "721",
        "Time" : "9",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 1C\u51FA\u53E3 \u5F92\u6B690\u5206\uFF08\u30B3\u30F3\u30B3\u30FC\u30B9\u306B\u3066\u76F4\u7D50\uFF09",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 3\u51FA\u53E3 \u5F92\u6B694\u5206",
      "CatchCopy" : "\u516D\u672C\u6728\u99C5\u304B\u3089\u307B\u3069\u8FD1\u3044\uFF64\u6771\u4EAC\u30BF\u30EF\u30FC\u3082\u671B\u3081\u308B\u958B\u653E\u7684\u306A\u7A7A\u9593\u3067\uFF64\u5F53\u5E97\u306E\u65B0\u3057\u3044\u30E2\u30C0\u30F3\u30C1\u30E3\u30A4\u30CB\u30FC\u30BA\u3092\u582A\u80FD\u3057\u3066\u304F\u3060\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData105000\/r104886\/104886ga10000057.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "1"
    }
  }, {
    "Id" : "108334",
    "Gid" : "WEYK7Yx_dUQ",
    "Name" : "\u6BDB\u5229 Salvatore Cuomo",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.729423,35.6604344"
    },
    "Category" : [ "\u30A4\u30BF\u30EA\u30A2\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "9dcaa5f617f3e0920304509401fac5fc5bdfbdc5",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30E2\u30A6\u30EA \u30B5\u30EB\u30F4\u30A1\u30C8\u30FC\u30EC \u30AF\u30AA\u30E2",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA \u30D2\u30EB\u30B5\u30A4\u30C9 B2F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-5772-6675",
      "Genre" : [ {
        "Code" : "0102006",
        "Name" : "\u30A4\u30BF\u30EA\u30A2\u6599\u7406\uFF08\u30A4\u30BF\u30EA\u30A2\u30F3\uFF09"
      } ],
      "Rating" : "4.29",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "209",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "455",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "799",
        "Time" : "9",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u30B3\u30F3\u30B3\u30FC\u30B9\u306B\u3066\u76F4\u7D50",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5F92\u6B694\u5206",
      "Access3" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u9EBB\u5E03\u5341\u756A \u5F92\u6B6910\u5206",
      "CatchCopy" : "\u3053\u3060\u308F\u308A\u306E\u6599\u7406\u306E\u6570\u3005\u3092\u582A\u80FD\u3067\u304D\u308B\u30AA\u30F3\u30EA\u30FC\u30EF\u30F3\u306E\u30B5\u30EB\u30F4\u30A1\u30C8\u30FC\u30EC\u30FB\u30AF\u30AA\u30E2\u30D6\u30E9\u30F3\u30C9\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData108500\/r108334\/108334ga10000168.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "38"
    }
  }, {
    "Id" : "110687",
    "Gid" : "v9XpUBNqLRM",
    "Name" : "BIKiNi SIS(\u30D3\u30AD\u30CB \u30B7\u30B9) \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.729165,35.6604322"
    },
    "Category" : [ "\u30B9\u30DA\u30A4\u30F3\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "cc834e8a71261c6db78b7db5f1105a24e26d8bae",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30D3\u30AD\u30CB \u30B7\u30B9",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA\u68EE\u30BF\u30EF\u30FC \u30A6\u30A7\u30B9\u30C8\u30A6\u30A9\u30FC\u30AF5\u968E",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102007",
        "Name" : "\u30B9\u30DA\u30A4\u30F3\u6599\u7406"
      } ],
      "Rating" : "3.77",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "198",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "450",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5",
        "ExitId" : "4915",
        "Distance" : "814",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.724857,35.665752"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 1C\u51FA\u53E3\u3088\u308A\u5F92\u6B694\u5206",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 3\u51FA\u53E3\u3088\u308A\u5F92\u6B697\u5206",
      "CatchCopy" : "\u65B0\u9BAE\u306A\u5C71\u3068\u6D77\u306E\u5E78\u3092\u4F7F\u3063\u305F\u30B9\u30DA\u30A4\u30F3\u30FB\u30AB\u30BF\u30EB\u30CB\u30A2\u4F1D\u7D71\u306E\u5473\u3068\u3001\u65E5\u672C\u306E\u56DB\u5B63\u306E\u98DF\u6750\u304C\u878D\u5408\u3057\u305F\u7F8E\u3057\u3044\u8272\u5F69\u306E\u6599\u7406\u306E\u6570\u3005\u3092\u304A\u6109\u3057\u307F\u3044\u305F\u3060\u3051\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData111000\/r110687\/110687ga10000022.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false"
    }
  }, {
    "Id" : "103431",
    "Gid" : "yBJlDqmxtd6",
    "Name" : "\u65E5\u672C\u6599\u7406 \u83F1\u6CBC",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.736536,35.6614874"
    },
    "Category" : [ "\u61D0\u77F3\u30FB\u4F1A\u5E2D\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "4b5ddd579f7b45c73b71f2c664b0d903f4612347",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30CB\u30DB\u30F3\u30EA\u30E7\u30A6\u30EA \u30D2\u30B7\u30CC\u30DE",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67285-17-1 AXIS\u30D3\u30EB B1F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-3568-6588",
      "Genre" : [ {
        "Code" : "0101001",
        "Name" : "\u61D0\u77F3\u6599\u7406"
      } ],
      "Rating" : "5.00",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "5",
        "ExitId" : "5432",
        "Distance" : "452",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.732811,35.663318"
        }
      }, {
        "Id" : "29324",
        "SubId" : "2932401",
        "Name" : "\u516D\u672C\u6728\u4E00\u4E01\u76EE",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "2",
        "ExitId" : "16600",
        "Distance" : "523",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.738868,35.664320"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "612",
        "Time" : "7",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5F92\u6B69\uFF13\u5206",
      "CatchCopy" : "\u5E97\u5185\u306F\u30C0\u30A4\u30CB\u30F3\u30B0\u30FB\u500B\u5BA42\u90E8\u5C4B\u5B8C\u5099\u3002\u5E8A\u6696\u623F\u3092\u65BD\u3057\u305F\u30D0\u30EA\u30A2\u30D5\u30EA\u30FC\u4ED5\u69D8\u3002\u65EC\u306E\u6599\u7406\u306F\u30A2\u30F3\u30C1\u30A8\u30A4\u30B8\u30F3\u30B0\u52B9\u679C\u304C\u9AD8\u304F\u30EF\u30A4\u30F3(130\u7A2E)\u3068\u304A\u697D\u3057\u307F\u4E0B\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData103500\/r103431\/103431ga10000019.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "21"
    }
  }, {
    "Id" : "115840",
    "Gid" : "_70rwG3rVvg",
    "Name" : "DAL-MATTO \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.728862,35.6603037"
    },
    "Category" : [ "\u30A4\u30BF\u30EA\u30A2\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "3a1c7ad6456c510aed297b2c91ecb487f236277f",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30C0\u30EB\u30DE\u30C3\u30C8 \u30ED\u30C3\u30DD\u30F3\u30AE\u30D2\u30EB\u30BA\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA \u30A6\u30A7\u30B9\u30C8\u30A6\u30A9\u30FC\u30AF 5F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-6804-1644",
      "Genre" : [ {
        "Code" : "0102006",
        "Name" : "\u30A4\u30BF\u30EA\u30A2\u6599\u7406\uFF08\u30A4\u30BF\u30EA\u30A2\u30F3\uFF09"
      } ],
      "Rating" : "4.17",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "219",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "473",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "830",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5F92\u6B691\u5206",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5F92\u6B695\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 \u5F92\u6B697\u5206",
      "CatchCopy" : "DAL-MATTO\u3067\u306F\u65E5\u3005\u3001\u65EC\u306E\u98DF\u6750\u3092\u591A\u304F\u306E\u5951\u7D04\u8FB2\u5BB6\u3084\u5E02\u5834\u304B\u3089\u63A2\u3057\u96C6\u3081\u3001\u3054\u63D0\u4F9B\u3057\u3066\u304A\u308A\u307E\u3059\u3002\u98DF\u30DE\u30CB\u30A2\u3092\u71B1\u72C2\u3055\u305B\u308B\u30A4\u30BF\u30EA\u30A2\u6599\u7406\u3092\u304A\u697D\u3057\u307F\u304F\u3060\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData116000\/r115840\/115840ga10000068.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "2"
    }
  }, {
    "Id" : "101445",
    "Gid" : "YMXlUmFVLUg",
    "Name" : "SILIN \u706B\u9F8D\u5712",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730697,35.6666881"
    },
    "Category" : [ "\u4E2D\u56FD\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "8cc24e0cc95cbbe5ff94cede52b6b0058c321088",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30B7\u30EA\u30F3 \u30D5\u30A1\u30F3 \u30ED\u30F3 \u30E6\u30A7\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-1 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3 \u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B92F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0104001",
        "Name" : "\u4E2D\u83EF\u6599\u7406"
      } ],
      "Rating" : "3.30",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "485",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "1",
        "ExitId" : "4911",
        "Distance" : "517",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727681,35.667996"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "828",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u99C5\u76F4\u7D50\uFF0F\u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3\u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B91\u968E",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u99C5\u76F4\u7D50\uFF0F\u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3\u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B91\u968E",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D043\u5206",
      "CatchCopy" : "\u30AA\u30FC\u30CA\u30FC\u30B7\u30A7\u30D5\u306E\u5510\u6731\u8208\u306F\u5468\u5BCC\u5FB3\u6C0F\u306E\u611B\u5F1F\u5B50\u3002\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3\u958B\u696D\u3068\u3068\u3082\u306B\u300CSILIN\u706B\u9F8D\u5712\u300D\u3092\u958B\u5E97\u3002\u5E83\u6771\u6599\u7406\u306E\u6280\u6CD5\u3092\u3082\u3068\u306B\u73FE\u4EE3\u7684\u306A\u4E2D\u56FD\u5E83\u6771\u6599\u7406\u3092\u63D0\u4F9B\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData101500\/r101445\/101445ga10000099.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "7"
    }
  }, {
    "Id" : "113144",
    "Gid" : "zPiza1uv3qQ",
    "Name" : "SUSHI TOKYO TEN\u3001\u516D\u672C\u6728",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730225,35.6662743"
    },
    "Category" : [ "\u9BA8" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "15d35f99b62856c6a697c5cca8203081293ca3a2",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30B9\u30B7 \u30C8\u30FC\u30AD\u30E7\u30FC \u30C6\u30F3 \u30ED\u30C3\u30DD\u30F3\u30AE",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-4 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3(\u516D\u672C\u6728)\u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B91F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-5843-1690",
      "Genre" : [ ],
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "381",
        "Time" : "4",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "2",
        "ExitId" : "4912",
        "Distance" : "426",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727654,35.667739"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "702",
        "Time" : "8",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 8\u756A\u51FA\u53E3\u3088\u308A\u76F4\u7D50",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5730\u4E0B\u901A\u8DEF\u306B\u3066\u76F4\u7D50\u203B \u5730\u4E0B\u901A\u8DEF\u9014\u4E2D\u306B\u968E\u6BB5\u304C\u3042\u308A\u307E\u3059\u3002\u8ECA\u6905\u5B50\u30FB\u30D9\u30D3\u30FC\u30AB\u30FC\u3054\u5229\u7528\u306E\u304A\u5BA2\u69D8\u306F\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\u3067\u306E \u304A\u8D8A\u3057\u3092\u63A8\u5968\u3044\u305F\u3057\u307E\u3059\u3002",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D043\u5206",
      "CatchCopy" : "\u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3\u5185\u306B\u3042\u308B\u300CSUSHI TOKYO TEN\u300D\u3002\u65EC\u306E\u7D20\u6750\u3092\u3061\u3087\u3063\u3068\u3065\u3064\u6CA2\u5C71\u3092\u30B3\u30F3\u30BB\u30D7\u30C8\u306B\u3001\u304A\u307E\u304B\u305B\u3092\u3054\u63D0\u4F9B\u3057\u307E\u3059\u3002\u6C5F\u6238\u524D\u306E\u6280\u3092\u3054\u582A\u80FD\u304F\u3060\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData113500\/r113144\/113144ga10000013.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "5"
    }
  }, {
    "Id" : "112350",
    "Gid" : "FQV_eBJYMfk",
    "Name" : "DIYA\u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730098,35.6604365"
    },
    "Category" : [ "\u30A4\u30F3\u30C9\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "709fa5a7c78d913a32b70b8d060ad2e37d12df56",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30C7\u30A3\u30E4 \u30ED\u30C3\u30DD\u30F3\u30AE\u30D2\u30EB\u30BA\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA \u30D2\u30EB\u30B5\u30A4\u30C9 B1F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-6438-1177",
      "Genre" : [ {
        "Code" : "0105006",
        "Name" : "\u30A4\u30F3\u30C9\u6599\u7406"
      } ],
      "Rating" : "3.83",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "220",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "453",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "722",
        "Time" : "9",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 1C\u51FA\u53E3\u5F92\u6B691\u5206",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 3\u756A\u51FA\u53E3\u5F92\u6B694\u5206",
      "Access3" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u9EBB\u5E03\u5341\u756A 7\u756A\u51FA\u53E3\u5F92\u6B694\u5206",
      "CatchCopy" : "\u30A4\u30F3\u30C9\u306E\u53E4\u5178\u7684\u306A\u30EC\u30B7\u30D4\u3001\u30B9\u30D1\u30A4\u30B9\u3001\u304A\u3088\u3073\u98A8\u5473\u306B\u57FA\u3065\u304D\u3001\u305D\u308C\u3089\u306E\u6599\u7406\u306B\u90FD\u4F1A\u7684\u306A\u30A8\u30C3\u30BB\u30F3\u30B9\u3092\u52A0\u3048\u305F\u30E2\u30C0\u30F3\u306A\u30A4\u30F3\u30C9\u30EC\u30B9\u30C8\u30E9\u30F3\u3067\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData112500\/r112350\/112350ga10000021.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "29"
    }
  }, {
    "Id" : "109559",
    "Gid" : "iJREKpASuMc",
    "Name" : "BLT STEAK ROPPONGI",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.739300,35.6645985"
    },
    "Category" : [ "\u30B9\u30C6\u30FC\u30AD\u30FB\u30B0\u30EA\u30EB\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "2267046f252413d733c1e0f1a7401554e9b7b170",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30D3\u30FC\u30A8\u30EB\u30C6\u30A3\u30FC\u30B9\u30C6\u30FC\u30AD \u30ED\u30C3\u30DD\u30F3\u30AE",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67281\u4E01\u76EE6-1 \u6CC9\u30AC\u30FC\u30C7\u30F3\u30BF\u30EF\u30FC5\u968E",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102001",
        "Name" : "\u30B9\u30C6\u30FC\u30AD\u3001\u30CF\u30F3\u30D0\u30FC\u30B0"
      } ],
      "Rating" : "4.18",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "29324",
        "SubId" : "2932401",
        "Name" : "\u516D\u672C\u6728\u4E00\u4E01\u76EE",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "2",
        "ExitId" : "16600",
        "Distance" : "38",
        "Time" : "0",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.738868,35.664320"
        }
      }, {
        "Id" : "29194",
        "SubId" : "2919401",
        "Name" : "\u6E9C\u6C60\u5C71\u738B",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u9280\u5EA7\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "13",
        "ExitId" : "16342",
        "Distance" : "575",
        "Time" : "7",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.741146,35.668946"
        }
      }, {
        "Id" : "22610",
        "SubId" : "2261001",
        "Name" : "\u795E\u8C37\u753A",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "3708",
        "Distance" : "744",
        "Time" : "9",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.744483,35.662669"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317 \u516D\u672C\u6728\u4E00\u4E01\u76EE \u3010\u6771\u4EAC\u30E1\u30C8\u30ED\u3067\u304A\u8D8A\u3057\u306E\u304A\u5BA2\u69D8\u3011\u76F4\u901A\u203B2\u756A\u6539\u672D\u3092\u51FA\u3066\u3001\u53F3\u3078\u304A\u9032\u307F\u304F\u3060\u3055\u3044\u3002\u524D\u65B9\u306E\u30A8\u30B9\u30AB\u30EC\u30FC\u30BF\u30FC\u4E57\u308A\u53E3\u5DE6\u624B\u3001\u81EA\u52D5\u30C9\u30A2\u306E\u5965\u306B\u30A8\u30EC\u30D9\u30FC\u30BF\u30FC\u304C\u3054\u3056\u3044\u307E\u3059\u306E\u30675\u968E\u3078\u304A\u4E0A\u304C\u308A\u304F\u3060\u3055\u3044\u307E\u305B\u3002",
      "CatchCopy" : "2004\u5E74\u306BNY\u672C\u5E97\u3092\u30AA\u30FC\u30D7\u30F3\u4EE5\u6765\u30A2\u30E1\u30EA\u30AB\u56FD\u5185\u5916\u306B16\u5E97\u8217\u3092\u5C55\u958B\u3059\u308BBLT STEAK\u3002\u6700\u9AD8\u7D1A\u30D7\u30E9\u30A4\u30E0\u30B0\u30EC\u30FC\u30C9\u306E\u30B9\u30C6\u30FC\u30AD\u3068\u30DD\u30C3\u30D7\u30AA\u30FC\u30D0\u30FC\u3092\u3054\u8CDE\u5473\u304F\u3060\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData110000\/r109559\/109559ga10000048.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "26"
    }
  }, {
    "Id" : "107622",
    "Gid" : "i4uhYOZen0Q",
    "Name" : "\u30D5\u30A3\u30EA\u30C3\u30D7\u30FB\u30DF\u30EB\u6771\u4EAC",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730601,35.6667071"
    },
    "Category" : [ "\u30D5\u30E9\u30F3\u30B9\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "96f6c26feb25388fdbbdd7bf64b6de648e5dcb4e",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30D5\u30A3\u30EA\u30C3\u30D7 \u30DF\u30EB \u30C8\u30A6\u30AD\u30E7\u30A6",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-4 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3 \u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B9 4F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102005",
        "Name" : "\u30D5\u30E9\u30F3\u30B9\u6599\u7406\uFF08\u30D5\u30EC\u30F3\u30C1\uFF09"
      } ],
      "Rating" : "4.33",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "494",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "1",
        "ExitId" : "4911",
        "Distance" : "526",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727681,35.667996"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "837",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5730\u4E0B\u76F4\u7D50",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5730\u4E0B\u76F4\u7D50",
      "CatchCopy" : "\u201C\u512A\u96C5\u306A\u30B7\u30E3\u30F3\u30D1\u30FC\u30CB\u30E5\u30B5\u30ED\u30F3\u201D\u3092\u30B3\u30F3\u30BB\u30D7\u30C8\u306B\u3001\u304A\u6599\u7406\u3068\u30B7\u30E3\u30F3\u30D1\u30FC\u30CB\u30E5\u306E\u5E45\u5E83\u3044\u697D\u3057\u307F\u65B9\u3092\u3054\u63D0\u6848\u3057\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData108000\/r107622\/107622ga10000285.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "69"
    }
  }, {
    "Id" : "105092",
    "Gid" : "zdCXZSfR5s2",
    "Name" : "\u30EC\u30B9\u30C8\u30E9\u30F3 SAKURA\/\u56FD\u969B\u6587\u5316\u4F1A\u9928",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.733219,35.6583379"
    },
    "Category" : [ "\u30D5\u30E9\u30F3\u30B9\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "857df302d12d00e63d62cdf91a8684f458d6b5c0",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30EC\u30B9\u30C8\u30E9\u30F3 \u30B5\u30AF\u30E9",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67285-11-16 \u56FD\u969B\u6587\u5316\u4F1A\u9928 B1F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102005",
        "Name" : "\u30D5\u30E9\u30F3\u30B9\u6599\u7406\uFF08\u30D5\u30EC\u30F3\u30C1\uFF09"
      } ],
      "Rating" : "3.94",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "29325",
        "SubId" : "2932501",
        "Name" : "\u9EBB\u5E03\u5341\u756A",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "7",
        "ExitId" : "16604",
        "Distance" : "340",
        "Time" : "4",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.735156,35.656873"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "640",
        "Time" : "8",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "652",
        "Time" : "8",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5927\u6C5F\u6238 \u9EBB\u5E03\u5341\u756A 7\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B695\u5206",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317 \u9EBB\u5E03\u5341\u756A 4\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B698\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B6910\u5206",
      "CatchCopy" : "\u7A93\u306E\u5916\u306E\u666F\u8272\u3068\u5171\u306B\u3001\u5B63\u7BC0\u3092\u611F\u3058\u308B\u512A\u3057\u3044\u5473\u308F\u3044\u306E\u30D5\u30EC\u30F3\u30C1\u3092\u697D\u3057\u3081\u308B\u30EC\u30B9\u30C8\u30E9\u30F3\u3067\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData105500\/r105092\/105092ga10000115.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "8"
    }
  }, {
    "Id" : "100798",
    "Gid" : "aRrEc8Zen0Q",
    "Name" : "\u3066\u3093\u3077\u3089\u5C71\u306E\u4E0ARoppongi",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.730608,35.6666970"
    },
    "Category" : [ "\u5929\u3077\u3089" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "c858766745fdfa086e8f6eda420938850207bf63",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30C6\u30F3\u30D7\u30E9\u30E4\u30DE\u30CE\u30A6\u30A8\u30ED\u30C3\u30DD\u30F3\u30AE",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-4 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3\u5185 \u30AC\u30FC\u30C7\u30F3\u30C6\u30E9\u30B93F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-5413-3577",
      "Genre" : [ {
        "Code" : "0101014",
        "Name" : "\u5929\u3077\u3089\u3001\u63DA\u3052\u7269"
      } ],
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "492",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "1",
        "ExitId" : "4911",
        "Distance" : "524",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727681,35.667996"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "835",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5927\u6C5F\u6238 \u516D\u672C\u6728 8\u756A\u51FA\u53E3\u3088\u308A\u76F4\u7D50",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5730\u4E0B\u901A\u8DEF\u306B\u3066\u76F4\u7D50",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D043\u5206",
      "CatchCopy" : "1954\u5E74\u5275\u696D\u3001\u795E\u7530\u99FF\u6CB3\u53F0\u300C\u5C71\u306E\u4E0A\u30DB\u30C6\u30EB\u300D\u3068\u6642\u3092\u540C\u3058\u304F\u3057\u3066\u958B\u5E97\u3057\u305F\u300C\u3066\u3093\u3077\u3089 \u5C71\u306E\u4E0A\u300D\u3002\u30DB\u30C6\u30EB\u3068\u540C\u69D8\u306B\u611B\u3055\u308C\u7D9A\u3051\u305F\u5473\u306F\u4ECA\u3067\u3082\u53D7\u3051\u7D99\u304C\u308C\u3066\u3044\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData101000\/r100798\/100798ga10000019.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "51"
    }
  }, {
    "Id" : "101169",
    "Gid" : "sZj1G-NHqY7",
    "Name" : "\u30BF\u30EF\u30FC\u30BA\/\u30B6\u30FB\u30EA\u30C3\u30C4\u30FB\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.731308,35.6662185"
    },
    "Category" : [ "\u6D0B\u98DF\u305D\u306E\u4ED6" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "b5f638384bcb994951fb3543b818d75a629a05a6",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30BF\u30EF\u30FC\u30BA",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-1 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3 \u30B6\uFF65\u30EA\u30C3\u30C4\uFF65\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC45\u968E",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102004",
        "Name" : "\u6D0B\u98DF\uFF08\u305D\u306E\u4ED6\uFF09"
      } ],
      "Rating" : "4.31",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "492",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "1",
        "ExitId" : "4911",
        "Distance" : "553",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727681,35.667996"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "835",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA\u3001\u90FD\u55B6\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA\uFF1A4a\u51FA\u53E3\u5074\u304B\u3089\u5730\u4E0B\u901A\u8DEF\u3092\u7D4C\u7531\u3057\u30018\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50\u3000\u3000\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\uFF1A8\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 :3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D045\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317 \u516D\u672C\u6728\u4E00\u4E01\u76EE \u5F92\u6B698\u5206",
      "CatchCopy" : "\u4E0A\u8CEA\u306A\u98DF\u6750\u3092\u30D5\u30E9\u30F3\u30B9\u6599\u7406\u306E\u4F1D\u7D71\u7684\u306A\u6280\u6CD5\u3067\u4E01\u5BE7\u304B\u3064\u30B7\u30F3\u30D7\u30EB\u306B\u4ED5\u4E0A\u3052\u308B\u672C\u683C\u7684\u7F8E\u98DF\u30E1\u30CB\u30E5\u30FC\u306E\u6570\u3005\u3092\u53B3\u9078\u30EF\u30A4\u30F3\u3068\u3068\u3082\u306B\u3054\u63D0\u4F9B\u3044\u305F\u3057\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData101500\/r101169\/101169ga10000204.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "82"
    }
  }, {
    "Id" : "111088",
    "Gid" : "j-5ySPTChKs",
    "Name" : "\u8001\u56DB\u5DDD \u98C4\u9999\u5C0F\u9662",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.72918,35.660426"
    },
    "Category" : [ "\u4E2D\u56FD\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "85794365c7606cefc72053cfbe32c47dcd736976",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30E9\u30AA\u30B7\u30BB\u30F3 \u30D4\u30E3\u30AA\u30B7\u30E3\u30F3 \u30B7\u30E7\u30A6\u30A4\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA \u30A6\u30A7\u30B9\u30C8\u30A6\u30A9\u30FC\u30AF 5F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-6804-2848",
      "Genre" : [ {
        "Code" : "0104001",
        "Name" : "\u4E2D\u83EF\u6599\u7406"
      } ],
      "Rating" : "4.21",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "198",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "450",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5",
        "ExitId" : "4915",
        "Distance" : "814",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.724857,35.665752"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 1C\u51FA\u53E3\u3088\u308A\u5F92\u6B694\u5206",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 3\u51FA\u53E3\u3088\u308A\u5F92\u6B697\u5206",
      "CatchCopy" : "\u9999\u8F9B\u6599\u3092\u5DE7\u307F\u306B\u4F7F\u7528\u3057\u305F\u9999\u308A\u9AD8\u304F\u3001\u6DF1\u304F\u8907\u96D1\u306A\u5473\u308F\u3044\u3068\u30B9\u30C3\u30AD\u30EA\u3068\u3057\u305F\u5F8C\u5473\u306E\u56DB\u5DDD\u4F1D\u7D71\u6599\u7406\u3092\u300C\u8001\u56DB\u5DDD \u98C4\u9999\u5C0F\u9662\u300D\u3067\u3054\u582A\u80FD\u304F\u3060\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData111500\/r111088\/111088ga10000010.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "2"
    }
  }, {
    "Id" : "105955",
    "Gid" : "TXQ0oUz9VEA",
    "Name" : "\u65C5\u4EAD\u307E\u3093\u3077\u304F \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.729217,35.6604545"
    },
    "Category" : [ "\u713C\u8089" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "a57af4ecb8f5386ae2ec799a0acd6fffc0adbe33",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30EA\u30E7\u30C6\u30A4\u30DE\u30F3\u30D7\u30AF \u30ED\u30C3\u30DD\u30F3\u30AE\u30D2\u30EB\u30BA\u30C6\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u516D\u672C\u67286-10-1 \u516D\u672C\u6728\u30D2\u30EB\u30BA\u30D2\u30EB\u30B5\u30A4\u30C9B1F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-5414-5329",
      "Genre" : [ {
        "Code" : "0108001",
        "Name" : "\u713C\u8089"
      } ],
      "Rating" : "4.03",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "194",
        "Time" : "2",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "445",
        "Time" : "5",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5",
        "ExitId" : "4915",
        "Distance" : "810",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.724857,35.665752"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 1C\u51FA\u53E3\u3088\u308A\u30B3\u30F3\u30B3\u30FC\u30B9\u306B\u3066\u76F4\u7D50",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\uFF14\u5206",
      "CatchCopy" : "\u4F1D\u7D71\u306E\u30CD\u30AE\u30BF\u30F3\u5869\u3068\u81EA\u6162\u306E\u9ED2\u6BDB\u548C\u725B\u306E\u713C\u8089\u3092\u306F\u3058\u3081\u65EC\u306E\u91CE\u83DC\u3092\u3075\u3093\u3060\u3093\u306B\u53D6\u308A\u5165\u308C\u305F\u3001\u5B89\u5FC3\u3067\u4F53\u306B\u512A\u3057\u3044\u548C\u98DF\u3092\u63D0\u4F9B\u3002\u307E\u3093\u3077\u304F\u306E\u65B0\u5883\u5730\u3092\u304A\u6109\u3057\u307F\u4E0B\u3055\u3044\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData106000\/r105955\/105955ga10000072.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "6"
    }
  }, {
    "Id" : "101171",
    "Gid" : "URre2UNHqY7",
    "Name" : "\u30A2\u30B8\u30E5\u30FC\u30EB \u30D5\u30A9\u30FC\u30C6\u30A3\u30FC\u30D5\u30A1\u30A4\u30D6\/\u30B6\u30FB\u30EA\u30C3\u30C4\u30FB\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.731308,35.6662185"
    },
    "Category" : [ "\u30D5\u30E9\u30F3\u30B9\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "c4720c9d3329c27f0abfb0d7de5e3c52fbba5bfb",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30A2\u30B8\u30E5\u30FC\u30EB \u30D5\u30A9\u30FC\u30C6\u30A3\u30FC\u30D5\u30A1\u30A4\u30D6",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-1 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3 \u30B6\uFF65\u30EA\u30C3\u30C4\uFF65\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC45\u968E",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0102005",
        "Name" : "\u30D5\u30E9\u30F3\u30B9\u6599\u7406\uFF08\u30D5\u30EC\u30F3\u30C1\uFF09"
      } ],
      "Rating" : "4.53",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "492",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "1",
        "ExitId" : "4911",
        "Distance" : "553",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727681,35.667996"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "835",
        "Time" : "10",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA\u3001\u90FD\u55B6\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA\uFF1A4a\u51FA\u53E3\u5074\u304B\u3089\u5730\u4E0B\u901A\u8DEF\u3092\u7D4C\u7531\u3057\u30018\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50\u3000\u3000\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\uFF1A8\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 :3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D045\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317 \u516D\u672C\u6728\u4E00\u4E01\u76EE \u5F92\u6B698\u5206",
      "CatchCopy" : "\u58EE\u5927\u306A\u773A\u671B\u3092\u898B\u6E21\u305B\u308B\u512A\u96C5\u306A\u7A7A\u9593\u3067\u5FC3\u306E\u3053\u3082\u3063\u305F\u304A\u3082\u3066\u306A\u3057\u3068\u5171\u306B\u6B63\u7D71\u6D3E\u30D5\u30E9\u30F3\u30B9\u6599\u7406\u3092\u304A\u6109\u3057\u307F\u3044\u305F\u3060\u3051\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData101500\/r101171\/101171ga10000158.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "29"
    }
  }, {
    "Id" : "104285",
    "Gid" : "HlNrp4p-dxo",
    "Name" : "\u65E5\u672C\u6599\u7406 \u3072\u306E\u304D\u3056\u304B\/\u30B6\u30FB\u30EA\u30C3\u30C4\u30FB\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.731492,35.6661126"
    },
    "Category" : [ "\u61D0\u77F3\u30FB\u4F1A\u5E2D\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "8cf87b53f7b0e185761a6adfe1b439c19b2daf23",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30CB\u30DB\u30F3\u30EA\u30E7\u30A6\u30EA \u30D2\u30CE\u30AD\u30B6\u30AB",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57429-7-1 \u6771\u4EAC\u30DF\u30C3\u30C9\u30BF\u30A6\u30F3 \u30B6\uFF65\u30EA\u30C3\u30C4\uFF65\u30AB\u30FC\u30EB\u30C8\u30F3\u6771\u4EAC45\u968E",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0101001",
        "Name" : "\u61D0\u77F3\u6599\u7406"
      } ],
      "Rating" : "4.63",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "7",
        "ExitId" : "5423",
        "Distance" : "252",
        "Time" : "3",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731075,35.664569"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "2",
        "ExitId" : "5429",
        "Distance" : "595",
        "Time" : "7",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.730242,35.662454"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "2",
        "ExitId" : "4912",
        "Distance" : "636",
        "Time" : "7",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.727654,35.667739"
        }
      } ],
      "Access1" : "\u90FD\u55B6\u5927\u6C5F\u6238 \u516D\u672C\u6728 8\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 4a\u51FA\u53E3\u5074\u304B\u3089\u5730\u4E0B\u901A\u8DEF\u3092\u7D4C\u7531\u3057\u30018\u756A\u51FA\u53E3\u3088\u308A\u5730\u4E0B\u901A\u8DEF\u76F4\u7D50",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u4E43\u6728\u5742 3\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B69\u7D043\u5206",
      "CatchCopy" : "\u5E97\u5185\u306E\u30C7\u30B6\u30A4\u30F3\u306F\u3001\u4F1A\u5E2D\u30FB\u5BFF\u53F8\u30FB\u5929\u9EA9\u7F85\u30FB\u9244\u677F\u713C\u305D\u308C\u305E\u308C\u306E\u30B5\u30FC\u30D3\u30B9\u3092\u3088\u308A\u9B45\u529B\u7684\u306B\u6F14\u51FA\u3057\u3001\u7D20\u6750\u306E\u6301\u3061\u5473\u3092\u5927\u5207\u306B\u3057\u305F\u304A\u6599\u7406\u3092\u304A\u697D\u3057\u307F\u9802\u3051\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData104500\/r104285\/104285ga10000076.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "2"
    }
  }, {
    "Id" : "107442",
    "Gid" : "QAplJfNca6A",
    "Name" : "\u9EBB\u5E03 \u65EC\u5F69\u548C\u98DF \u304B\u3059\u307F",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.726823,35.6592532"
    },
    "Category" : [ "\u61D0\u77F3\u30FB\u4F1A\u5E2D\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "c5bc147f8807cba4f895e91032a0d4c872d65968",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30A2\u30B6\u30D6 \u30B7\u30E5\u30F3\u30B5\u30A4\u30EF\u30B7\u30E7\u30AF \u30AB\u30B9\u30DF",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u897F\u9EBB\u5E033-2-32",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Tel1" : "03-3408-0464",
      "Genre" : [ {
        "Code" : "0101001",
        "Name" : "\u61D0\u77F3\u6599\u7406"
      } ],
      "Rating" : "4.50",
      "Station" : [ {
        "Id" : "23049",
        "SubId" : "2304902",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "1c",
        "ExitId" : "5430",
        "Distance" : "486",
        "Time" : "6",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.729566,35.661638"
        }
      }, {
        "Id" : "23049",
        "SubId" : "2304901",
        "Name" : "\u516D\u672C\u6728",
        "Railway" : "\u90FD\u55B6\u5927\u6C5F\u6238\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37\u7DDA",
        "Exit" : "3",
        "ExitId" : "5431",
        "Distance" : "740",
        "Time" : "9",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.731961,35.662835"
        }
      }, {
        "Id" : "22893",
        "SubId" : "2289301",
        "Name" : "\u4E43\u6728\u5742",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5",
        "ExitId" : "4915",
        "Distance" : "903",
        "Time" : "11",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.724857,35.665752"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u65E5\u6BD4\u8C37 \u516D\u672C\u6728 \u5F92\u6B699\u5206\u30001\u756A\u51FA\u53E3\u3088\u308A\u3000\u30DE\u30AF\u30C9\u30CA\u30EB\u30C9 \u516D\u672C\u6728\u30D2\u30EB\u30BA\u5E97\u5074\u306B\u6E21\u308A\u3001\u897F\u9EBB\u5E03\u65B9\u9762\u76F4\u9032\uFF32\uFF24\u897F\u9EBB\u5E03\u30D3\u30EB\u3092\u5DE6\u6298\u5F8C\u76F4\u9032\u5DE6\u5074",
      "Access2" : "\u90FD\u55B6\u5730\u4E0B\u9244\u5927\u6C5F\u6238 \u516D\u672C\u6728 \u5F92\u6B699\u5206",
      "CatchCopy" : "\u65EC\u306E\u98DF\u6750\u3092\u305F\u3063\u3077\u308A\u4F7F\u7528\u3057\u305F\u56DB\u5B63\u6298\u3005\u306E\u6599\u7406\u3092\u5473\u308F\u3048\u308B\u300C\u9EBB\u5E03 \u65EC\u5F69\u548C\u98DF \u304B\u3059\u307F\u300D\u3002\u6E05\u6F54\u611F\u306E\u3042\u308B\u843D\u3061\u7740\u3044\u305F\u96F0\u56F2\u6C17\u3067\u304A\u98DF\u4E8B\u3092\u304A\u6109\u3057\u307F\u3044\u305F\u3060\u3051\u307E\u3059\u3002",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData107500\/r107442\/107442ga10000003.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "2"
    }
  }, {
    "Id" : "100531",
    "Gid" : "HvbRnl1DvCw",
    "Name" : "\u65E5\u672C\u6599\u7406 \u8D64\u5742 \u7D19\u97F3",
    "Geometry" : {
      "Type" : "point",
      "Coordinates" : "139.738305,35.6704894"
    },
    "Category" : [ "\u61D0\u77F3\u30FB\u4F1A\u5E2D\u6599\u7406" ],
    "Description" : "",
    "Style" : [ ],
    "Property" : {
      "Uid" : "8f823ca9081a464d0e5bd24164ca4106149ac6a7",
      "CassetteId" : "1852ed1e9b6d12c23cd34e79a4be4c71",
      "Yomi" : "\u30CB\u30DB\u30F3\u30EA\u30E7\u30A6\u30EA \u30A2\u30AB\u30B5\u30AB \u30B7\u30AA\u30F3",
      "Country" : {
        "Code" : "JP",
        "Name" : "\u65E5\u672C"
      },
      "Address" : "\u6771\u4EAC\u90FD\u6E2F\u533A\u8D64\u57422-17-55 \u5927\u91CE\u30D3\u30EB1F",
      "GovernmentCode" : "13103",
      "AddressMatchingLevel" : "6",
      "Genre" : [ {
        "Code" : "0101001",
        "Name" : "\u61D0\u77F3\u6599\u7406"
      } ],
      "Rating" : "5.00",
      "Area" : [ {
        "Code" : "000025",
        "Name" : "\u8D64\u5742\u30FB\u516D\u672C\u6728"
      } ],
      "Station" : [ {
        "Id" : "22485",
        "SubId" : "2248501",
        "Name" : "\u8D64\u5742(\u6771\u4EAC\u90FD)",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530\u7DDA",
        "Exit" : "5a",
        "ExitId" : "3047",
        "Distance" : "289",
        "Time" : "3",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.736701,35.672096"
        }
      }, {
        "Id" : "29194",
        "SubId" : "2919401",
        "Name" : "\u6E9C\u6C60\u5C71\u738B",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u9280\u5EA7\u7DDA\/\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "13",
        "ExitId" : "16342",
        "Distance" : "576",
        "Time" : "7",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.741146,35.668946"
        }
      }, {
        "Id" : "29324",
        "SubId" : "2932401",
        "Name" : "\u516D\u672C\u6728\u4E00\u4E01\u76EE",
        "Railway" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5357\u5317\u7DDA",
        "Exit" : "3",
        "ExitId" : "16601",
        "Distance" : "681",
        "Time" : "8",
        "Geometry" : {
          "Type" : "point",
          "Coordinates" : "139.739266,35.666430"
        }
      } ],
      "Access1" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u5343\u4EE3\u7530 \u8D64\u5742 3a\u51FA\u53E3\u3088\u308A\u5F92\u6B695\u5206",
      "Access2" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u9280\u5EA7\u7DDA\u30FB\u5357\u5317 \u6E9C\u6C60\u5C71\u738B 11\u756A\u51FA\u53E3\u3088\u308A\u5F92\u6B698\u5206",
      "Access3" : "\u6771\u4EAC\u30E1\u30C8\u30ED\u9280\u5EA7\u7DDA\u30FB\u4E38\u306E\u5185 \u8D64\u5742\u898B\u9644 \u5F92\u6B6912\u5206",
      "CatchCopy" : "\u90FD\u4F1A\u306E\u55A7\u9A12\u3092\u5FD8\u308C\u308B\u5BDB\u304E\u306E\u304A\u9047\u3057\u3001\u5149\u3068\u5F71\u3092\u6109\u3057\u3080\u3084\u308F\u3089\u304B\u306A\u706F\u308A\u3002\u6599\u7406\u304C\u969B\u7ACB\u3064\u5668\u306E\u9078\u629E\u3002\u571F\u58C1\u3092\u7528\u3044\u305F\u843D\u3061\u7740\u304D\u306E\u7A7A\u9593\u3002\u548C\u306E\u98A8\u60C5\u3092\u611F\u3058\u3055\u305B\u308B\u304A\u5E97\u3067\u3059",
      "LeadImage" : "https:\/\/restaurant.img-ikyu.com\/rsDatas\/rsData101000\/r100531\/100531ga10000037.jpg",
      "CreditcardFlag" : "true",
      "ParkingFlag" : "true",
      "SmartPhoneCouponFlag" : "false",
      "KeepCount" : "7"
    }
  } ]
}
	 */
	@GetMapping("/localSearch")
	JsonNode dummy(HttpServletRequest request) throws Exception {

    String appid = request.getParameter("appid");

    JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> ResultInfo = new HashMap<>();

    if (appid.equals("test_zero") == true){

      ResultInfo = dummyService.NoData();

    } else {
      String results = request.getParameter("results");

      String lat = request.getParameter("lat");

      String lon = request.getParameter("lon");

      Map<String, Object> filters = new HashMap<>();

      String creditcard = request.getParameter("creditcard");

      if (creditcard != null){
        filters.put("creditcard", 0);
      }

      String parking = request.getParameter("parking");
      if (parking != null){
        filters.put("parking", 0);
      }

      String smoking = request.getParameter("smoking");
      if (smoking != null){
        filters.put("smoking", smoking);
      }

      String coupon = request.getParameter("coupon");
      if (coupon != null){
        filters.put("coupon", 0);
      }

      String reservation = request.getParameter("reservation");
      if (reservation != null){
        filters.put("reservation", 0);
      }

      String open = request.getParameter("open");
      if (open != null){
        filters.put("open", 0);
      }

      String min_price = request.getParameter("minprice");
      if (min_price != null){
        filters.put("min_price", min_price);
      }
      String max_price = request.getParameter("maxprice");
      if (max_price != null){
        filters.put("max_price", max_price);
      }

      ResultInfo = dummyService.ReturnData(
        Integer.parseInt(results),
        new BigDecimal(lat),
        new BigDecimal(lon),
        filters
      );

    }

		returnNode = objectMapper.valueToTree(ResultInfo);

		return returnNode;
	}

  @GetMapping("/localSearch1")
	JsonNode dummy1(HttpServletRequest request) throws Exception {

		/**
		 * データなし
		"ResultInfo" : {
			"Count" : 0,
			"Total" : 0,
			"Start" : 1,
			"Status" : 200,
			"Description" : "",
			"Copyright" : "",
			"Latency" : 0.11
		}
		 */
		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> ResultInfo = new HashMap<>();

		// -------------------------------------------------------

		Map<String, Object> ResultInfoBody = new HashMap<>();

		ResultInfoBody.put("Count", 10);
		ResultInfoBody.put("Total", 10);
		ResultInfoBody.put("Start", 10);
		ResultInfoBody.put("Status", 10);
		ResultInfoBody.put("Description", "");
		ResultInfoBody.put("Copyright", "");
		ResultInfoBody.put("Latency", 0.028);

		ResultInfo.put("ResultInfo", ResultInfoBody);

		// -------------------------------------------------------
		// -------------------------------------------------------

		Map<String, Object> Geometry = new HashMap<>();

		Geometry.put("Type", "1");
		Geometry.put("Coordinates", "2");

		// -------------------------------------------------------

		List<String> Category = new ArrayList<>();

		Category.add("1");
		// -------------------------------------------------------

		Map<String, Object> Country = new HashMap<>();

		Country.put("Code", "1");
		Country.put("Name", "2");


		// -------------------------------------------------------

		Map<String, Object> PropertyBody = new HashMap<>();

		PropertyBody.put("Uid", "1");
		PropertyBody.put("CassetteId", "1");
		PropertyBody.put("Yomi", "1");
		PropertyBody.put("Country", Country);

		PropertyBody.put("Address", "1");
		PropertyBody.put("GovernmentCode", "1");
		PropertyBody.put("AddressMatchingLevel", "1");
		PropertyBody.put("Tel1", "1");


		// -------------------------------------------------------

		Map<String, Object> FeatureBody = new HashMap<>();

		FeatureBody.put("Id", "1");
		FeatureBody.put("Gid", "2");
		FeatureBody.put("Name", "3");
		FeatureBody.put("Description", "3");
		FeatureBody.put("Geometry", Geometry);
		FeatureBody.put("Category", Category);
		FeatureBody.put("Property", PropertyBody);

		List<Map<String, Object>> FeatureBodyList = new ArrayList<Map<String, Object>>();

		FeatureBodyList.add(FeatureBody);

		ResultInfo.put("Feature", FeatureBodyList);

		// -------------------------------------------------------

		returnNode = objectMapper.valueToTree(ResultInfo);

		return returnNode;
	}

}
