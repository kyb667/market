package eunbi.kwon.marketBe.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eunbi.kwon.marketBe.user.service.BuyerUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/user/buyer")
public class BuyerController {

	private final BuyerUserService buyerUserService;

	private final Level LogLevel = Level.INFO;

	@Data
    private static class SignInReqData {
        private String userEmail;
		private String userId;
		private String userPw;
		private String userName;
		private String userPhone;
    }

	@Data
    private static class LoginReqData {
        private String loginType;
		private String userEmail;
		private String userId;
		private String userPw;
    }

	@PostMapping("/signIn")
	JsonNode signIn(@RequestBody SignInReqData signInReqData) throws Exception {

		final String LogName = "buyer-signIn";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		logger.log(Level.FINER, "signInReqData : " + signInReqData.toString());

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();
		
		map.put("result", 1);
		try {

			Map<String, Object> reqMap = new HashMap<>();

			reqMap.put("userEmail", signInReqData.userEmail);
			reqMap.put("userId", signInReqData.userId);
			reqMap.put("userPw", signInReqData.userPw);
			reqMap.put("userName", signInReqData.userName);
			reqMap.put("userEmail", signInReqData.userEmail);
			reqMap.put("userPhone", signInReqData.userPhone);

			buyerUserService.signIn(logger, reqMap);

			map.put("result", 0);

		} catch (Exception e) {
			logger.warning(e.toString());
		}

		returnNode = objectMapper.valueToTree(map);

		logger.log(Level.INFO, LogName + " end");
		logger.log(Level.INFO, "return : " + returnNode.toString() + " end");

		return returnNode;
	}

	@PostMapping("/logIn")
	JsonNode LogIn(@RequestBody LoginReqData loginReqData){

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		final String LogName = "buyer-LogIn";
		
		Logger logger = Logger.getLogger(LogName);
		
		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		logger.log(Level.FINER, "loginReqData : " + loginReqData.toString());

		Map<String, Object> returnMap = new HashMap<>();

		returnMap.put("result", 1);

		try {
			
			// ID login
			if (loginReqData.loginType.equals("1")){

				Map<String, Object> map = new HashMap<>();

				map.put("userId", loginReqData.userId);
				map.put("userPw", loginReqData.userPw);

				Integer result = buyerUserService.LogIn(logger, map);

				returnMap.put("result", result);
				
			// email login
			}else if (loginReqData.loginType.equals("2")){
				// TODO
				returnMap.put("result", 0);
			}
		} catch (Exception e) {
			logger.warning(e.toString());
		}

		returnNode = objectMapper.valueToTree(returnMap);

		logger.log(Level.INFO, LogName + " end");
		logger.log(Level.INFO, "return : " + returnNode.toString() + " end");

		return returnNode;
	}
}

