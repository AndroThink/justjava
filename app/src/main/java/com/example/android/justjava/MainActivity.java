package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int coffeesQuantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        displayQuantity(++coffeesQuantity);
    }

    public void decrement(View view) {
        if (coffeesQuantity > 1)
            displayQuantity(--coffeesQuantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(coffeesQuantity);
       // displayPrice(coffeesQuantity * 5);
        int price = calculatePrice(coffeesQuantity,5);

        displayMessage(createOrderSummary(price));
    }

    private String createOrderSummary(int price){
        return "Name:" + getName() + "\nAdd whipped cream?"+ hasWhippedCream() +"\nHas Chocolate?" + hasChocolate() +
                "\nQuantity:" + coffeesQuantity + "\nTotal:"+NumberFormat.getCurrencyInstance().format(price) + "\nThank you!";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int qnty) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + qnty);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private boolean hasWhippedCream() {
        CheckBox checkBoxWhippedCream = (CheckBox) findViewById(R.id.checkbox_whipped);
        return checkBoxWhippedCream.isChecked();
    }

    private boolean hasChocolate() {
        CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        return checkBoxChocolate.isChecked();
    }

    private String getName() {
        EditText etName = (EditText) findViewById(R.id.et_name);
        return etName.getText().toString();
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity,int price) {
        int finalPrice = quantity * price;

        if(hasChocolate())
            finalPrice = finalPrice + 1;

        if(hasWhippedCream())
            finalPrice = finalPrice + 1;

        return finalPrice;
    }

    private int calculatePrice(int quantity) {
        int price = quantity * 5;

        if(hasChocolate())
            price = price + 1;

        if(hasWhippedCream())
            price = price + 1;

        return price;
    }

    private int calculatePrice() {
        int price = coffeesQuantity * 5;

        if(hasChocolate())
            price = price + 1;

        if(hasWhippedCream())
            price = price + 1;

        return price;
    }
}
