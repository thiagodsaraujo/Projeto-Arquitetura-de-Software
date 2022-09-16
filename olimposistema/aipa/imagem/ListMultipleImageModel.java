package br.com.olimposistema.aipa.imagem;

import br.com.olimposistema.aipa.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ListMultipleImageModel extends ManipulationProperty {
	
	public ListMultipleImageModel(String nameProperty, Model model) {
		super(nameProperty,model);
	}
	
	public List<Imagem> execute(){
		try {
			
			if(super.getPropertyListImage() == null) {
				return new ArrayList<Imagem>();
			}
			return super.getPropertyListImage();
			
		}catch (Exception e) {
			throw new RuntimeException("Erro ao listar imagem no Model, erro em: ListMultipleImageModel verifique se o nome da property, seus getters/setters e o modelo passados estão corretos");
		}
	}

}
