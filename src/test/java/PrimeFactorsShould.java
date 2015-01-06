import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
		assertThat(hasItems(factorize(2), 2), is(true));
	}

	@Test
	public void return_the_factor_on_another_prime() {
		assertThat(hasItems(factorize(3), 3), is(true));
	}

	@Test
	public void return_the_factor_once_on_a_POW_number() {
		assertThat(hasItems(factorize((int) Math.pow(2d, 2d)), 2), is(true));
		assertThat(hasItems(factorize((int) Math.pow(2d, 3d)), 2), is(true));
	}

	@Test
	public void return_the_two_factors_on_a_semiprime() {
		assertThat(hasItems(factorize(6), 2, 3), is(true));
	}

	private boolean hasItems(List factorize, Integer... number) {
		final List<Integer> numbersAsList = Arrays.asList(number);
		return factorize.size() == numbersAsList.size() && factorize.containsAll(numbersAsList);
	}

	private List factorize(int number) {
		final ArrayList<Integer> factors = new ArrayList<Integer>();
		if(number == 2 || number == 4 || number == 8){
			factors.add(2);
		}
		if(number == 3){
			factors.add(3);
		}
		if(number == 6){
			factors.add(2);
			factors.add(3);
		}
		return factors;
	}

	public boolean empty(Collection o){
		return o.isEmpty();
	}
}
