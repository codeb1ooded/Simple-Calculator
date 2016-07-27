package com.example.megha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    int b1Id, b2Id, b3Id, b4Id, b5Id, b6Id, b7Id, b8Id, b9Id, b0Id;
    Button bPlus, bMinus, bMultiply, bDivide, bClear, bEqual, bPeriod;
    int bPlusId, bMinusId, bMultiplyId, bDivideId, bClearId, bEqualId, bPeriodId;
    TextView tv;

    double value1, value2, result;
    boolean opPlus, opMinus, opMultiply, opDivide, opEqual, opPeriod;
    char lastOp= ' ' ;
    int afterPeriod;
    double digit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1 = value2 = result =0;

        opPlus = opMinus = opMultiply = opDivide = opEqual = opPeriod = false;
        afterPeriod = 0;
        digit = -1;

        tv = (TextView) findViewById(R.id.viewText);
        b0 = (Button) findViewById(R.id.button0);
        b0.setOnClickListener(this);
        b0Id= b0.getId();
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b1Id= b1.getId();
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b2Id= b2.getId();
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b3Id= b3.getId();
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b4Id= b4.getId();
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b5Id= b5.getId();
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b6Id= b6.getId();
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b7Id= b7.getId();
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b8Id= b8.getId();
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);
        b9Id= b9.getId();

        bPlus = (Button) findViewById(R.id.buttonPlus);
        bPlus.setOnClickListener(this);
        bPlusId = bPlus.getId();
        bMinus = (Button) findViewById(R.id.buttonMinus);
        bMinus.setOnClickListener(this);
        bMinusId = bMinus.getId();
        bMultiply = (Button) findViewById(R.id.buttonMultiply);
        bMultiply.setOnClickListener(this);
        bMultiplyId = bMultiply.getId();
        bDivide = (Button) findViewById(R.id.buttonDivide);
        bDivide.setOnClickListener(this);
        bDivideId = bDivide.getId();
        bEqual = (Button) findViewById(R.id.buttonEqual);
        bEqual.setOnClickListener(this);
        bEqualId = bEqual.getId();
        bPeriod = (Button) findViewById(R.id.buttonPeriod);
        bPeriod.setOnClickListener(this);
        bPeriodId = bPeriod.getId();
        bClear = (Button) findViewById(R.id.buttonClear);
        bClear.setOnClickListener(this);
        bClearId = bClear.getId();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id==b0Id || id==b1Id || id==b2Id || id==b3Id || id==b4Id || id==b5Id || id==b6Id || id==b7Id || id==b8Id || id==b9Id){
            changeMyText(id);
            numberClicked();
        }
        else if(id == bPeriodId){
            tv.setText(tv.getText() + ".");
            opPeriod = true;
        }
        else if(id == bClearId){
            tv.setText("");
            value1 = value2 = result =0;
            opPlus = opMinus = opMultiply = opDivide = opEqual = opPeriod = false;
            afterPeriod = 0;
            lastOp = ' ';
            digit = -1;
        }
        else{
            afterPeriod = 0;
            opPeriod = false;
            if(id == bPlusId || id == bMinusId || id == bMultiplyId || id == bDivideId){
                tv.setText("");
                if(lastOp == ' ');
                else if(lastOp == '='){
                    value1 = result;
                    value2 = result = 0;
                }
                else{
                    getResult();
                    value1 = result;
                    value2 = result = 0;
                }
                if(id == bPlusId)       lastOp = '+';
                if(id == bMinusId)      lastOp = '-';
                if(id == bMultiplyId)   lastOp = '*';
                if(id == bDivideId)     lastOp = '/';
            }
            else{
                if(lastOp != ' '){
                    getResult();
                    tv.setText(""+result);
                    lastOp = '=';
                }
            }
        }
    }

    void getResult(){
        if(lastOp == '+'){
            result = value1 + value2;
        }
        else if(lastOp == '-'){
            result = value1 - value2;
        }
        else if(lastOp == '*'){
            result = value1 * value2;
        }
        else if(lastOp == '/'){
            result = value1 / value2;
        }
    }

    void changeMyText(int id){
        if(id == b0Id) {
            digit = 0;
            tv.setText(tv.getText() + "0");
        }
        if(id == b1Id){
            digit = 1;
            tv.setText(tv.getText() + "1");
        }
        if(id == b2Id){
            digit = 2;
            tv.setText(tv.getText() + "2");
        }
        if(id == b3Id){
            digit = 3;
            tv.setText(tv.getText() + "3");
        }
        if(id == b4Id){
            digit = 4;
            tv.setText(tv.getText() + "4");
        }
        if(id == b5Id){
            digit = 5;
            tv.setText(tv.getText() + "5");
        }
        if(id == b6Id){
            digit = 6;
            tv.setText(tv.getText() + "6");
        }
        if(id == b7Id){
            digit = 7;
            tv.setText(tv.getText() + "7");
        }
        if(id == b8Id){
            digit = 8;
            tv.setText(tv.getText() + "8");
        }
        if(id == b9Id){
            digit = 9;
            tv.setText(tv.getText() + "9");
        }
    }

    void numberClicked(){
        if(lastOp == ' '){
            if(!opPeriod)   value1 = value1*10 + digit;
            else            value1 = value1 + digit * Math.pow(10, --afterPeriod);
        }
        else {
            if (!opPeriod) value2 = value2 * 10 + digit;
            else value2 = value2 + digit * Math.pow(10, --afterPeriod);
        }
    }
}
