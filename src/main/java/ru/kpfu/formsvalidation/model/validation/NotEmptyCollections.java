package ru.kpfu.formsvalidation.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyCollectionsValidator.class)
public @interface NotEmptyCollections {
    String message() default "object has empty collections";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
