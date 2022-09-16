package br.com.olimposistema.aipa.anexo;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

import javax.inject.Inject;

public class SalvaAnexo {
	
	@Inject private GeradorPath geradorPath;

	
	public void salvaAnexo(UploadedFile file) {
		SalvaArquivoNoDisco salvaArquivoNoDisco = new SalvaArquivoNoDisco(file, this.geradorPath.geraPath(file.getFileName()));
		salvaArquivoNoDisco.salvaArquivo();
	}
}
