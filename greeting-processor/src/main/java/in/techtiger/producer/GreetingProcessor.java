package in.techtiger.producer;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import in.techtiger.domain.Greeting;
import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class GreetingProcessor {

    @Incoming("requests")
    @Outgoing("greetings")
    @Blocking
    public Greeting process(String greetRequest) throws InterruptedException {
        // simulate some hard-working task
        System.out.println("greetRequest:"+greetRequest);
        Thread.sleep(1000);
        return new Greeting("Hello", "Puli");
    }
}
