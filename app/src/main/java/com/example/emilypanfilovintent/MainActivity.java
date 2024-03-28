package com.example.emilypanfilovintent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button plus,sub,multiplication,division,equal,delete,credits;
    EditText display;
    float result;
    String operator,str;
    Float num;
    int count;
    TextView name;
    int check;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        plus=(Button)findViewById(R.id.plus);
        sub=(Button)findViewById(R.id.sub);
        multiplication=(Button)findViewById(R.id.multiplication);
        division=(Button)findViewById(R.id.division);
        equal=(Button)findViewById(R.id.equal);
        delete=(Button)findViewById(R.id.delete);
        credits=(Button)findViewById(R.id.credits);
        display=(EditText) findViewById(R.id.display);
        name=findViewById(R.id.name);
        plus.setBackgroundColor(Color.rgb(255,130,250));
        sub.setBackgroundColor(Color.rgb(255,130,250));
        multiplication.setBackgroundColor(Color.rgb(255,130,250));
        division.setBackgroundColor(Color.rgb(255,130,250));
        delete.setBackgroundColor(Color.rgb(255,130,250));
        equal.setBackgroundColor(Color.rgb(255,130,250));
        credits.setBackgroundColor(Color.rgb(255,130,250));
        result=0;
        operator="";
        str="";
        count=0;
        check=0;
    }




    public void equal(View view) {
        if (operator.equals("+")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result += num;
        }
        if (operator.equals("-")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result -= num;
        }
        if (operator.equals("*")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result *= num;
        }
        if (operator.equals("/")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            if(num==0)
                display.setText("Error");

            else {
                result /= num;
                display.setText(result + "");
            }
        }
        else
            display.setText(result+"");

    }

    public void add(View view) {

        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("-"))
                result-=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else
                result+=num;
            operator="+";
        }

        display.setText("");
        display.getHint();

    }

    public void delete(View view) {
        count=0;
        result=0;
        operator="";
        display.setText("");
        display.getHint();
    }

    public void sub(View view) {

        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    if(operator.equals(""))
                        result=num;
                    else
                        result=Float.valueOf(-num);
                else
                    result-=num;
            }

        }

        operator="-";
        display.setText("");
        display.getHint();
    }

    public void multiplication(View view) {
        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if(operator.equals("/")){
                if(num==0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    result=num;
                else
                    result*=num;
            }

            operator="*";

        }

        display.setText("");
        display.getHint();

    }

    public void division(View view) {
        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if (operator.equals("*"))
                result*=num;
            else{
                if(count==1)
                    result=num;
                else if (num == 0)
                    display.setText("Error");
                else
                    result/=num;
            }

            operator="/";
        }

        display.setText("");
        display.getHint();

    }

    public void go(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        if(display.getText().toString().equals("Error"))
            si.putExtra("error","Error");
        else
            si.putExtra("num",result);
        startActivity(si);

    }
}