package coms.cognizant.medicinestock.exception;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import com.cognizant.medicinestock.exception.TokenValidationFailedException;
/* This class checks for oneargconstructor and noargsconstructor annotations */
public class TokenValidationFailedExceptionTest {
	@Mock
	private TokenValidationFailedException tokenValidationFailedException;
	/* This method checks for one argument that is error message
	 *  Input Parameters->Token validation failed., Output Parameters->Token validation failed.*/
	@Test
	public void testOneArgConstructor() {
		TokenValidationFailedException medicineNotFoundException = new TokenValidationFailedException(
				"Token validation failed.");
		assertEquals("Token validation failed.", medicineNotFoundException.getMessage());
	}
	/* This method checks for no arguments by passing null value
	 * Input Parameters->null, Output Parameters->null  */
	@Test
	public void testNoArgsConstructor() {
		TokenValidationFailedException exception = new TokenValidationFailedException();
		assertEquals(null, exception.getMessage());
	}
}
