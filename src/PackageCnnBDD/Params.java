package PackageCnnBDD;

public class Params {
	private String parmsValue;
	private String paramsType;
	public Params() {
		
	}
	public String getParmsValue() {
		if(paramsType.equals("str"))
			parmsValue = "'" + parmsValue + "'";
		else if(paramsType.equals("strlike"))
			parmsValue = "'%" + parmsValue + "%'";

		return parmsValue;
	}
	public void setParmsValue(String parmsValue) {
		this.parmsValue = parmsValue;
	}
	public String getParamsType() {
		return paramsType;
	}
	public void setParamsType(String paramsType) {
		this.paramsType = paramsType;
	}


}
