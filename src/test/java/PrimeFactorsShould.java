import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorsShould {

	private static final int MIN_PRIME = 2;

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
	public void return_the_factor_on_a_big_prime() {
		assertThat(hasItems(factorize(97), 97), is(true));
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
		assertThat(hasItems(factorize(490000), 7, 2, 5), is(true));
	}

	private boolean hasItems(List factorize, Integer... number) {
		final List<Integer> numbersAsList = Arrays.asList(number);
		return factorize.size() == numbersAsList.size() && factorize.containsAll(numbersAsList);
	}

	private List factorize(int number) {
		List<Integer> primes = getPrimesUpTo(number);

		return factorizeIn(number, primes);
	}

	private List<Integer> getPrimesUpTo(int number) {
		final List<Integer> candidates = new ArrayList<>();
		for (int i = MIN_PRIME; i <= 2 + Math.sqrt(number); i++) {
			candidates.add(i);
		}
		if(!candidates.contains(number) && number >= MIN_PRIME) {
			candidates.add(number);
		}

		List<Integer> primes = new ArrayList<>();
		for (Integer current : candidates) {
			if(hasOnlyOnePrimeFactorIn(current, candidates)){
				primes.add(current);
			}
		}
		return primes;
	}

	private List<Integer> factorizeIn(int number, List<Integer> minimumBlocks) {
		List<Integer> factors = new ArrayList<>();

		for (Integer current : minimumBlocks){
			if(number % current == 0){
				factors.add(current);
			}
		}
		return factors;
	}

	private boolean hasOnlyOnePrimeFactorIn(Integer number, List<Integer> candidates) {
		List<Integer> factors = factorizeIn(number, candidates);
		return factors.size() == 1;
	}

	public boolean empty(Collection o){
		return o.isEmpty();
	}
}
