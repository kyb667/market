package eunbi.kwon.marketBe.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/signIn")
	JsonNode signIn(HttpServletRequest request,
		@RequestParam(value = "userEmail", defaultValue = "") String userEmail,  
		@RequestParam(value = "userId", defaultValue = "") String userId, 
		@RequestParam("userPw") String userPw, 
		@RequestParam(value = "userName", defaultValue = "") String userName, 
		@RequestParam("userPhone") String userPhone) throws Exception {

		final String LogName = "buyer-signIn";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		logger.log(Level.FINER, "userEmail", userEmail);
		logger.log(Level.FINER, "userId", userId);
		logger.log(Level.FINER, "userPw", userPw);
		logger.log(Level.FINER, "userName", userName);
		logger.log(Level.FINER, "userEmail", userEmail);
		logger.log(Level.FINER, "userPhone", userPhone);

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();
		
		map.put("result", 1);
		try {

			Map<String, Object> reqMap = new HashMap<>();

			reqMap.put("userEmail", userEmail);
			reqMap.put("userId", userId);
			reqMap.put("userPw", userPw);
			reqMap.put("userName", userName);
			reqMap.put("userEmail", userEmail);
			reqMap.put("userPhone", userPhone);

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
	JsonNode LogIn(HttpServletRequest request,
		@RequestParam("loginType") String loginType,
		@RequestParam(value = "userId", defaultValue = "") String userId,
		@RequestParam(value = "userEmail", defaultValue = "") String userEmail,
		@RequestParam("userPw") String userPw
	){

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> returnMap = new HashMap<>();

		final String LogName = "buyer-LogIn";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		returnMap.put("result", 1);

		try {
			
			// ID login
			if (loginType.equals("1")){

				Map<String, Object> map = new HashMap<>();

				map.put("userId", userId);
				map.put("userPw", userPw);

				Integer result = buyerUserService.LogIn(logger, map);

				returnMap.put("result", result);
				
			// email login
			}else if (loginType.equals("2")){
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

