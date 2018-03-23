package com.webflux;

import com.user.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ll on 2018/1/17.
 */
@Service
public class BasicService {

    private final Map<String, User> data = new ConcurrentHashMap<>();

    public Flux<User> list() {
        return Flux.fromIterable(this.data.values());
    }



    /*Flux<User> createOrUpdate(final Mono<User> users) {
        return users.doOnNext(user -> this.data.put(user.getId(), user));
    }*/

    Mono<User> createOrUpdate(Mono<User> user) {
        this.data.put(user.getId(), user);
        return user;
    }
}
