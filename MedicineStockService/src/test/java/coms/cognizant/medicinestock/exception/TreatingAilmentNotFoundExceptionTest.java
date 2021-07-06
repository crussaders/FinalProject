package coms.cognizant.medicinestock.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import com.cognizant.medicinestock.exception.MedicineNotFoundException;
import com.cognizant.medicinestock.exception.TreatingAilmentNotFoundException;
/* This class checks for oneargconstructor and noargsconstructor annotations */
public class TreatingAilmentNotFoundExceptionTest {

	@Mock
	private  TreatingAilmentNotFoundException treatingAilmentNotFoundException;
	/* This method checks for one argument that is error message
	 *  Input Parameters->Treating Ailment not found., Output Parameters->Treating Ailment not found.*/
	@Test
	public void testOneArgConstructor() {
		TreatingAilmentNotFoundException treatingAilmentNotFoundException = new TreatingAilmentNotFoundException("Treating Ailment not found.");
		assertEquals("Treating Ailment not found.",treatingAilmentNotFoundException.getMessage());
	}
	/* This method checks for no arguments by passing null value 
	 * Input Parameters->null, Output Parameters->null */
	@Test
	public void testNoArgsConstructor() {
		TreatingAilmentNotFoundException exception = new TreatingAilmentNotFoundException();
		assertEquals(null, exception.getMessage());
	}
}
