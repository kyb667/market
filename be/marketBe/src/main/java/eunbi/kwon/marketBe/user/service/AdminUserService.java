package eunbi.kwon.marketBe.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eunbi.kwon.marketBe.model.AdminInfo;
import eunbi.kwon.marketBe.user.mapper.AdminUserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminUserService {
    
    private final AdminUserMapper adminUserMapper;

    public List<AdminInfo> getAdminUser(){
        return adminUserMapper.selectAdminInfo();
    }
}
