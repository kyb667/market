package eunbi.kwon.marketBe.user.service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import eunbi.kwon.marketBe.user.mapper.BuyerUserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuyerUserService {
    
    private final BuyerUserMapper buyerUserMapper;

    public void signIn(Logger logger, Map<String, Object> userInfo) throws Exception {

        final String LogName = "buyer-signIn-Service";

        logger.log(Level.INFO, LogName + " start");

        logger.log(Level.FINER, "userInfo : " + userInfo.toString());

        if (userInfo.get("userId").equals("") & userInfo.get("userEmail").equals("")){
            throw new Exception("userId or userEmail is required");
        }

        if (userInfo.get("userId").equals("")){
            userInfo.put("loginType", "2");
        }else{
            userInfo.put("loginType", "1");
        }

        logger.log(Level.INFO, "signin user info : " + userInfo.toString());

        buyerUserMapper.InsertBuyerInfo(userInfo);

        logger.log(Level.INFO, LogName + " end");
    }

    public Integer LogIn(Logger logger, Map<String, Object> userInfo) throws Exception {

        final String LogName = "buyer-LogIn-Service";

        logger.log(Level.INFO, LogName + " start");

        logger.log(Level.FINER, "userInfo : " + userInfo.toString());

        if (buyerUserMapper.Login(userInfo).equals(0)){
            throw new Exception("invalid");
        }else{
            logger.log(Level.INFO, "Login success");
        }

        logger.log(Level.INFO, LogName + " end");

        return 0;
    }
}
