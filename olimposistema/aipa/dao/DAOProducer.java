package br.com.olimposistema.aipa.dao;

import br.com.olimposistema.aipa.model.Model;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public class DAOProducer {
	
	@Inject EntityManager em;

	@Produces 
	public <T extends Model> DAO<T> producer(InjectionPoint point){
		Class<T> persistedClass = extraiClassePassadaNoGenerics(point);		
		return new DAO<T>(em,persistedClass);
	}

	private <T> Class<T> extraiClassePassadaNoGenerics(InjectionPoint point) {
		ParameterizedType type = (ParameterizedType) point.getType(); // retorna um tipo dao // e converte para obtermos oque foi passado no generics
		@SuppressWarnings("unchecked")
		Class<T> persistedClass = (Class<T>) type.getActualTypeArguments()[0];
		return persistedClass;
	}
}
