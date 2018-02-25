package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        String beginText ="Total: ";
        String endText ="\nThank You!";

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(beginText + NumberFormat.getCurrencyInstance().format(number) + endText);
    }

    /**
     * This method adds 1 to the current value of numberOfCoffees with each call
     */
    public void addQty(View view){
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method subtracts 1 from the current value of numberOfCoffees with each call
     */
    public void subtractQty(View view){
        numberOfCoffees = numberOfCoffees - 1;
        if (numberOfCoffees <= 0){
            Toast.makeText(getApplicationContext(), "You cannot have less than 0 coffees!", Toast.LENGTH_LONG).show();
            numberOfCoffees = 0;
        }
        display(numberOfCoffees);
    }
}