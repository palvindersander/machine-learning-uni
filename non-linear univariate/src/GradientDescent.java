import java.util.List;

public class GradientDescent {

    public static final String DATA_FILE = "data/data.csv";

    public static void main(String[] args) {

        // -------------------------------------------------
        // Data and Graph setup.
        // -------------------------------------------------
        List<List<Double>> data = Data.dataFrom(DATA_FILE);
        Plot plt = new Plot("", "x", "y", data);
        sleep(500);

        // -------------------------------------------------
        // Gradient Descent
        // -------------------------------------------------
        final int epochs = 100;  // Number of iterations we want to run through the algorithm

        // We want to predict h(x) = w1 * x + w0
        double w1 = 0;
        double w0 = 0;
        double w2 = 0;

        // Learning rate
        double alpha = .00000001;

        // Main Gradient Descent Function for Linear Regression
        for(int i = 0; i < epochs; i++) {

            double cost = 0;

            for(int j = 0; j < data.get(0).size(); j++) {

                double x_j = data.get(0).get(j);
                double y_j = data.get(1).get(j);

                double prediction =  (w1 * x_j) + w0 + (w2 * Math.pow(x_j, 2));
                // cost += (y_j - h(x))^2
                cost += (y_j - prediction) * (y_j - prediction);

                // Update the parameters for our equation.
                w1 += alpha * (y_j - prediction) * x_j;
                w2 += alpha * (y_j - prediction) * Math.pow(x_j,2);
                w0 += alpha * (y_j - prediction);


            }

            System.out.println("Current Cost: " + cost);

            final double w_1 = w1;
            final double w_0 = w0;
            final double w_2 = w2;
            HypothesisFunction h_x = (x) -> (w_2 * Math.pow(x,2)) + (w_1 * x) + w_0;

            plt.updatePlot(h_x);
        }
        System.out.println("Final Equation: h(x) = (" + w2 + " * x^2) + (" + w1 + " * x) +" + w0);
    }

    static void sleep(int ticks) {
        try{ Thread.sleep(ticks); } catch(Exception e) { e.printStackTrace(); }
    }

}


