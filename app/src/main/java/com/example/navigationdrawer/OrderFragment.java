
package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class OrderFragment extends Fragment {



    private EditText editTextItem1, editTextItem2, editTextItem3, editTextItem4;
    private TextView textViewTotal;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        editTextItem1 = view.findViewById(R.id.editTextItem1);
        editTextItem2 = view.findViewById(R.id.editTextItem2);
        editTextItem3 = view.findViewById(R.id.editTextItem3);
        editTextItem4 = view.findViewById(R.id.editTextItem4);
        textViewTotal = view.findViewById(R.id.textViewTotal);

        Button buttonPlaceOrder = view.findViewById(R.id.buttonPlaceOrder);
        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotal();
                showToast("Congratulations your order is on the way");


            }
        });



        return view;
    }

    private void calculateTotal() {
        String quantityItem1Text = editTextItem1.getText().toString();
        String quantityItem2Text = editTextItem2.getText().toString();
        String quantityItem3Text = editTextItem3.getText().toString();
        String quantityItem4Text = editTextItem4.getText().toString();

        int quantityItem1 = quantityItem1Text.isEmpty() ? 0 : Integer.parseInt(quantityItem1Text);
        int quantityItem2 = quantityItem2Text.isEmpty() ? 0 : Integer.parseInt(quantityItem2Text);
        int quantityItem3 = quantityItem3Text.isEmpty() ? 0 : Integer.parseInt(quantityItem3Text);
        int quantityItem4 = quantityItem4Text.isEmpty() ? 0 : Integer.parseInt(quantityItem4Text);

        int total = 0;

        if (quantityItem1 > 0) {
            total += quantityItem1 * 70;
        }

        if (quantityItem2 > 0) {
            total += quantityItem2 * 90;
        }

        if (quantityItem3 > 0) {
            total += quantityItem3 * 80;
        }

        if (quantityItem4 > 0) {
            total += quantityItem4 * 60;
        }
        textViewTotal.setText("Total: $" + total);
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }



}