import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorsShould {

	@Test
	public void return_an_empty_list_on_one() {
		assertThat(empty(factorize(1)), is(true));
	}

	@Test
	public void return_the_factor_on_a_prime() {
		assertThat(contains(factorize(2), 2), is(true));
	}

	private boolean contains(List factorize, int number) {
		return false;
	}

	private List factorize(int number) {
		return new ArrayList<Integer>();
	}

	public boolean empty(Collection o){
		return o.isEmpty();
	}
}
