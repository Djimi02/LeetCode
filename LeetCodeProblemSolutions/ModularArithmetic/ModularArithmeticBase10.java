public class ModularArithmeticBase10 {

    public long modularReduction(long modulos, long a) {

        while (a > modulos) {
            a = a - modulos;
        }

        return a;
    }

    public long modularExponentiation(long modulos, long a, long exponent) {
        long iterations;
        if (exponent % 2 == 0) {
            iterations = exponent / 2;
        } else {
            iterations = exponent / 2 + 1;
        }

        for (int i = 1; i <= iterations; i++) {
            a = a * a;
            a = modularReduction(modulos, a);
        }

        return a;
    }


    public static void main(String[] args) {
        ModularArithmeticBase10 object = new ModularArithmeticBase10();

        object.exercise_test();

        // System.out.println(object.modularExponentiation(727, 414, 4));
    }

    public void exercise_test() {
        long modulos = 727l;

        for (int i = 1; i <= 1000; i++) {
            if (modularExponentiation(modulos, i, 4) == 442) {
                System.out.println(i);
            }
        }
    }
}