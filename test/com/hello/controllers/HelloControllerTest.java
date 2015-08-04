package com.hello.controllers;

import static org.junit.Assert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static play.mvc.Results.ok;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Result;
import com.fasterxml.jackson.databind.JsonNode;
import com.shazam.shazamcrest.matcher.CustomisableMatcher;

public class HelloControllerTest {

    private HelloController underTest;

    @Before
    public void init() {
        underTest = new HelloController();
    }

    @Test
    public void sayHelloShouldReturnHelloWorld() {
        // given
        final Map<String, String> messageMap = new HashMap<>();
        messageMap.put("value", "Hello World!");
        final JsonNode jsonHello = Json.toJson(messageMap);
        final Result expectedResult = ok(jsonHello);
        // when
        final Result result = underTest.sayHello();
        // then
        assertResultsAreEquals(expectedResult, result);
    }

    private static void assertResultsAreEquals(final Result expectedResult, final Result result) {

        final CustomisableMatcher<Result> expectedMatcher = sameBeanAs(expectedResult);
        assertThat(result, expectedMatcher);
    }
}
