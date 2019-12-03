package com.ez.ez_park.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ez.ez_park.MainActivity;
import com.ez.ez_park.R;
import com.ez.ez_park.ui.receipt.ReceiptAdapter;
import com.ez.ez_park.viewmodel.DBViewModel;

public class ReceiptListFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_receipt_list, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();

        DBViewModel vm = new DBViewModel(mainActivity.getApplication());

        ListView lvReceipts = root.findViewById(R.id.lvReceipts);

        ArrayAdapter receiptAdapter = new ReceiptAdapter(root.getContext(), vm.getReceiptsByUserID(mainActivity.getUserID()));

        lvReceipts.setAdapter(receiptAdapter);

        return root;
    }
}
