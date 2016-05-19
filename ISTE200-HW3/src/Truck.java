/**
 * 
 */

/**
 * @author Aurko Mallik
 *
 */
public class Truck {
	private String _Model = "";
	private String _Color = "";
	private double _Cost = 0.00;
	private int _Load = 0;
	private int _EngineSize = 0;
	public final static String[] ENGINEVAL = new String[] { "Small", "Medium", "Large"};
	public final static String[] LOADVAL = new String[] {"Half-Ton","Full-Ton"};
	
	/**
	 * @param _Model
	 * @param _Color
	 * @param _Cost
	 * @param _Load
	 * @param _EngineSize
	 */
	public Truck(String _Model, String _Color, double _Cost, int _Load,
			int _EngineSize) {
		this._Model = _Model;
		this._Color = _Color;
		this._Cost = _Cost;
		this._Load = _Load;
		this._EngineSize = _EngineSize;
	}

	/**
	 * @return the _Model
	 */
	public String get_Model() {
		return _Model;
	}

	/**
	 * @param _Model the _Model to set
	 */
	public void set_Model(String _Model) {
		this._Model = _Model;
	}

	/**
	 * @return the _Color
	 */
	public String get_Color() {
		return _Color;
	}

	/**
	 * @param _Color the _Color to set
	 */
	public void set_Color(String _Color) {
		this._Color = _Color;
	}

	/**
	 * @return the _Cost
	 */
	public double get_Cost() {
		return _Cost;
	}

	/**
	 * @param _Cost the _Cost to set
	 */
	public void set_Cost(double _Cost) {
		this._Cost = _Cost;
	}

	/**
	 * @return the _Load
	 */
	public int get_Load() {
		return _Load;
	}

	/**
	 * @param _Load the _Load to set
	 */
	public void set_Load(int _Load) {
		this._Load = _Load;
	}

	/**
	 * @return the _EngineSize
	 */
	public int get_EngineSize() {
		return _EngineSize;
	}

	/**
	 * @param _EngineSize the _EngineSize to set
	 */
	public void set_EngineSize(int _EngineSize) {
		this._EngineSize = _EngineSize;
	}

	public String toString(){
		String truckInfo = "";
		truckInfo += "Truck: "
				+ "\nModel:\t" + this._Model
				+ "\nColor:\t" + this._Color
				+ "\nCost:\t" + this._Cost
				+ "\nLoad:\t" + LOADVAL[this._Load]
				+"\nEngine:\t" + ENGINEVAL[this._EngineSize];

		return truckInfo;
	}
			

}
