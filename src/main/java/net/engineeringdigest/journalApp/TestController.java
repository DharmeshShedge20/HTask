package net.engineeringdigest.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {  // Naming convention: Controller classes should end with "Controller"

    @GetMapping("/ok")
    public String health() {
        System.out.println("All Ok");
        return "All Ok";  // Returning a response so the client can see the result
    }
}
