/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.serverless.twitterlab.twiterlab_api;

/**
 *
 * @author camrojass
 * @mail camilo.rojas@mail.escuelaing.edu.co
 */
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.twitterlab.domain.Post;
import com.serverless.twitterlab.http.ApiGatewayResponse;
import com.serverless.twitterlab.http.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Create_Post implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
            
            try {
                // get the 'body' from input
                JsonNode body = new ObjectMapper().readTree((String) input.get("body"));
                Post pst = new Post();
                pst.setComment(body.get("comment").asText());
                pst.setSender(body.get("owner").asText());


                // send the response back
                return ApiGatewayResponse.builder()
                        .setStatusCode(200)
                        .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                        .build();

            }   catch (JsonProcessingException ex) {
                    logger.error("Error in saving thread: " + ex);
                    // send the error response back
                    Response responseBody = new Response("Error in saving thread: ", input);
                    return ApiGatewayResponse.builder()
                            .setStatusCode(500)
                            .setObjectBody(responseBody)
                            .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                            .build();
        }
    }
}