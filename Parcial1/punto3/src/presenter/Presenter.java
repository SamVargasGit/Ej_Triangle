package presenter;
import view.*;
import model.*;
    class Presenter {
        private View view;
        private Calculator mathEvaluator;

        public Presenter(View view) {
            this.view = view;
            mathEvaluator = new Calculator();
        }

        public void evaluateExpression(String expression) {
            try {
                double result = mathEvaluator.evaluateExpression(expression);
                view.showResult(result);
            } catch (Exception e) {
                view.showMessage("Error evaluating expression: " + e.getMessage());
            }
        }
}

