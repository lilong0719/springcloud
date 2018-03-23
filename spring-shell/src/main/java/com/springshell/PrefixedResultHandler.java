package com.springshell;

import org.springframework.shell.ResultHandler;
import org.springframework.stereotype.Component;

/**
 * Created by ll on 2018/1/18.
 */
@Component
public class PrefixedResultHandler implements ResultHandler<PrefixedResult> {

    @Override
    public void handleResult(PrefixedResult result) {
        System.out.printf("%s --> %s%n", result.getPrefix(), result.getResult());
    }
}
