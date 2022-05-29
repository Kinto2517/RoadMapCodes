package springIntro;

public class CustomerDal implements ICustomerDal {

	String connectionStr;
	public String getConnectionStr() {
		return connectionStr;
	}
	public void setConnectionStr(String connectionStr) {
		this.connectionStr = connectionStr;
	}
	
	@Override
	public void add() {
		System.out.println(connectionStr);
		System.out.println("Oracle Eklendi");

	}
	
	

}
