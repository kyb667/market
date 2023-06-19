package eunbi.kwon.marketBe.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BuyerInfo {
    String buyerEmail;
    String buyerId;
    String buyerPassword;
    String buyerLoginType;
    String buyerName;
    String buyerPhone;
    String createdBy;
    LocalDateTime createdAt;
    String updatedBy;
    LocalDateTime updatedAt;
}
