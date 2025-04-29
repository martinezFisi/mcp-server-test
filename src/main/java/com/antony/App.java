package com.antony;

import java.util.logging.Logger;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public class App {

    static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        var schema = """
                    {
                        "type": "object",
                        "properties": {
                            "city": {
                                "type": "string",
                                "description": "The name of the city to query"
                            }
                        },
                        "required": ["city"]
                    }
                """;

        McpServer.sync(new StdioServerTransportProvider())
                 .serverInfo("my-server-city", "1.0.0")
                 .tool(
                         new Tool("city", "Get information about a specific city", schema),
                         (exchange, argsClient) ->  new CallToolResult("You are in: Lima", false)
                 )
                 .build();

        logger.info("Starting server...");
    }
}
