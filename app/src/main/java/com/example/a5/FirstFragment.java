package com.example.a5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    Button firstFragmentButton;
    EditText firstFragmnetEditText;
    TextView firstFragmentTextView;
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        ArrayList<String> Food = bundle.getStringArrayList("food");
        String food = Food.get(0).toString();

        firstFragmentButton = getActivity().findViewById(R.id.fragment_first_button);
        firstFragmnetEditText = getActivity().findViewById(R.id.fragment_first_edit_text);
        firstFragmentTextView = getActivity().findViewById(R.id.fragment_first_text_view2);
        firstFragmentTextView.setText(food);
        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = firstFragmnetEditText.getText().toString();

                if (!address.isEmpty()) {
                    ArrayList<String> Address =  new ArrayList<>();
                    Address.add(address);
                    Address.add(food);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("food&address", Address);
                    Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
                } else {
                    firstFragmnetEditText.setText("");
                    firstFragmnetEditText.setHint(getResources().getString(R.string.address_edit));
                }
            }
        });
    }
}
