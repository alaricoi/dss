package pelis.dto;

public enum tiposPerfilesUsu {
	  USER("USER"),
	    DBA("DBA"),
	    ADMIN("ADMIN");
	     
	    String tipoPerfil;
	     
	    private tiposPerfilesUsu(String userProfileType){
	        this.tipoPerfil = userProfileType;
	    }
	     
	    public String getTipoPerfile(){
	        return tipoPerfil;
	    }
}
