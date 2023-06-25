package eunbi.kwon.marketBe.map.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eunbi.kwon.marketBe.common.Config;
import lombok.RequiredArgsConstructor;

import eunbi.kwon.marketBe.map.service.MapService;

import eunbi.kwon.marketBe.map.request_model.ReqLocalSearch;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/map/yahoo")
public class MapController {

	private final MapService mapService;
    
    private final Level LogLevel = Level.INFO;

	/**
	 * 
	 * @param localSearch
	 * @return
	 * @throws Exception
	 */
    @PostMapping("/localSearch")
	JsonNode LocalSearch(@RequestBody ReqLocalSearch localSearch) throws Exception {

		final String LogName = "map-LocalSearch";

		Logger logger = Logger.getLogger(LogName);

		logger.setLevel(LogLevel);

		logger.log(Level.INFO, LogName + " start");

		logger.log(Level.FINER, "localSearchReqData : " + localSearch.toString());

		JsonNode returnNode = null;

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();
		
		map.put("result", Config.STATE_NG);
		try {

			Integer valid = mapService.checkValid(logger, LogName, localSearch);

			if (valid.equals(Config.STATE_OK)){

				Map<String, Object> response = mapService.LocalSearch(logger, LogName, localSearch);
	
				response.put("result", Config.STATE_OK);
	
				map = response;
			}


		} catch (Exception e) {
			logger.warning(e.toString());
		}

		returnNode = objectMapper.valueToTree(map);

		logger.log(Level.INFO, LogName + " end");
		logger.log(Level.INFO, "return : " + returnNode.toString() + " end");

		return returnNode;
	}

}
