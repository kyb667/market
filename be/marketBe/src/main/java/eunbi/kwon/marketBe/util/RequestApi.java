package eunbi.kwon.marketBe.util;

import java.net.URI;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestApi {

    final String LogName = "RequestApi";

    @Autowired
    private RestTemplate restClient;

    /** URL get request
     * 
     * @param logger
     * @param servieName
     * @param url
     * @param headers
     * @return
     * @throws Exception
     */
    public String sendGetRequest(Logger logger, String ParentLogName,  String servieName, String url, HttpHeaders headers) throws Exception {
        
        String LogFuncName = ParentLogName + "-" + LogName + "-sendGetRequest";

        logger.info(LogFuncName + " start");

        ResponseEntity<String> response = null;

        RequestEntity<String> req = new RequestEntity<String>(headers, HttpMethod.GET, URI.create(url));

        String res_data = null;

        response = restClient.exchange(req, String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {

            logger.info(LogFuncName + " | " +"response : " + response.getBody());

            res_data = response.getBody();
        }

        logger.info(LogFuncName + " end");

        return res_data;
    }
}
