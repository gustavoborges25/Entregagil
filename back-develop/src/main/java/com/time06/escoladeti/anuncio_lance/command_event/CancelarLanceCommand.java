package com.time06.escoladeti.anuncio_lance.command_event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CancelarLanceCommand {

	private String idLance;
    private String idPessoa;

    public CancelarLanceCommand(
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
