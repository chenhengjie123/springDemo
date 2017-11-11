package hello.service;

import hello.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hengjiechen on 8/10/2017.
 */

@Component
public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public GreetingService() {
    }

    public Greeting getGreeting(String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
