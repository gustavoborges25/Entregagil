package com.time06.escoladeti.anuncio_lance.command_event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AceitarLanceCommand {
	
	private String idLance;
    private String idPessoa;

    public AceitarLanceCommand(
            @JsonProperty("idLance") String idLance,
            @JsonProperty("idPessoa") String idPessoa) {
        this.idLance = idLance;
        this.idPessoa = idPessoa;
    }

	public String getIdLance() {
		return idLance;
	}

	public String getIdPessoa() {
		return idPessoa;
	}
}
