package hello;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import hello.model.Greeting;
import hello.service.GreetingService;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by hengjiechen on 8/10/2017.
 */
public class GreetingServiceTest {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("greetingProvider", "localhost", 8080, this); //TODO: 不大明白这行在干嘛

    GreetingService greetingService = new GreetingService();

    private static Map<String, String> getHTTPHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        return headers;
    }

    @Pact(provider="greetingProvider", consumer="greetingConsumer")
    public RequestResponsePact createGreetingFragment(PactDslWithProvider builder){
        return builder
                .given("WhenNoName")
                .uponReceiving("A request without parameter name")
                    .path("/greeting")
                    .method("GET")
                .willRespondWith()
                    .headers(getHTTPHeaders())
                    .status(200)
                    .body("{\"id\":1,\"content\":\"Hello, World!\"}")
                .toPact();
    }

}
