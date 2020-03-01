import java.util.List;

public class LogisticRegression {

    public static final String DATA_FILE = "data/data1.csv";

    public static void main(String[] args) {

        // -------------------------------------------------
        // Data and Graph setup.
        // -------------------------------------------------
        List<List<Double>> data = Data.dataFrom(DATA_FILE);
        Plot plt = new Plot("", "x1", "x2", data);
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
        double alpha = .1;

        // Main Gradient Descent Function for Linear Regression
        for (int i = 0; i < epochs; i++) {

            double cost = 0;

            for (int j = 0; j < data.get(0).size(); j++) {

                double x_1 = data.get(0).get(j);
                double x_2 = data.get(1).get(j);
                double y = data.get(2).get(j);


                double prediction = sigmoid((w1 * x_1) + w0 + (w2 * x_2));

                if (y == 1) {
                    cost += -(Math.log(prediction));
                }
                if (y == 0) {
                    cost += -(1 - Math.log(prediction));
                }

                // Update the parameters for our equation.
                w1 += alpha * (y - prediction) * x_1;
                w2 += alpha * (y - prediction) * x_2;
                w0 += alpha * (y - prediction);


            }

            //System.out.println("Current Cost: " + cost);

            final double w_1 = w1;
            final double w_0 = w0;
            final double w_2 = w2;
            HypothesisFunction h_x = (x) -> (((-w_1) * x) - w_0) / w_2;

            plt.updatePlot(h_x);
        }
        System.out.println("w2 = " + w0);
        System.out.println("w1 = " + w1);
        System.out.println("w0 = " + w0);
    }

    static void sleep(int ticks) {
        try {
            Thread.sleep(ticks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

}


