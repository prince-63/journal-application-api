package com.learn.journal.application.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class DummyController {
    @GetMapping
    public String check() {
        return "Hello World";
    }
}
