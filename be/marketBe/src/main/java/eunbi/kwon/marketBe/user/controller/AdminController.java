package eunbi.kwon.marketBe.user.controller;

import java.util.HashMap;
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

import eunbi.kwon.marketBe.user.service.AdminUserService;
import lombok.RequiredArgsConstructor;

import eunbi.kwon.marketBe.common.Config;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/user/admin")
public class AdminController {

	private final AdminUserService adminUserService;

	private final Level LogLevel = Level.INFO;

	@PostMapping("/signin")
	JsonNode signin(HttpServletRequest request,
		@RequestParam("adminId") String adminId, 
		@RequestParam("adminPw") String adminPw, 
		@RequestParam("adminName") String adminName) throws Exception {

		final String LogName = "admin-signIn";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		logger.log(Level.FINER, "adminId", adminId);
		logger.log(Level.FINER, "adminPw", adminPw);
		logger.log(Level.FINER, "adminName", adminName);

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();

		map.put("result", Config.STATE_NG);

		try {
			Map<String, Object> reqMap = new HashMap<>();

			reqMap.put("adminId", adminId);
			reqMap.put("adminPw", adminPw);
			reqMap.put("adminName", adminName);

			adminUserService.signIn(logger, reqMap);

			map.put("result", Config.STATE_OK);

		} catch (Exception e) {
			logger.warning(e.toString());
		}

		returnNode = objectMapper.valueToTree(map);

		return returnNode;
	}

	@PostMapping("/logIn")
	JsonNode LogIn(HttpServletRequest request,
		@RequestParam("adminId") String adminId, 
		@RequestParam("adminPw") String adminPw
	){

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> returnMap = new HashMap<>();

		final String LogName = "admin-LogIn";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		returnMap.put("result", Config.STATE_NG);

		try {
			Map<String, Object> reqMap = new HashMap<>();

			reqMap.put("adminId", adminId);
			reqMap.put("adminPw", adminPw);

			Integer result = adminUserService.LogIn(logger, reqMap);

			returnMap.put("result", result);

		} catch (Exception e) {
			logger.warning(e.toString());
		}

		returnNode = objectMapper.valueToTree(returnMap);

		logger.log(Level.INFO, LogName + " end");
		logger.log(Level.INFO, "return : " + returnNode.toString() + " end");

		return returnNode;
	}

}
