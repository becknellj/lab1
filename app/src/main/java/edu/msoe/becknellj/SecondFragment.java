package edu.msoe.becknellj;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.image_second);

        //used rating bar documentation from AhbiAndroid rating bar example, inspired design in submit button listener
        RatingBar bar = view.findViewById(R.id.ratingBar);
        Button submit_button = view.findViewById(R.id.submit_button);
        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                submit_button.setBackgroundColor(Color.RED);
            }


        }
        );

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num = bar.getRating();

                if(num<3){
                    Snackbar.make(view, num+" rating: Sorry you did not enjoy the app, please give feedback so we can improve", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if(num==3 || num==3.5){
                    Snackbar.make(view, num+" rating: Thank you for rating, please give feedback so we can improve", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(view, num+" rating: I am glad you enjoyed the app", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

                bar.setRating(0);
                submit_button.setBackgroundColor(Color.LTGRAY);
            }
        });

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);

                Snackbar.make(view, "Congratulations, you made it to the first fragment", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}