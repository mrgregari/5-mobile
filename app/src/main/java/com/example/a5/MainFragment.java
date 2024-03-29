package com.example.a5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    Button mainFragmentButton;
    EditText mainFragmentEditText;
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainFragmentButton = getActivity().findViewById(R.id.fragment_main_button);
        mainFragmentEditText = getActivity().findViewById(R.id.fragment_main_edit_text);

        mainFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = mainFragmentEditText.getText().toString();
                NavController navController = Navigation.findNavController(v);

                if (!data.isEmpty()) {
                    ArrayList<String> Data =  new ArrayList<>();
                    Data.add(data);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("food",  Data);
                    navController.navigate(R.id.action_mainFragment_to_firstFragment, bundle);
                } else {
                    mainFragmentEditText.setText("");
                    mainFragmentEditText.setHint(getResources().getString(R.string.food_edit_name));
                }
            }
        });
    }
}
