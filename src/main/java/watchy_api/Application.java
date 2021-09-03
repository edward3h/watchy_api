package watchy_api;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.build(args)
            .mainClass(Application.class)
            .environments("local")
            .start();
    }
}
