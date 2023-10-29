package cellbox.spelinjection;


import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.tools.JavaCompiler;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FieldValidator implements ConstraintValidator<FieldMatching, String> {

    @Override
    public void initialize(FieldMatching constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        String message = String.format("Author %s is not allowed to be added. Only three authors are allowed", value);
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return false;
    }

}