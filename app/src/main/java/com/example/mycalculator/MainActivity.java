package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {

    /**
     * Flag text for invalid computation
     */
    private static String ERROR_FLAG = "Error!";

    /**
     * List of symbols supported by buttons. Parallel array to symbolButtons.
     */
    String[] symbols;

    /**
     * List of buttons corresponding to each symbol is symbols
     */
    Button[] symbolButtons;
    Button equalsButton, clearButton;

    /**
     * Number display for computation results
     */
    TextView text_display;

    /**
     * Creates Activity by initializing buttons and text field
     * @param savedInstanceState Activity state variable
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parallel arrays of symbols and their respective buttons
        symbols = new String[] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "."};

        // Button IDs for numbers and operations
        int[] symbolButtonIDs = new int[] {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btn_plus, R.id.btn_minus, R.id.btn_mult, R.id.btn_div, R.id.btn_dot};

        // Initializes arrays of buttons
        symbolButtons = new Button[symbolButtonIDs.length];
        for (int i = 0; i < symbolButtons.length; i++)
            symbolButtons[i] = (Button) findViewById(symbolButtonIDs[i]);

        // Initializes other buttons and text view
        clearButton = (Button) findViewById(R.id.btn_clear);
        equalsButton = (Button) findViewById(R.id.btn_equals);
        text_display = (TextView) findViewById(R.id.textview_input_display);

        setClickListeners();
    }

    /**
     * Adds the onClickListeners for each button on the calculator
     */
    private void setClickListeners() {

        // Sets the action of symbol buttons to adding the symbol to text box
        for (int i = 0; i < symbolButtons.length; i++) {
            int index = i;
            symbolButtons[index].setOnClickListener(v -> addSymbol(symbols[index]));
        }

        // Logic for other buttons
        clearButton.setOnClickListener(v -> clear_display());
        equalsButton.setOnClickListener(v -> {
            try { text_display.setText(
                    evaluate(text_display.getText().toString()));}
            catch (RuntimeException e) {text_display.setText(ERROR_FLAG);}
        });
    }

    /**
     * Parses and evaluates an arithmetic expression string
     * @param expression The expression string
     * @return The evaluated result
     */
    private String evaluate(String expression) {
        String result = MathEval.eval(expression);
        BigDecimal decimal = new BigDecimal(result);
        return decimal.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    /**
     * Adds a symbol to the end of the text field
     * @param symbol The symbol to be added
     */
    private void addSymbol(String symbol) {
        CharSequence currentText = text_display.getText();
        if (currentText.equals(ERROR_FLAG))
            text_display.setText(symbol);
        else text_display.setText(currentText + symbol);
    }

    /**
     * Clears the display by emptying text field
     */
    private void clear_display() {
        text_display.setText("");
    }
}
