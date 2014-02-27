package pe.gunbound.calculatorgb.basedatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class bd {
	private static final String ID_DISTANCIA = "_id";
	private static final String C_TIEMPO = "tiempo";
	private static final String C_DIRECCION = "direccion";
	private static final String C_SPIN = "spin";
	private static final String C_MOVIL = "id_movil";
	private static final String C_DISTANCIA = "distancia";
	private static final String T_DISTANCIA = "distancias";

	private static final String ID_VIENTO = "_id";
	private static final String C_POSICION = "posicion";
	private static final String C_ANGULO = "angulo";
	private static final String T_VIENTO = "vientos";
	
	private static final String ID_DIRECCION = "_id";
	private static final String N_DIRECCION = "nombre";
	private static final String T_DIRECCION = "posicion";
	
	private static final String ID_MOVIL = "_id";
	private static final String C_NOMBRE = "nombre";
	private static final String C_GRAVEDAD = "gravedad";
	private static final String C_MASA = "masa";
	private static final String T_MOVIL = "moviles";

	private static final String N_BD = "calculatorgb";
	private static final int VERSION_BD = 1;

	private BDHelper nHelper;
	private final Context nContexto;
	private SQLiteDatabase nBD;
	private Cursor cursor;

	private static class BDHelper extends SQLiteOpenHelper {
		public BDHelper(Context contexto) {
			super(contexto, N_BD, null, VERSION_BD);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			// creamos la tabla vientos
			db.execSQL("CREATE TABLE " + T_VIENTO + "(" + ID_VIENTO
					+ " INTEGER PRIMARY KEY, " + C_ANGULO + " REAL, "
					+ C_POSICION + " INTEGER);");

			// creamos la tabla moviles
			db.execSQL("CREATE TABLE " + T_MOVIL + "(" + ID_MOVIL
					+ " INTEGER PRIMARY KEY, " +
					C_NOMBRE + " TEXT, "
					+ C_GRAVEDAD + " REAL, "
					+ C_MASA + " REAL); ");
			
			//creamos la tabla poscicion
			db.execSQL("CREATE TABLE " + T_DIRECCION + "(" + ID_DIRECCION
					+ " INTEGER PRIMARY KEY, "
					+ N_DIRECCION + " TEXT);");
			
			// creamos la tabla distancias
			db.execSQL("CREATE TABLE " + T_DISTANCIA + "(" + ID_DISTANCIA
					+ " INTEGER PRIMARY KEY, " + C_TIEMPO + " NUMERIC, "
					+ C_DIRECCION + " INTEGER, " 
					+ C_SPIN + " INTEGER, "
					+ C_DISTANCIA + " INTEGER, "
					+ C_MOVIL + " INTEGER);");
			
			//insertamos en la tabla vientos
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(1, 95.625, 1)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(2, 101.25, 2)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(3, 106.875, 3)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(4, 112.5, 4)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(5, 118.125, 5)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(6, 123.75, 6)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(7, 129.375, 7)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(8, 135, 8)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(9, 140.625, 9)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(10, 146.25, 10)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(11, 151.875, 11)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(12, 157.5, 12)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(13, 163.125, 13)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(14, 168.75, 14)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(15, 174.375, 15)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(16, 180, 16)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(17, 185.625, 17)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(18, 191.25, 18)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(19, 196.875, 19)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(20, 202.5, 20)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(21, 208.125, 21)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(22, 213.75, 22)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(23, 219.375, 23)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(24, 225, 24)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(25, 230.625, 25)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(26, 236.25, 26)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(27, 241.875, 27)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(28, 247.5, 28)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(29, 253.125, 29)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(30, 258.75, 30)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(31, 264.375, 31)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(32, 270, 32)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(33, 275.625, 33)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(34, 281.25, 34)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(35, 286.875, 35)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(36, 292.5, 36)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(37, 298.125, 37)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(38, 303.75, 38)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(39, 309.375, 39)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(40, 315, 40)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(41, 320.625, 41)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(42, 326.25, 42)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(43, 331.875, 43)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(44, 337.5, 44)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(45, 343.125, 45)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(46, 348.75, 46)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(47, 354.375, 47)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(48, 360, 48)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(49, 5.625, 49)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(50, 11.25, 50)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(51, 16.875, 51)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(52, 22.5, 52)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(53, 28.125, 53)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(54, 33.75, 54)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(55, 39.375, 55)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(56, 45, 56)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(57, 50.625, 57)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(58, 56.25, 58)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(59, 61.875, 59)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(60, 67.5, 60)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(61, 73.125, 61)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(62, 78.75, 62)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(63, 84.375, 63)");
			db.execSQL("INSERT INTO " + T_VIENTO + " VALUES(64, 90, 64)");
			
			
			//insertamos en la tabla moviles
			db.execSQL("INSERT INTO "
					+ T_MOVIL
					+ " VALUES(1, 'trico', 445, 0.227)");
			
			
			//posicion del bot
			db.execSQL("INSERT INTO " + T_DIRECCION + " VALUES(1, 'izquierda')");
			db.execSQL("INSERT INTO " + T_DIRECCION + " VALUES(2, 'derecha')");
			
			
			// TIENPOS DE TIROS EN WIND 0
			//2 spin >>id,tiempo,direccion,spin,distancia,movil
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(1, 2.81460439100174, 1, 2, 1, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(2, 2.76120467372942, 1, 2, 2, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(3, 2.77717822258933, 1, 2, 3, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(4, 2.70812861489267, 1, 2, 4, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(5, 2.70569045423427, 1, 2, 5, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(6, 2.77038003588784, 1, 2, 6, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(7, 2.81875773427496, 1, 2, 7, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(8, 2.72009359150821, 1, 2, 8, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(9, 2.75898274643232, 1, 2, 9, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(10, 2.68521743803042, 1, 2, 10, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(11, 2.71665884955313, 1, 2, 11, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(12, 2.65635490460174, 1, 2, 12, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(13, 2.68193745105584, 1, 2, 13, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(14, 2.62963863445928, 1, 2, 14, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(15, 2.65046397364288, 1, 2, 15, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(16, 2.6031489264266, 1, 2, 16, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(17, 2.61997942032819, 1, 2, 17, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(18, 2.576, 1, 2, 18, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(19, 2.58915975627678, 1, 2, 19, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(20, 2.54685371373743, 1, 2, 20, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(21, 2.50661575438076, 1, 2, 21, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(22, 2.46784368247957, 1, 2, 22, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(23, 2.47591189967939, 1, 2, 23, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(24, 2.43691335772205, 1, 2, 24, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(25, 2.3984467185122, 1, 2, 25, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(26, 2.40252025238709, 1, 2, 26, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(27, 2.40513858135316, 1, 2, 27, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(28, 2.36442359805732, 1, 2, 28, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(29, 2.36448222579146, 1, 2, 29, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(30, 2.36323561906765, 1, 2, 30, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(31, 2.36072736838991, 1, 2, 31, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(32, 2.31615655120521, 1, 2, 32, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(33, 2.31121675087869, 1, 2, 33, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(34, 2.30507984548643, 1, 2, 34, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(35, 2.29776587501781, 1, 2, 35, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(36, 2.28929016799139, 1, 2, 36, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(37, 2.32086807580636, 1, 2, 37, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(38, 2.31026449411425, 1, 2, 38, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(39, 2.29855285998798, 1, 2, 39, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(40, 2.2857330295303, 1, 2, 40, 1)");
			
			// 1 spin <<
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(41, 2.26894038657421, 2, 1, 1, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(42, 2.26755652337113, 2, 1, 2, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(43, 2.26524670334082, 2, 1, 3, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(44, 2.26200582717285, 2, 1, 4, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(45, 2.25782670081039, 2, 1, 5, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(46, 2.25269997930057, 2, 1, 6, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(47, 2.16714405977476, 2, 1, 7, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(48, 2.16890469733792, 2, 1, 8, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(49, 2.16770568503053, 2, 1, 9, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(50, 2.16409477235152, 2, 1, 10, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(51, 2.10751057205325, 2, 1, 11, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(52, 2.05765552487954, 2, 1, 12, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(53, 2.01194904657242, 2, 1, 13, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(54, 2.00694002223967, 2, 1, 14, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(55, 1.99947923681676, 2, 1, 15, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(56, 1.98973142459716, 2, 1, 16, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(57, 1.97780983156837, 2, 1, 17, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(58, 1.896, 2, 1, 18, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(59, 1.88071590299519, 2, 1, 19, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(60, 1.89618185255991, 2, 1, 20, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(61, 1.84371315277315, 2, 1, 21, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(62, 1.82172615443015, 2, 1, 22, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(63, 1.76516826214485, 2, 1, 23, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(64, 1.77052119144941, 2, 1, 24, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(65, 1.7739786277543, 2, 1, 25, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(66, 1.77560099971385, 2, 1, 26, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(67, 1.74157219435318, 2, 1, 27, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(68, 1.70476174023732, 2, 1, 28, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(69, 1.69996496948073, 2, 1, 29, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(70, 1.69341264109068, 2, 1, 30, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(71, 1.68511201557867, 2, 1, 31, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(72, 1.67506191515861, 2, 1, 32, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(73, 1.62522512128755, 2, 1, 33, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(74, 1.61075842286537, 2, 1, 34, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(75, 1.63427438826848, 2, 1, 35, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(76, 0, 2, 1, 36, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(77, 0, 2, 1, 37, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(78, 0, 2, 1, 38, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(79, 0, 2, 1, 39, 1)");
			db.execSQL("INSERT INTO " + T_DISTANCIA + " VALUES(80, 0, 2, 1, 40, 1)");
						
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}
	}

	public bd(Context c) {
		nContexto = c;
	}

	// metodo para abrir nuestra base de datos
	private bd abrir() throws Exception {
		nHelper = new BDHelper(nContexto);
		nBD = nHelper.getReadableDatabase();
		return this;
	}

	private void cerrar() {
		nHelper.close();
	}
	
	//datos del movil seleccionado
	//id -> id del movil
	public String[] getMovil(long id) {
		String[] datos = null;
		String sql = "SELECT  * FROM " + T_MOVIL + "  WHERE   _id =" + id ;
		
		try {
			abrir();
			cursor = nBD.rawQuery(sql, null);
			int inombre = cursor.getColumnIndex(C_NOMBRE);
			int imasa = cursor.getColumnIndex(C_MASA);
			int igravedad = cursor.getColumnIndex(C_GRAVEDAD);

			if (cursor.moveToFirst()) {
				datos = new String[]{
						cursor.getString(inombre),//0
						cursor.getString(imasa),//1
						cursor.getString(igravedad),//2
				};
			}
			cursor.close();
			cerrar();
		} catch (Exception e) {
			Toast.makeText(nContexto, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		return datos;
	}
	
	//
	public String getTiempo(long distancia, long spin, long movil, long direccion) {
		String tiempo = null;
		String sql = "SELECT  * FROM " + T_DISTANCIA + "  WHERE   distancia =" + distancia 
										+ " AND spin=" + spin
										+ " AND id_movil=" + movil
										+ " AND direccion=" + direccion;
		try {
			abrir();
			cursor = nBD.rawQuery(sql, null);
			int itiempo = cursor.getColumnIndex(C_TIEMPO);

			if (cursor.moveToFirst()) {
				tiempo = cursor.getString(itiempo); //0
			}
			cursor.close();
			cerrar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tiempo;
	}
	
	public String getAngulo(long id) {
		String angulo = null;
		String sql = "SELECT  * FROM " + T_VIENTO + "  WHERE   _id =" + id ;
		try {
			abrir();
			cursor = nBD.rawQuery(sql, null);
			int itiempo = cursor.getColumnIndex(C_ANGULO);

			if (cursor.moveToFirst()) {
				angulo = cursor.getString(itiempo); //0
			}
			cursor.close();
			cerrar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return angulo;
	}
	
}
