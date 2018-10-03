import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.normal.samples.DataService;
import com.normal.samples.SomeImpl;

public class SomeImplTest {

	@Test
	public void getGreatest_test() {
		DataService dS = mock(DataService.class);
		when(dS.retrieveAll()).thenReturn(new Integer[]{24,34,56});
		SomeImpl someImpl = new SomeImpl(dS);
		assertTrue(56 == someImpl.getGreatest());
	}

}
