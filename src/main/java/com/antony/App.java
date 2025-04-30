package com.antony;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public class App {

    static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args){

        McpServer.sync(new StdioServerTransportProvider())
                 .serverInfo("yugioh-server", "1.0.0")
                 .tool(
                         new Tool("yugioh-api", "Get information about yugioh cards", YugiohSchema.SCHEMA),
                         (exchange, argsClient) ->  new CallToolResult( YugiohClient.getCardInfo(argsClient), false)
                 )
                 .build();

        logger.info("Starting server...");
    }

    static class YugiohClient{

        private static final String API_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?";

        public static String getCardInfo(Map<String, Object> argsClient) {

            var client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(10)).build();
            
            var request = HttpRequest.newBuilder().uri(URI.create(API_URL.concat(getParams(argsClient))))
                                                  .header("Content-Type", "application/json").GET()
                                                  //.timeout(Duration.ofSeconds(5))
                                                  .build();
            
            HttpResponse<String> response;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                logger.info("Error: " + e.getMessage());
                return "Error: " + e.getMessage();
            }
            
            logger.info("Status code: " + response.statusCode());
            logger.info("Headers: " + response.headers());
            return response.body();
        }

        static private String getParams(Map<String, Object> argsClient){
            
            var stringBuilder = new StringBuilder();
            for (Entry<String, Object> entry : argsClient.entrySet()) {
                if (entry.getValue() != null) {
                    stringBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                                 .append("=")
                                 .append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
                }
            }

            if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '&') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            logger.info("Params: " + stringBuilder.toString());
            return stringBuilder.toString();
        }
    }
}
