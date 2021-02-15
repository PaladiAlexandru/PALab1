

public class Main {
    //Adunam cifrele lui 'number' cat timp suma cifrelor este formată din mai mult de o cifră
    public static int compute(int number) {
        int sum = 0;
        int lastC;
        while (number > 9) {
            lastC = number % 10;
            sum += lastC;
            number /= 10;
            if (number < 10) {
                lastC = number % 10;
                sum += lastC;
                number = sum;
                sum = 0;
            }
        }
        return number;
    }

    //Afisam pe ecran 'Hello world!'
    public static void sayHello() {
        System.out.println("Helo world!");
    }

    //Adunam un numar intreg cu un numar binar si returnam suma intreaga
    public static int addIntWithBinary(int nrInt, String nrBinary) {
        return nrInt + Integer.parseInt(nrBinary, 2);
    }

    //Adunam un numar intreg cu un numar hexazecimal si returnam suma intreaga
    public static int addIntWithHexa(int nrInt, String nrHexa) {
        return nrInt + Integer.parseInt(nrHexa, 16);
    }

    public static void main(String[] args) {
        sayHello();

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int result;
        result = n * 3;
        result = addIntWithBinary(result, "10101");
        result = addIntWithHexa(result, "FF");
        result = result * 6;
        result = compute(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }
}
