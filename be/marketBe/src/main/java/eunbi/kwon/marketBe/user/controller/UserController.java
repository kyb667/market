package eunbi.kwon.marketBe.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eunbi.kwon.marketBe.model.AdminInfo;
import eunbi.kwon.marketBe.user.service.AdminUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

	private final AdminUserService adminUserService;

	@GetMapping("/admin")
	JsonNode admin(HttpServletRequest request) throws Exception {

		Logger logger = Logger.getLogger("admin");

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();

		map.put("admin", 0);

		try {
			
			List<AdminInfo> adminInfoList = adminUserService.getAdminUser();

			logger.info(adminInfoList.toString());

			map.put("result", 0);

		} catch (Exception e) {
			map.put("result", 1);
		}

		returnNode = objectMapper.valueToTree(map);

		return returnNode;
	}

}
