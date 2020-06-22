package ru.kpfu.formsvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import javax.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.formsvalidation.model.CollectionTestModel;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/validator")
public class ValidatorController {
    @Autowired
    private ApplicationContext appContext;

    @GetMapping
    @ResponseBody
    public String validate() {
        List<String> one = new LinkedList<>();
        Set<String> two = new HashSet<>();
        one.add("kek");
        two.add("lol");
        Set<String> empty = new HashSet<>();
        CollectionTestModel bad = new CollectionTestModel(one,empty);
        CollectionTestModel good = new CollectionTestModel(one, two);
        Validator validator = (Validator) appContext.getBean("validator");

        return "bad = " + validator.validate(bad).isEmpty() + " | " +
                validator.validate(bad).stream().
                map(el -> el.getMessage() + "\n" + el.getPropertyPath()).
                collect(Collectors.joining("\n\n"))
                + "<br/>" + "\n" +
                "good = " + validator.validate(good).isEmpty() + " | " +
                validator.validate(good).stream().
                map(el -> el.getMessage() + "\n" + el.getPropertyPath()).
                collect(Collectors.joining("\n\n"));
    }
}
