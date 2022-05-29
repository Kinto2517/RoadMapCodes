package springIntro;

public class CustomerManager implements ICustomerService{
	private ICustomerDal customerDal;

	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public void add() {

		customerDal.add();

	}

}
