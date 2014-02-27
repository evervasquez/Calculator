package pe.gunbound.calculatorgb;

import java.math.BigDecimal;

import pe.gunbound.calculatorgb.basedatos.bd;
import pe.gunbound.calculatorgb.operaciones.Conversiones;
import pe.gunbound.calculatorgb.operaciones.Formulas;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView resultado;
	private Button calculate;
	private EditText angulo,distancia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new bd(getApplicationContext());
		
		calculate = (Button) findViewById(R.id.btn_calcular);
		resultado = (TextView) findViewById(R.id.lb_respuesta);
		angulo = (EditText) findViewById(R.id.txt_angulo);
		distancia = (EditText) findViewById(R.id.txt_distancia);
		
		calculate.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int force = 20;
				int distanciaa = Integer.parseInt(distancia.getText().toString());
				int anguloo = Integer.parseInt(angulo.getText().toString());
				
				BigDecimal res = new Formulas(getApplicationContext()).angleInRadians(0, anguloo, force, distanciaa, 2, 1);
				BigDecimal angulo = new BigDecimal( Math.toDegrees(Math.asin(res.doubleValue())));
				angulo = angulo.setScale(0,BigDecimal.ROUND_HALF_UP);
				Log.v("angulo : ",angulo+"");
				
				BigDecimal fuerza = new Formulas(getApplicationContext()).initialShotVelocity(0, anguloo, force, distanciaa, 2, 1);
				fuerza = fuerza.multiply(new BigDecimal(0.004332712));
				Log.v("fuerza : ",fuerza.setScale(2, BigDecimal.ROUND_HALF_UP)+"");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
