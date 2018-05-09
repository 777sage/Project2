import com.revature.dao.TestDaoImpl;
import com.revature.model.Test;

public class TestClass {
	public static void main(String[] args) {
		Test tst1=new Test("test1","Success");
		TestDaoImpl td1 = new TestDaoImpl();
		td1.updateTest(tst1.getTestName(), tst1.getStatus());
	}
}
