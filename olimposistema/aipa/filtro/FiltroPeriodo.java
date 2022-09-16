package br.com.olimposistema.aipa.filtro;

import br.com.olimposistema.aipa.filtrable.Periodo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Calendar;
import java.util.List;

public class FiltroPeriodo {
	public void add(List<Predicate> predicates, CriteriaBuilder cb, Path<Calendar> pathDate,
			Periodo periodo) {
		if(periodo.getDataInicial() != null) {
			Predicate maiorOuIgualQueDataInicial = cb.greaterThanOrEqualTo(pathDate, periodo.getDataInicial());
			predicates.add(maiorOuIgualQueDataInicial);
		}
		if(periodo.getDataFinal() != null) {
			Predicate menorOuIgualQueDataFinal = cb.lessThanOrEqualTo(pathDate, periodo.getDataFinal());
			predicates.add(menorOuIgualQueDataFinal);
		}	
	}
}
