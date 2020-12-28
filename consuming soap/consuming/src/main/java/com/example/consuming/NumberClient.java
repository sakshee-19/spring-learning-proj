package com.example.consuming;

import com.dataaccess.webservicesserver.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse getWords(String numbers) {
            //publicly accessible SOAP service
            String uri = "http://www.dataaccess.com/webservicesserver/numberconversion.wso";

            //set the request
            NumberToWords numberRequest = new NumberToWords();
            numberRequest.setUbiNum(new BigInteger(numbers));

            //obtain and return the response
            NumberToWordsResponse response =
                    (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri,numberRequest);

            return response;
    }

}
