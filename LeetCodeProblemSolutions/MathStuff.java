import java.util.ArrayList;
import java.util.List;

public class MathStuff {
    public static long power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("power: negative argument");
        }
        // 0 <= a && 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    public static class Power { // BEGIN RECORD TYPE

        /** The base. */
        public int base;

        /** The exponent. */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base     the base
         * @param exponent the exponent
         * @pre {@code 0 <= base && 0 <= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    }

    public static long power(Power p) throws IllegalArgumentException {
        return power(p.base, p.exponent);
    }

    // AUXILIRY METHODS

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    private List<Power> factorize(int n) {
        int num = n;

        // find the devisors
        List<Integer> usedDevisors = new ArrayList<>();

        int devisor = 2;
        if (n == 2 || n == 3) {
            usedDevisors.add(n);
        }
        while (num != 1) {
            if (n / 2 < devisor) {
                usedDevisors.add(n);
                break;
            }

            if (num % devisor == 0) {
                num = num / devisor;
                usedDevisors.add(devisor);
            } else {
                devisor++;
            }
        }
        System.out.println(usedDevisors.toString());

        // factorize
        List<Power> factors = new ArrayList<>();
        factors.add(new Power(usedDevisors.get(0), 1));
        for (int i = 1; i < usedDevisors.size(); i++) {
            if (usedDevisors.get(i) == factors.get(factors.size() - 1).base) {
                factors.get(factors.size() - 1).exponent++;
            } else {
                factors.add(new Power(usedDevisors.get(i), 1));
            }
        }

        // print factors for testing
        for (Power power : factors) {
            System.out.println("Factor: " + power.base + "^" + power.exponent);
        }

        return factors;
    }

    private int findGcdInAListOfPowers(List<Power> factors) {
        if (factors.size() == 1) {
            return factors.get(0).exponent;
        }

        int gcd = factors.get(0).exponent;
        for (int i = 1; i < factors.size(); i++) {
            gcd = gcd(gcd, factors.get(i).exponent);
        }

        return gcd;
    }

    private Power createFinalPower(List<Power> factors, int gcdOfExponents) {
        int finalBase = 1;
        for (Power power : factors) {
            power.exponent = power.exponent / gcdOfExponents;
            finalBase *= power(power);
        }

        Power output = new Power(finalBase, gcdOfExponents);

        return output;
    }

    public static Power powerize(int n) throws IllegalArgumentException {
        if (n < 2) {
            throw new IllegalArgumentException("Method powerize accepts input n >= 2.");
        }

        MathStuff math = new MathStuff();

        // factorize n
        List<Power> factors = math.factorize(n);

        // find the gcd of the exponentials of the factors
        int gcdOfExponents = math.findGcdInAListOfPowers(factors);
        System.out.println(gcdOfExponents);

        // create the final power
        Power finalOutput = math.createFinalPower(factors, gcdOfExponents);

        return finalOutput;
    }

    public static void main(String[] args) {
        Power p = powerize(4);
        System.out.println("Final power: " + p.base + "^" + p.exponent);
    }
}
