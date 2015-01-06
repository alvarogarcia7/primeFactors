import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorsShould {

	@Test
	public void return_an_empty_list_on_one() {
		assertThat(empty(factorize(1)), is(true));
	}

	private Object factorize(int number) {
		return null;
	}

	public boolean empty(Object o){
		return false;
	}
}
