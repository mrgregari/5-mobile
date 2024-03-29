package com.example.a5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    TextView secondFragmentTextView;
    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        secondFragmentTextView = view.findViewById(R.id.fragment_second_text_view2);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<String> Address = bundle.getStringArrayList("food&address");
            if (Address != null && Address.size() >= 1) {
                String address = Address.get(0);
                String food = Address.get(1);

                String result = "Блюдо: " + food + " по адресу " + address;

                secondFragmentTextView.setText(result);
            }
        }
    }
}
