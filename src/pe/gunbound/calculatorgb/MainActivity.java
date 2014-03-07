package pe.gunbound.calculatorgb;

import pe.gunbound.calculatorgb.basedatos.bd;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.Toast;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.OnWheelScrollListener;
import antistatic.spinnerwheel.adapters.NumericWheelAdapter;


public class MainActivity extends Activity {
	private Button calculate;
	private AbstractWheel sp_distancia, sp_desnivel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new bd(getApplicationContext());
		
		sp_distancia = (AbstractWheel) findViewById(R.id.txt_distancia);
        NumericWheelAdapter distanciaAdapter = new NumericWheelAdapter(this, 0, 40, "%02d");
        distanciaAdapter.setItemResource(R.layout.wheel_text_centered_dark_back);
        distanciaAdapter.setItemTextResource(R.id.text);
        sp_distancia.setViewAdapter(distanciaAdapter);
        
        sp_desnivel = (AbstractWheel) findViewById(R.id.txt_desnivel);
        NumericWheelAdapter desnivelAdapter = new NumericWheelAdapter(this, 0, 16, "%02d");
        desnivelAdapter.setItemResource(R.layout.wheel_text_centered_dark_back);
        desnivelAdapter.setItemTextResource(R.id.text);
        sp_desnivel.setViewAdapter(desnivelAdapter);
        
        calculate = (Button) findViewById(R.id.btn_calcular);
		
		calculate.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				int distancia = sp_distancia.getCurrentItem();
				int desnivel = sp_desnivel.getCurrentItem();
				
				/*int force = 20;
				int distanciaa = Integer.parseInt(distancia.getText().toString());
				int anguloo = Integer.parseInt(angulo.getText().toString());
				
				BigDecimal res = new Formulas(getApplicationContext()).angleInRadians(16, anguloo, force, distanciaa, 2, 1);
				BigDecimal angulo = new BigDecimal( Math.toDegrees(Math.asin(res.doubleValue())));
				angulo = angulo.setScale(0,BigDecimal.ROUND_HALF_UP);
				Log.v("angulo : ",angulo+"");
				
				BigDecimal fuerza = new Formulas(getApplicationContext()).initialShotVelocity(16, anguloo, force, distanciaa, 2, 1);
				fuerza = fuerza.multiply(new BigDecimal(0.004332712));
				fuerza = fuerza.setScale(2, BigDecimal.ROUND_HALF_UP);
				Log.v("fuerza : ",fuerza+"");
				
				Toast.makeText(getApplicationContext(), "angulo : "+angulo+" - Fuerza : "+fuerza, Toast.LENGTH_LONG).show();
				
				BigDecimal pruebas = new Conversiones(getApplicationContext()).y_displacement(16);
				resultado.setText(pruebas+""); */
				Toast.makeText(getApplicationContext(), "Distancia: "+distancia+" Desnivel: "+desnivel, Toast.LENGTH_LONG).show();
			}
		});
		initWheel(R.id.passw_1);
		
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    private void initWheel(int id) {
        AbstractWheel wheel = getWheel(id);
        wheel.setViewAdapter(new NumericWheelAdapter(this, 0, 26));
        wheel.setCurrentItem(0);
        wheel.addChangingListener(changedListener);
        wheel.addScrollingListener(scrolledListener);
        wheel.setCyclic(true);
        wheel.setInterpolator(new AnticipateOvershootInterpolator());
    }
    
    // Wheel changed listener
    private OnWheelChangedListener changedListener = new OnWheelChangedListener() {
        public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
            if (!wheelScrolled) {
              //updateStatus();
            }
        }
    };
    
    // Wheel scrolled flag
    private boolean wheelScrolled = false;
    
    // Wheel scrolled listener
    OnWheelScrollListener scrolledListener = new OnWheelScrollListener() {
        public void onScrollingStarted(AbstractWheel wheel) {
            wheelScrolled = true;
        }
        public void onScrollingFinished(AbstractWheel wheel) {
            wheelScrolled = false;
           // updateStatus();
        }
    };
    
    /**
     * Returns spinnerwheel by Id
     * @param id the spinnerwheel Id
     * @return the spinnerwheel with passed Id
     */
    private AbstractWheel getWheel(int id) {
        return (AbstractWheel) findViewById(id);
    }
}
