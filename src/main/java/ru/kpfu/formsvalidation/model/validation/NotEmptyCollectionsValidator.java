package ru.kpfu.formsvalidation.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class NotEmptyCollectionsValidator implements ConstraintValidator<NotEmptyCollections, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (isCollection(f.get(o).getClass())) {
                    System.out.println(f.get(o).getClass() + " " + f.getName()  + " isCollection=" + isCollection(f.get(o).getClass()));
                    Collection c;
                    try {
                        c = (Collection) f.get(o);
                        c.stream().forEach(System.out::println);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException("can't get collection field " + f + " of " + o + "\n" + e.getMessage());
                    }
                    if (c.isEmpty()) {
                        System.out.println("FALSE");
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
        System.out.println("TRUE");
        return true;
    }

    private boolean isCollection(Class clazz) {
        //checking interfaces and/or superclasses recursively is too hard
//        return clazz.equals(java.util.List.class) || clazz.equals(java.util.Set.class) ||
//                clazz.equals(LinkedList.class) || clazz.equals(HashSet.class) ||
//                clazz.equals(ArrayList.class);
        return Collection.class.isAssignableFrom(clazz);
    }
}
