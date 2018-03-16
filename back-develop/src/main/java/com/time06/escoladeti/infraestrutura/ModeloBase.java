package com.time06.escoladeti.infraestrutura;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ModeloBase {
	
	@Id
	protected String id;
	protected Date dataCadastro;
	
	public ModeloBase()
	{
		if (id == null)
		this.id = UUID.randomUUID().toString();;
		this.dataCadastro = new Date();
	}

	public String getId() {
		return id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
}