package com.springshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by ll on 2018/1/17.
 */
@ShellComponent
public class TranslationCommands {


    @ShellMethod("Echo1")
    public String echo1(int a, int b, int c) {
        return String.format("a = %d, b = %d, c = %d", a, b, c);
    }

    @ShellMethod("Echo2")
    public String echo2(int a, @ShellOption("--boy") int b, int c) {
        return String.format("a = %d, b = %d, c = %d", a, b, c);
    }

    @ShellMethod(key = "default", value = "With default value")
    public void withDefault(@ShellOption(defaultValue = "Hello") final String value) {
        System.out.printf("Value: %s%n", value);
    }

    @ShellMethod("Echo3")
    public String echo3(@ShellOption(arity = 3) int[] numbers) {
        return String.format("a = %d, b = %d, c = %d", numbers[0], numbers[1], numbers[2]);
    }

    @ShellMethod("String size")
    public String stringSize(@Size(min = 3, max = 16) String name) {
        return String.format("Your name is %s", name);
    }
    @ShellMethod("Number range")
    public String numberRange(@Min(10) @Max(100) int number) {
        return String.format("The number is %s", number);
    }

    @ShellMethod("Result handler")
    public PrefixedResult resultHandler() {
        return new PrefixedResult("PRE", "Hello!");
    }

}
