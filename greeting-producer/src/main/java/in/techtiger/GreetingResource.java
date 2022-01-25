package in.techtiger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import in.techtiger.domain.Greeting;
import io.smallrye.mutiny.Multi;

@Path("/hello")
public class GreetingResource {

    @Channel("greet-requests")
    Emitter<String> greetRequestEmitter;

    @Channel("greetings")
    Multi<Greeting> greetings;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String hello(@PathParam String name) {
        greetRequestEmitter.send(name);
        return "Hello " + name;
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Greeting> stream() {
        return greetings;
    }
}