package br.com.olimposistema.aipa.dao.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Usada para marcar o FIELD que representa o start 
 * position para trazer o resultado da consulta
 * @author Tiago Luz
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface FiltrableStartPosition {

}
