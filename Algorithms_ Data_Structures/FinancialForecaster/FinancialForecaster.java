public class FinancialForecaster {

    public static double predictValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + growthRate) * predictValueRecursive(presentValue, growthRate, years - 1);
    }

    public static double predictValueOptimized(double presentValue, double growthRate, int years) {
        double totalGrowth = 1.0;
        double base = 1 + growthRate;

        while (years > 0) {
            if (years % 2 == 1) {
                totalGrowth *= base;
            }
            base *= base;
            years /= 2;
        }
        return presentValue * totalGrowth;
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualRate = 0.07; 
        int targetYears = 10;

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Growth Rate: " + (annualRate * 100) + "% per year");
        System.out.println("Duration: " + targetYears + " years\n");

        double recursiveResult = predictValueRecursive(initialInvestment, annualRate, targetYears);
        System.out.printf("Recursive Forecast Value: $%.2f%n", recursiveResult);

        double optimizedResult = predictValueOptimized(initialInvestment, annualRate, targetYears);
        System.out.printf("Optimized (Iterative) Forecast Value: $%.2f%n", optimizedResult);
    }
}