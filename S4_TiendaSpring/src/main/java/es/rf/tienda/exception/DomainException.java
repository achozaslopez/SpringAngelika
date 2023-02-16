package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {

	DomainException() {

	} 

	public DomainException(String mensaje) {
		super("DomainExcepcion : " + mensaje);
	}

}
