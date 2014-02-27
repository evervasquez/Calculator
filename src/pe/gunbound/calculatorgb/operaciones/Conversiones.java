package pe.gunbound.calculatorgb.operaciones;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import pe.gunbound.calculatorgb.basedatos.bd;
import android.content.Context;
import android.widget.Toast;

public class Conversiones {
	private bd conn = null;
	private Context context;
	private String[] dataBD;
	
	public Conversiones(Context contexto) {
		// TODO Auto-generated constructor stub
		context = contexto;
	}
	// convertimos el desplazamiento de x en pixeles
	public BigDecimal x_displacement(int distancia) {
		BigDecimal xdisplacement = null;
		xdisplacement = new BigDecimal(distancia).divide(new BigDecimal(20),MathContext.DECIMAL64);
		xdisplacement = xdisplacement.multiply(Variables.WIDTH,MathContext.DECIMAL64);
		return xdisplacement;
	}

	// convertimos el desplazamiento de y en pixeles
	public BigDecimal y_displacement(int desnivel) {
		BigDecimal ydisplacement = null;
		ydisplacement = new BigDecimal(desnivel).divide(new BigDecimal(16),MathContext.DECIMAL64);
		ydisplacement = ydisplacement.multiply(Variables.HEIGH);
		return ydisplacement;
	}
	
	//funcion para redondear
	public static double Redondear(double numero, int digitos) {
		int cifras = (int) Math.pow(10, digitos);
		return Math.rint(numero * cifras) / cifras;
	}
	
	//angle es el angulo de la resistencia del viento
	public double takeCoseno(int angle) {
		double inRadianes = 0;
		try {
			conn = new bd(context);
			String angulo = conn.getAngulo(angle);
			BigDecimal radianes = new BigDecimal(Math.toRadians(Double.parseDouble(angulo)));
			inRadianes = Redondear(Math.cos(radianes.doubleValue()),14);
		} catch (Exception e) {
			Toast.makeText(context,
					"Hubo un Error al recuperarlos los datos + takeCoseno", Toast.LENGTH_SHORT)
					.show();
		}
		return inRadianes;
	}

	public double takeSeno(int angle) {
		double inRadianes = 0;
		try {
			conn = new bd(context);
			String angulo = conn.getAngulo(angle);
			BigDecimal radianes = new BigDecimal(Math.toRadians(Double.parseDouble(angulo)));
			inRadianes = Redondear(Math.sin(radianes.doubleValue()),14);
		} catch (Exception e) {
			Toast.makeText(context,
					"Hubo un Error al recuperarlos los datos + takeSeno", Toast.LENGTH_SHORT)
					.show();
		}
		return inRadianes;
	}
	
	public BigDecimal xForce(int angle, int force){
		BigDecimal takecoseno = new BigDecimal(takeCoseno(angle));
		takecoseno = takecoseno.multiply(new BigDecimal(force));
		if(takecoseno.equals(-0)){
			takecoseno = new BigDecimal(0);
		}
		return takecoseno;
	}
	
	public BigDecimal yForce(int angle, int force){
		BigDecimal takeseno = new BigDecimal(takeSeno(angle));
		takeseno = takeseno.multiply(new BigDecimal(force));
		if(takeseno.equals(-0)){
			takeseno = new BigDecimal(0);
		}
		return takeseno;
	}
	
	//xA
	public BigDecimal xA(int angle, int force){
		BigDecimal xforce = xForce(angle,force);
		BigDecimal xA = null;
		try {
			conn = new bd(context);
			dataBD = conn.getMovil(Variables.TRICO);
			BigDecimal masa = new BigDecimal(Double.parseDouble(dataBD[1]));
			xA = xforce.divide(masa,MathContext.DECIMAL64);
			dataBD = null;
			conn = null;
		} catch (Exception e) {
			Toast.makeText(context,
					"Hubo un Error al recuperarlos los datos + xA", Toast.LENGTH_SHORT)
					.show();
		}
		
		return xA;
	}
	
	//yA
	public BigDecimal yA(int angle, int force, int distancia){
		BigDecimal yforce = yForce(angle,force);
		BigDecimal xA1 = null;
		try {
			conn = new bd(context);
			dataBD = conn.getMovil(Variables.TRICO);
			
			BigDecimal masa =  new BigDecimal(Double.parseDouble(dataBD[1]));
			BigDecimal gravedad = new BigDecimal(Double.parseDouble(dataBD[2]));
			xA1 = yforce.divide(masa,MathContext.DECIMAL64);
			xA1 = gravedad.subtract(xA1);
			
		} catch (Exception e) {
			Toast.makeText(context,
					"Hubo un Error al recuperar los datos + yA", Toast.LENGTH_SHORT)
					.show();
		}
		
		return xA1;
	}
	
	public String getRaizBigDecimal(BigDecimal numero, int precision) {

        BigDecimal bigNumero = numero;
        BigDecimal raiz = BigDecimal.ONE;
        BigDecimal raizTemp = null;

        if (bigNumero.compareTo(BigDecimal.ZERO) < 1) {
                System.err.println("ERROR : No se puede obtener raices negativas");
                return "0";
        }

        for (int i = 0; i < precision; i++) {
                // Se guarda el valor temporal de la raiz para operar mas adelante
                raizTemp = raiz;

                // Factor a = (raiz^2 - 2)
                raiz = raiz.pow(2).subtract(bigNumero);
                // Factor b = Factor a / (2 * raiz)
                // Aqui se utiliza RoundingMode.HALF_UP, para evitar valores
                // infinitos y la excepcion generada en tiempo de ejecucion
                // "Non-terminating decimal expansion no exact representable
                // decimal result" y 10 decimales
                raiz = raiz.divide(raizTemp.multiply(BigDecimal.valueOf(2)), 10,RoundingMode.HALF_UP);
                // raiz - Factor b
                raiz = raizTemp.subtract(raiz);
        }

        return raiz.toString();
}
}
