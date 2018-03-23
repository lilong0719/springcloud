package com.webflux;

import com.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by ll on 2018/1/17.
 */
@RestController
@RequestMapping("/user")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @GetMapping("hello")
    public Mono<String> sayHelloWorld(){
        return Mono.just("Hello World");
    }

    @GetMapping("")
    public Flux<User> list() {
        return this.basicService.list();
    }

    @PostMapping("")
    public Flux<User> create(@RequestBody Mono<User> users) {
        return this.basicService.createOrUpdate(users);
    }
}
