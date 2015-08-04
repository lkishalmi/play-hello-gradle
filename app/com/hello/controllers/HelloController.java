package com.hello.controllers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Basic controller to return 'Hello World!'.
 *
 */
public class HelloController extends Controller {

    public static final String HELLO_WORLD = "Hello World!";

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * Create HelloWorld.
     *
     * @return {@link Result} which is contains the 'Hello World' in a JsonNode.
     */
    public Result sayHello() {

        LOGGER.info(HELLO_WORLD);

        final Map<String, String> messageMap = new HashMap<>();
        messageMap.put("value", HELLO_WORLD);
        final JsonNode jsonHello = Json.toJson(messageMap);

        return ok(jsonHello);
    }
}
