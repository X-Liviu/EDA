package b_c_pilasYColas.EjercicioImpresora;

public class Peticion {
	Character tipoEvento; //P: impresión, F: finalización del trabajo, A: apagón, S: subsanación
	Integer impresora; //número de impresora (solo para eventos de tipo P ó F)
	Integer trabajo; //número del trabajo enviado (solo para eventos de tipo P)
}
