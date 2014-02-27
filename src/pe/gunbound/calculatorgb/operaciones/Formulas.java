package pe.gunbound.calculatorgb.operaciones;

import java.math.BigDecimal;
import java.math.MathContext;

import pe.gunbound.calculatorgb.basedatos.bd;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Formulas {
	private Conversiones conversiones;
	private bd conn = null;
	private Context context;
	private String tiempo;

	public Formulas(Context contexto) {
		context = contexto;
	}

	/*
	 * desnivel = aplicado al desnivel del campo entre el inicio y el objetivo
	 * angle = angulo de la fuerza del viento force = fuerza del viento
	 * (numeros) distancia = distancia desde el inicio al objetivo spin = tipo
	 * de tiro 2,3,4 o 5 vueltas 1 = 2 spin 2 = 3 spin direccion = direccion del
	 * carro tirador
	 */
	public BigDecimal initialVerticalVelocity(int desnivel, int angle,
			int force, int distancia, int spin, int direccion) {
		conversiones = new Conversiones(context);
		BigDecimal viy = null;
		BigDecimal ydisplacement = conversiones.y_displacement(desnivel);
		BigDecimal yA = conversiones.yA(angle, force, distancia);
		try {
			conn = new bd(context);
			tiempo = conn
					.getTiempo(distancia, spin, Variables.TRICO, direccion);
			BigDecimal time = new BigDecimal(tiempo);
			BigDecimal elevado = time.pow(2);
			viy = yA.multiply(elevado).multiply(new BigDecimal(0.5));
			viy = viy.add(ydisplacement);
			viy = viy.divide(time,MathContext.DECIMAL64);
			
			conn = null;
		} catch (Exception e) {
			Toast.makeText(context, "Hubo un Error al recuperar los datos + initialVerticalVelocity",
					Toast.LENGTH_SHORT).show();
		}
		return viy;
	}

	public BigDecimal initialHorizontalVelocity(int angle, int force,
			int distancia, int spin, int direccion) {
		conversiones = new Conversiones(context);
		BigDecimal vix = null;
		BigDecimal time = null;
		BigDecimal xdisplacement = conversiones.x_displacement(distancia);
		BigDecimal xA = conversiones.xA(angle, force);
		try {
			conn = new bd(context);
			tiempo = conn
					.getTiempo(distancia, spin, Variables.TRICO, direccion);
			time = new BigDecimal(tiempo);
			BigDecimal elevado = time.pow(2);

			if (xA.compareTo(BigDecimal.ZERO) == 0) {
				vix = xdisplacement;
			} else {
				vix = xA.multiply(elevado).multiply(new BigDecimal(0.5));
				vix = xdisplacement.subtract(vix);
			}
			vix = vix.divide(time,MathContext.DECIMAL64);
		} catch (Exception e) {
			Toast.makeText(context, "Hubo un Error al recuperar los datos message= "+e.getMessage(),
					Toast.LENGTH_SHORT).show();
		}
		return vix;
	}

	public BigDecimal initialShotVelocity(int desnivel, int angle, int force,
			int distancia, int spin, int direccion) {

		BigDecimal viy = initialVerticalVelocity(desnivel, angle, force,
				distancia, spin, direccion);
		BigDecimal vix = initialHorizontalVelocity(angle, force, distancia,
				spin, direccion);

		viy = viy.pow(2);
		vix = vix.pow(2);
		
		BigDecimal bii = viy.add(vix);
		viy = new BigDecimal (Math.sqrt(bii.doubleValue()));
		return viy;
	}

	public BigDecimal angleInRadians(int desnivel, int angle, int force,
			int distancia, int spin, int direccion) {
		BigDecimal viy = initialVerticalVelocity(desnivel, angle, force,
				distancia, spin, direccion);
		BigDecimal isv = initialShotVelocity(desnivel, angle, force, distancia,
				spin, direccion);
		BigDecimal resultado = viy.divide(isv,MathContext.DECIMAL64);
		return resultado;
	}
	
	public BigDecimal TangenteAngleInRadians(int desnivel, int angle, int force,
			int distancia, int spin, int direccion) {
		BigDecimal viy = initialVerticalVelocity(desnivel, angle, force,
				distancia, spin, direccion);
		BigDecimal isv = initialShotVelocity(desnivel, angle, force, distancia,
				spin, direccion);
		BigDecimal resultado = viy.divide(isv,MathContext.DECIMAL64);
		return resultado;
	}

}
