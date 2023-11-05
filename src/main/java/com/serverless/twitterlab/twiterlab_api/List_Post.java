/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serverless.twitterlab.twiterlab_api;

/**
 *
 * @author camrojass
 * @mail camilo.rojas@mail.escuelaing.edu.co
 */

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.serverless.twitterlab.domain.Post;
import com.serverless.twitterlab.http.ApiGatewayResponse;
import com.serverless.twitterlab.http.Response;


import java.util.Collections;
import java.util.Map;
import java.util.List;

public class List_Post implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        try {
            List<Post> posts = new Post().list();

            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(posts)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                    .build();
        } catch (Exception ex) {
            Response responseBody = new Response("Error in getting Posts ......" + ex, input);
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setObjectBody(responseBody)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                    .build();
        }
    }
}
