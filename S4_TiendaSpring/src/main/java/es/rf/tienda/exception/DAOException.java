package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DAOException extends Exception {

		DAOException() {

		}

		public DAOException(String mensaje) {
			super("DAOExcepcion : " + mensaje);
		

	}

}
