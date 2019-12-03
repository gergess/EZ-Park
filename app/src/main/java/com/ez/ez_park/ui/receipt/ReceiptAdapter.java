package com.ez.ez_park.ui.receipt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ez.ez_park.MainActivity;
import com.ez.ez_park.R;
import com.ez.ez_park.model.Receipt;

import java.util.ArrayList;

public class ReceiptAdapter extends ArrayAdapter {

    Context context;

    public ReceiptAdapter(@NonNull Context context, ArrayList<Receipt> receipts) {
        super(context, 0, receipts);
        this.context= context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.receipt_item, parent, false);
        }

        TextView tvReceiptNum = convertView.findViewById(R.id.tvReceiptNum);
        TextView tvTotal = convertView.findViewById(R.id.tvTotal);
        TextView tvDate = convertView.findViewById(R.id.tvDate);

        final Receipt receipt = (Receipt) getItem(position);

        tvReceiptNum.setText((int) receipt.getReceiptNum());
        tvTotal.setText("$"+ receipt.getCost());
        tvDate.setText(receipt.getDateTime());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).showReceiptDetail(receipt.getReceiptNum());
            }
        });


        return convertView;
    }
}
