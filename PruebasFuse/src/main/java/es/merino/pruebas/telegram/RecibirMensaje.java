package es.merino.pruebas.telegram;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.telegram.model.IncomingMessage;
import org.apache.camel.component.telegram.model.OutgoingTextMessage;
import org.apache.camel.component.telegram.model.User;

public class RecibirMensaje implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		IncomingMessage mensaje = exchange.getIn().getBody(IncomingMessage.class);
		User  user = mensaje.getFrom();
		String texto = mensaje.getText();
		
		
		String textoSalida = "";
		if (texto!= null && texto.startsWith("/escala")) {
			textoSalida  = devolverDatosEsalaca(user, texto);
		} else {
			textoSalida = "Hola " + user.getFirstName() + ", que has querido decir con '" + texto + "'";
		}
		
		
		OutgoingTextMessage mensajeOut = new OutgoingTextMessage();
		mensajeOut.setReplyToMessageId(mensaje.getMessageId());
		mensajeOut.setText(textoSalida);
        exchange.getIn().setBody(mensajeOut);
		
	}

	private String devolverDatosEsalaca(User user, String texto) {
		String datosEscala = "";
		// Validar Usuario
		if (usuarioDeLaEscala() ) {
			String[] mensaje = texto.split(" ");
			if (mensaje.length > 1) {
				String escala = mensaje[1];
				datosEscala  = devolverDatosEscala(escala);
			}
		}
		return datosEscala;
		
	}

	private String devolverDatosEscala(String escala) {
		return "la escala esta fuera de puerto";
		
	}

	private boolean usuarioDeLaEscala() {
		return true;
	}

}
