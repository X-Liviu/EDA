package b_c_pilasYColas.EjercicioImpresora;

public class Peticion {
	Character tipoEvento; //P: impresi�n, F: finalizaci�n del trabajo, A: apag�n, S: subsanaci�n
	Integer impresora; //n�mero de impresora (solo para eventos de tipo P � F)
	Integer trabajo; //n�mero del trabajo enviado (solo para eventos de tipo P)
}
