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

        // object.exercise_1();
        object.exercise_2();

    }

    public void exercise_1() {
        long modulos = 11584115749l;
        long a = 23;
        long exponent = 17;

        System.out.println(modularExponentiation(modulos, a, exponent));
    }

    public void exercise_2() {
        long modulos = 443507;
        long a = 64649;
        long exponent = 241187;

        System.out.println(modularExponentiation(modulos, a, exponent));
    }
}