package br.com.olimposistema.aipa.filtro;

import br.com.olimposistema.aipa.filtrable.IFiltrable;

import javax.persistence.TypedQuery;

public class FiltroStartPositionAndMaxResult {

	public void add(IFiltrable<?> filtrable, TypedQuery<?> tq) {
		if(filtrable != null) {
					
			if(filtrable.getStartPosition() != null && filtrable.getStartPosition() > 0) {
				tq.setFirstResult(filtrable.getStartPosition());
			}
			
			if(filtrable.getMaxResult() != null && filtrable.getMaxResult() > 0) {
				tq.setMaxResults(filtrable.getMaxResult());
			}
		}
	}
}
