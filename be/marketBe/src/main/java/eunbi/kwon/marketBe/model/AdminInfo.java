package eunbi.kwon.marketBe.model;

import lombok.Data;

@Data
public class AdminInfo {
    String adminId;
    String adminPassword;
    String adminName;
    String createdBy;
    String createdAt;
    String updatedBy;
    String updatedAt;
}
