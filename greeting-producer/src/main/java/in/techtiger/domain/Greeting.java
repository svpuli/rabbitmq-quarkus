package in.techtiger.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class Greeting {
    private String title;
    private String name;
}
