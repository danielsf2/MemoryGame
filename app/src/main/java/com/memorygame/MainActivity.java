package com.memorygame;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;
    private Button myButtons[];
    private Integer numbers[] = {1,2,3,4,5,6};
    private List<Integer> numbersList;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void shufle(Integer[] numbers){
        Collections.shuffle(Arrays.asList(numbers));
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void initialize(){
        shufle(numbers);

        numbersList = new ArrayList<>();
        numbersList.addAll(Arrays.asList(numbers));

        btnOne = (Button) findViewById(R.id.btnOne);
        btnOne.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#2196F3");
            else
                reset(v);
        });

        btnTwo = (Button)findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#F44336");
            else
                reset(v);
        });

        btnThree = (Button)findViewById(R.id.btnThree);
        btnThree.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#305A31");
            else
                reset(v);
        });

        btnFour = (Button)findViewById(R.id.btnFour);
        btnFour.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#C6B733");
            else
                reset(v);
        });

        btnFive = (Button)findViewById(R.id.btnFive);
        btnFive.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#CCC3C3");
            else
                reset(v);
        });

        btnSix = (Button)findViewById(R.id.btnSix);
        btnSix.setOnClickListener(v -> {
            if (analiseClick(v, ((Button) v).getText().toString()))
                correctClic(v, "#494444");
            else
                reset(v);
        });

        myButtons = new Button[] {btnOne, btnTwo, btnThree, btnFour, btnFive, (Button)findViewById(R.id.btnSix)};
        myButtons.toString();
    }//void initialize

    public Boolean analiseClick(View view, String numberClick){
        if(Integer.parseInt(numberClick) == numbersList.get(0))
            return true;
        else
            return false;
    }//analiseClick

    public void correctClic(View view, String color){
        view.getRootView().setBackgroundColor(Color.parseColor(color));
        ((Button)view).setVisibility(View.INVISIBLE);

        if(numbersList.size() > 0){
            numbersList.remove(0);
            if(numbersList.size() == 0)
                Toast.makeText(MainActivity.this, "Parabéns, você ganhou!", Toast.LENGTH_LONG).show();
        }
    }//correctClic

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void btnRedefineClick(View view){
        numbers = new Integer[]{1,2,3,4,5,6};
        shufle(numbers);

        reset(view);
    }//btnRedefineClick

    public void reset(View view){
        numbersList = new ArrayList<>(Arrays.asList(numbers));

        btnOne.setVisibility(View.VISIBLE);

        for(Button button : myButtons)
            if (button != null)
                button.setVisibility(View.VISIBLE);

        view.getRootView().setBackgroundColor(Color.parseColor("#FFFFFF"));
    }//reset

}//class MainActivity