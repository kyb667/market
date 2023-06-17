package eunbi.kwon.marketBe.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eunbi.kwon.marketBe.model.AdminInfo;

@Mapper
public interface AdminUserMapper {
    
    List<AdminInfo> selectAdminInfo();
}
