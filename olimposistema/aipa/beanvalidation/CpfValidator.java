package br.com.olimposistema.aipa.beanvalidation;

import br.com.olimposistema.aipa.service.ValidacaoService;
import com.google.common.base.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CpfValido, String> {

	@SuppressWarnings("unused")
	private String value;
	
	@Override
	public void initialize(CpfValido constraintAnnotation) {
		this.value = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(Strings.isNullOrEmpty(value)) {
			return true;
		}
		
		return ValidacaoService.validaCpf(value);
		
	}

}
