package eunbi.kwon.marketBe.user.service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import eunbi.kwon.marketBe.common.Config;
import eunbi.kwon.marketBe.user.mapper.AdminUserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminUserService {
    
    private final AdminUserMapper adminUserMapper;

    public void signIn(Logger logger, Map<String, Object> userInfo) throws Exception {

        final String LogName = "admin-signIn-Service";

        logger.log(Level.INFO, LogName + " start");

        logger.log(Level.FINER, "userInfo : " + userInfo.toString());

        adminUserMapper.InsertAdminInfo(userInfo);

        logger.log(Level.INFO, LogName + " end");
    }

    public Integer LogIn(Logger logger, Map<String, Object> userInfo) throws Exception {

        final String LogName = "admin-LogIn-Service";

        logger.log(Level.INFO, LogName + " start");

        logger.log(Level.FINER, "userInfo : " + userInfo.toString());

        if (adminUserMapper.Login(userInfo).equals(0)){
            throw new Exception("invalid");
        }else{
            logger.log(Level.INFO, "Login success");
        }

        logger.log(Level.INFO, LogName + " end");

        return Config.STATE_OK;
    }
}
