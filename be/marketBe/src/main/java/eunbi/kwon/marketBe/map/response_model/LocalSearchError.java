package eunbi.kwon.marketBe.map.response_model;

import lombok.Data;

import eunbi.kwon.marketBe.map.response_model.LocalSearchErrorDetail;


@Data
public class LocalSearchError {
    String Message;
    LocalSearchErrorDetail Detail;
}

