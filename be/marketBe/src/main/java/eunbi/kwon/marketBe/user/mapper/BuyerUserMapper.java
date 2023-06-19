package eunbi.kwon.marketBe.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyerUserMapper {
    
    void InsertBuyerInfo(final Map<String, Object> userInfo);

    Integer Login(final Map<String, Object> userInfo);
}
