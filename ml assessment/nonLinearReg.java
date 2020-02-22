import java.util.List;

public class nonLinearReg {
    public static void main(String[] args) {
        //init data
        double[][] data = {{-100, 9901}, {-10,91}, {-3,7}, {0,1}, 
        {1,3}, {2,7}, {3,13}, {4, 21}, {10,111}, {100,10101}};
        // Number of iterations we want to run through the algorithm
        final int epochs = 100;
        // We want to predict h(x) = (w2 * x^2) + (w1 * x) + w0
        double w1 = 0;
        double w0 = 0;
        double w2 = 0;
        // Learning rate
        double alpha = .00000001;
        // Main Gradient Descent Function for Non-Linear Regression
        for(int i = 0; i < epochs; i++) {
            //initial cost declaration
            double cost = 0;
            //iterating through data
            for(int j = 0; j < data.length; j++) {
                //getting x,y co-ords
                double x_j = data[j][0];
                double y_j = data[j][1];
                //calculating value from quadratic h(x)
                double prediction =  (w1 * x_j) + w0 + (w2 * Math.pow(x_j, 2));
                // cost += (y_j - h(x))^2
                cost += (y_j - prediction) * (y_j - prediction);
                // Update the parameters for our equation.
                w1 += alpha * (y_j - prediction) * x_j;
                w2 += alpha * (y_j - prediction) * Math.pow(x_j,2);
                w0 += alpha * (y_j - prediction);
            }
            //System.out.println("Current Cost: " + cost);
        }
        System.out.println("Final Equation: h(x) = (" + w2 + " * x^2) + (" + w1 + " * x) +" + w0);
    }
}


