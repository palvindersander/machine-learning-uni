public class solution2 {
    public static void main(String[] args) {
        //init data
        double[][] data = {{1, 1, 0}, {2, 2, 0}, {0.3, 1.2, 0},
                {0.6, 0.8, 0}, {1.2, 1, 0}, {1.3, 1, 0}, {1.8, 2, 0},
                {1.5, 1.4, 0}, {3, 3, 1}, {4, 4, 1}, {3.1, 3.3, 1}, {3.6, 3.8, 1},
                {3.8, 2.1, 1}, {3.5, 2.2, 1}, {3.25, 2.8, 1}};
        // Number of iterations we want to run through the algorithm
        final int epochs = 100;
        // We want to predict h(x) = (w2 * x2) + (w1 * x1) + w0
        double w1 = 0;
        double w0 = 0;
        double w2 = 0;
        // Learning rate
        double alpha = .1;
        // Main  Function for Logistic Regression
        for (int i = 0; i < epochs; i++) {
            //initial cost declaration
            double cost = 0;
            //iterating through data
            for (int j = 0; j < data.length; j++) {
                //getting x1,x2,y data
                double x_1 = data[j][0];
                double x_2 = data[j][1];
                double y = data[j][2];
                //calculating value from h(x)
                double prediction = sigmoid((w1 * x_1) + w0 + (w2 * x_2));
                // cost based on class
                if (y == 1) {
                    cost += -(Math.log(prediction));
                    //cost increment output
                    System.out.println(-(Math.log(prediction)));
                }
                if (y == 0) {
                    cost += -(1 - Math.log(prediction));
                    //cost increment output
                    System.out.println(-(1 - Math.log(prediction)));
                }
                // Update the parameters for our equation.
                w1 += alpha * (y - prediction) * x_1;
                w2 += alpha * (y - prediction) * x_2;
                w0 += alpha * (y - prediction);
            }
        }
        System.out.println("w2 = " + w0);
        System.out.println("w1 = " + w1);
        System.out.println("w0 = " + w0);
    }
    static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }
}


