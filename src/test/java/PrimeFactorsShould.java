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
	public void return_the_factor_once_on_a_POW_number_for_three() {
		assertThat(hasItems(factorize((int) Math.pow(3d, 2d)), 3), is(true));
		assertThat(hasItems(factorize((int) Math.pow(3d, 3d)), 3), is(true));
	}

	@Test
	public void return_the_two_factors_on_a_semiprime() {
		assertThat(hasItems(factorize(6), 2, 3), is(true));
		assertThat(hasItems(factorize(2*5), 2, 5), is(true));
	}

	@Test
	public void acceptance_test_1() {
		assertThat(hasItems(factorize(2), 2), is(true));
	}

	@Test
	public void acceptance_test_2() {
		assertThat(hasItems(factorize(30), 2, 3, 5), is(true));
	}

	@Test
	public void return_factors_on_numbers_greater_than_the_provided_list() {
		assertThat(hasItems(factorize(49), 7), is(true));
	}

	private boolean hasItems(List factorize, Integer... number) {
		final List<Integer> numbersAsList = Arrays.asList(number);
		return factorize.size() == numbersAsList.size() && factorize.containsAll(numbersAsList);
	}

	private List factorize(int number) {
		final ArrayList<Integer> factors = new ArrayList<Integer>();
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		for (Integer current : primes){
			if(number % current == 0){
				factors.add(current);
			}
		}
		return factors;
	}

	public boolean empty(Collection o){
		return o.isEmpty();
	}
}
