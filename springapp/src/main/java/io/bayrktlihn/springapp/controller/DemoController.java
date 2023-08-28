package io.bayrktlihn.springapp.controller;

import io.bayrktlihn.springapp.exception.UserNotFoundException;
import io.bayrktlihn.springapp.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demos")
@RequiredArgsConstructor
public class DemoController {

    private final TranslateService translateService;


    @GetMapping
    public String demo() {
        return translateService.instant("hello");
    }

    @GetMapping("user")
    public String notFoundUser() {
        throw new UserNotFoundException("user_not_found", new Object[]{"alihan"});
    }


}
