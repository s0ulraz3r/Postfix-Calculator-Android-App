package com.example.varun.calculator;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import static android.R.attr.action;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button num0Button;
    private Button num1Button;
    private Button num2Button;
    private Button num3Button;
    private Button num4Button;
    private Button num5Button;
    private Button num6Button;
    private Button num7Button;
    private Button num8Button;
    private Button num9Button;
    private Button decimalButton;
    private Button deleteButton;
    private Button addButton;
    private Button mulButton;
    private Button subButton;
    private Button divButton;
    private Button enterButton;
    private Button dropButton;

    private TextView item1TextView;
    private TextView item2TextView;
    private TextView item3TextView;
    private TextView item4TextView;
    private TextView item5TextView;

    private String value;
    private String str = "";
    private Float x, y, add, sub, mul, div;
    Deque<String> stack = new ArrayDeque<String>();
    StringBuilder t = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num0Button = (Button) findViewById(R.id.digit0);
        num1Button = (Button) findViewById(R.id.digit1);
        num2Button = (Button) findViewById(R.id.digit2);
        num3Button = (Button) findViewById(R.id.digit3);
        num4Button = (Button) findViewById(R.id.digit4);
        num5Button = (Button) findViewById(R.id.digit5);
        num6Button = (Button) findViewById(R.id.digit6);
        num7Button = (Button) findViewById(R.id.digit7);
        num8Button = (Button) findViewById(R.id.digit8);
        num9Button = (Button) findViewById(R.id.digit9);
        decimalButton = (Button) findViewById(R.id.decimalbutton);
        deleteButton = (Button) findViewById(R.id.deletebutton);
        addButton = (Button) findViewById(R.id.addbutton);
        subButton = (Button) findViewById(R.id.subbutton);
        mulButton = (Button) findViewById(R.id.mulbutton);
        divButton = (Button) findViewById(R.id.divbutton);
        enterButton = (Button) findViewById(R.id.enterbutton);
        dropButton = (Button) findViewById(R.id.dropbutton);


        item1TextView = (TextView) findViewById(R.id.item1textView);
        item2TextView = (TextView) findViewById(R.id.item2textView);
        item3TextView = (TextView) findViewById(R.id.item3textView);
        item4TextView = (TextView) findViewById(R.id.item4textView);
        item5TextView = (TextView) findViewById(R.id.item5textView);

        num0Button.setOnClickListener(this);
        num1Button.setOnClickListener(this);
        num2Button.setOnClickListener(this);
        num3Button.setOnClickListener(this);
        num4Button.setOnClickListener(this);
        num5Button.setOnClickListener(this);
        num6Button.setOnClickListener(this);
        num7Button.setOnClickListener(this);
        num8Button.setOnClickListener(this);
        num9Button.setOnClickListener(this);
        enterButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        decimalButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        dropButton.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.digit0:
                value = "0";
                stringConcat(value);
                break;

            case R.id.digit1:
                value = "1";
                stringConcat(value);
                break;

            case R.id.digit2:
                value = "2";
                stringConcat(value);
                break;

            case R.id.digit3:
                value = "3";
                stringConcat(value);
                break;

            case R.id.digit4:
                value = "4";
                stringConcat(value);
                break;

            case R.id.digit5:
                value = "5";
                stringConcat(value);
                break;

            case R.id.digit6:
                value = "6";
                stringConcat(value);
                break;

            case R.id.digit7:
                value = "7";
                stringConcat(value);
                break;

            case R.id.digit8:
                value = "8";
                stringConcat(value);
                break;

            case R.id.digit9:
                value = "9";
                stringConcat(value);
                break;

            case R.id.enterbutton:
                if (str == "") {
                    Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
                } else {
                    stack(str);
                    t.setLength(0);          //Clears the Value of String Builder "t" object
                    item5TextView.setText("");
                    decimalButton.setClickable(true);   //Enables the decimal button
                    str = "";               //Reset the str to empty to check user entered value
                    displayStackValues();
                }
                break;

            case R.id.dropbutton:
                if (stack.size() == 0){
                    Toast.makeText(this,"stack is empty",Toast.LENGTH_SHORT).show();
                }else {
                    stack.pop();
                    Log.d("stack contains", String.valueOf(stack));
                    displayStackValues();
                    Toast.makeText(this, "stack value removed", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.deletebutton:             //Works as Backspace to remove the value entered
                String s =item5TextView.getText().toString();
                if (s.length() >= 1 ) {
                    s = s.substring(0, s.length() - 1);
                    item5TextView.setText(s);
                    t.setLength(0);
                    stringConcat(s);
                }
                break;

            case R.id.decimalbutton:
                value = ".";
                decimalButton.setClickable(false);     //Disables the decimal button so user can enter use it only once in a process of entering the value
                stringConcat(value);
                break;

            case R.id.addbutton:
                if (stack.size() == 0){
                    Toast.makeText(this,"stack is empty",Toast.LENGTH_SHORT).show();
                }else {
                    Calculate();
                    add = x + y;
                    stack(String.valueOf(add));
                    Log.d("values", String.valueOf(stack));
                    displayStackValues();
                    Log.d("add", String.valueOf(add));
                }
                break;

            case R.id.subbutton:
                if (stack.size() == 0){
                    Toast.makeText(this,"stack is empty",Toast.LENGTH_SHORT).show();
                }else {
                    Calculate();
                    sub = x - y;
                    stack(String.valueOf(sub));
                    Log.d("values", String.valueOf(stack));
                    displayStackValues();
                    Log.d("sub", String.valueOf(sub));
                }
                break;

            case R.id.mulbutton:
                if (stack.size() == 0){
                    Toast.makeText(this,"stack is empty",Toast.LENGTH_SHORT).show();
                }else {
                    Calculate();
                    mul = x * y;
                    stack(String.valueOf(mul));
                    Log.d("values", String.valueOf(stack));
                    displayStackValues();
                    Log.d("mul", String.valueOf(mul));
                }
                break;

            case R.id.divbutton:
                if (stack.size() == 0){
                    Toast.makeText(this,"stack is empty",Toast.LENGTH_SHORT).show();
                }else {
                    Calculate();
                    div = x / y;
                    stack(String.valueOf(div));
                    Log.d("values", String.valueOf(stack));
                    displayStackValues();
                    Log.d("div", String.valueOf(div));
                }
                break;



        }
    }

    private void stack(String a) {    //Adds value to the stack
        stack.push(a);
        int b = stack.size();
        Log.d("size", String.valueOf(b));
        Log.d("values", String.valueOf(stack));
    }

    public void stringConcat(String val) {  //Concatenates the string values
        str = String.valueOf(t.append(val));
        Log.d("strconcat", String.valueOf(str));
        item5TextView.setText(str);
    }

    public void Calculate() {
        x = Float.valueOf(stack.pop());
        y = Float.valueOf(stack.pop());
        //stack(String.valueOf(add));
        Log.d("values", String.valueOf(stack));
        //Log.d("add", String.valueOf(add));

    }

    public void displayStackValues() {
        String stackVal;
        stackVal = String.valueOf(stack).replace("[", "").replace("]", "");
        Log.d("stackVal before",stackVal);
        List<String> myList = new ArrayList<String>(Arrays.asList(stackVal.split(",")));
        int len = myList.size();
        Log.d("Len", String.valueOf(len));
        Bundle bundle = new Bundle();
        for (int i = 0; i < myList.size(); i++){
            bundle.putSerializable("StackValue",stackVal);  //Storing Values in bundle when the activity is paused
        }
        Intent i = new Intent();
        i.putExtras(bundle);
        setResult(RESULT_OK,i);
        Log.d("bundle", String.valueOf(bundle));
        clear();
            try {
                 item4TextView.setText(myList.get(0));
                 item3TextView.setText(myList.get(1));
                 item2TextView.setText(myList.get(2));
                 item1TextView.setText(myList.get(3));
            }catch (Exception e){

            }


        }
    public void clear(){
        item4TextView.setText("");
        item3TextView.setText("");
        item2TextView.setText("");
        item1TextView.setText("");
    }


    }



