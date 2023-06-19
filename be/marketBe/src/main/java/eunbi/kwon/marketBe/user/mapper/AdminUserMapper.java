package eunbi.kwon.marketBe.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {
    
    void InsertAdminInfo(final Map<String, Object> userInfo);

    Integer Login(final Map<String, Object> userInfo);
}
