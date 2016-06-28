package Problem6PlanckConstant;

public class PlanckConstant {

    public static void main(String[] args) {
        System.out.println(Calculation.reducedPlankConstant());
    }
}

class Calculation {
    static double planksConstant = 6.62606896e-34;
    static double pi = 3.14159;

    static double reducedPlankConstant() {
        return planksConstant / (2 * pi);
    }
}
