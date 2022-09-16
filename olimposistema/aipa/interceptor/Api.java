package br.com.olimposistema.aipa.interceptor;

import java.lang.annotation.*;

@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface Api {

}
