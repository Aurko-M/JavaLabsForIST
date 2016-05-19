/**
 * 
 */

/**
 * @author Aurko Mallik
 *
 */
public class Car {
	private String _Model = "";		// Vehicle Model 
	private String _Color = "";		// Vehicle Color
	private double _Cost = 0.00;	// Vehicle Cost
	private String _Type = "";		// Vehicle Type
	private int _Towing = 0;		// Towing availability 
	public final static String[] TOWVAL = new String[] {"Not Included", "Included"};
	
	/**
	 * @param _Model
	 * @param _Color
	 * @param _Cost
	 * @param _Type
	 * @param _Towing
	 */
	public Car(String _Model, String _Color, double _Cost, String _Type,
			int _Towing) {
		this._Model = _Model;
		this._Color = _Color;
		this._Cost = _Cost;
		this._Type = _Type;
		this._Towing = _Towing;
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
	 * @return the _Type
	 */
	public String get_Type() {
		return _Type;
	}
	/**
	 * @param _Type the _Type to set
	 */
	public void set_Type(String _Type) {
		this._Type = _Type;
	}
	/**
	 * @return the _Towing
	 */
	public int get_Towing() {
		return _Towing;
	}
	/**
	 * @param _Towing the _Towing to set
	 */
	public void set_Towing(int _Towing) {
		this._Towing = _Towing;
	}
	
	public String toString(){
		String carInfo = "";
		carInfo += "Car: "
				+ "\nModel:\t" + this._Model
				+ "\nColor:\t" + this._Color
				+ "\nCost:\t" + this._Cost
				+ "\nType:\t" + this._Type
				+ "\nTowing:\t" +  TOWVAL[this._Towing];

		return carInfo;
	}
	
			
}
