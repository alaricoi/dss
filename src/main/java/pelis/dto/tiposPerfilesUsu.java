package pelis.dto;

public enum tiposPerfilesUsu {
	USER("USER"), ADMIN("ADMIN");

	private String tipoPerfil;

	private tiposPerfilesUsu(String userProfileType) {
		this.tipoPerfil = userProfileType;
	}

	public String getTipoPerfile() {
		return tipoPerfil;
	}
}
