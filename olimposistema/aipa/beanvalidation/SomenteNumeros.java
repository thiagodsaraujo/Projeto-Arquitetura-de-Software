package br.com.olimposistema.aipa.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SomenteNumerosValidator.class)
public @interface SomenteNumeros {

	String message() default "Só é possivel passar numeros"; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
	
}
