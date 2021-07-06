package coms.cognizant.medicinestock.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

import com.cognizant.medicinestock.exception.MedicineNotFoundException;

/* This class checks for oneargconstructor and noargsconstructor annotations */
public class MedicineNotFoundExceptionTest {
	@Mock
	private MedicineNotFoundException medicineNotFoundException;
 /* This method checks for one argument that is error message
  * Input Parameters->Medicine not found., Output Parameters->Medicine not found. */
	@Test
	public void testOneArgConstructor() {
		MedicineNotFoundException medicineNotFoundException = new MedicineNotFoundException("Medicine not found.");
		assertEquals("Medicine not found.", medicineNotFoundException.getMessage());
	}
	/* This method checks for no arguments by passing null value
	 * Input Parameters->null, Output Parameters->null */
	@Test
	public void testNoArgsConstructor() {
		MedicineNotFoundException exception = new MedicineNotFoundException();
		assertEquals(null, exception.getMessage());
	}
}
