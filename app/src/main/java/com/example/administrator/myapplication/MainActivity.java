package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

/*
在layout中定义的控件，想要用代码控制的时候，必须现在java中绑定，绑定步骤：
1、定义一个成员变量
2、在oncreate（）方法中使用findViewByiD（）方法，将布局文件中的控件绑定到java代码中。
3、按钮的点击事件（见课件）

tips：
实现字符串的运算的步骤：
1、将点击按钮的字符添加到字符串末尾
2、点击等于的时候，实现字符串的切割，切割的点即运算符所在位置
3、将切割的字符串转换成double类型
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private  String string="";
    private TextView tv;
    private  Button button_9;
    private  Button button_8;
    private  Button button_7;
    private  Button button_6;
    private  Button button_5;
    private  Button button_4;
    private  Button button_3;
    private  Button button_2;
    private  Button button_1;
    private  Button button_0;
    private Button button_add;
    private Button button_sub;
    private Button button_mul;
    private Button button_div;
    private Button button_equal;
    private  Button button_sweep;
    private Button button_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0=(Button)findViewById(R.id.button0);
        button_1=(Button)findViewById(R.id.button1);
        button_2=(Button)findViewById(R.id.button2);
        button_3=(Button)findViewById(R.id.button3);
        button_4=(Button)findViewById(R.id.button4);
        button_5=(Button)findViewById(R.id.button5);
        button_6=(Button)findViewById(R.id.button6);
        button_7=(Button)findViewById(R.id.button7);
        button_8=(Button)findViewById(R.id.button8);
        button_9=(Button) findViewById(R.id.button9);

        button_add=(Button)findViewById(R.id.button_add);
        button_sub=(Button)findViewById(R.id.button_sub);
        button_mul=(Button)findViewById(R.id.button_mul);
        button_div=(Button)findViewById(R.id.button_div);
        button_equal=(Button)findViewById(R.id.button_equal);
        button_sweep=(Button)findViewById(R.id.button_sweep);
        button_dot=(Button)findViewById(R.id.button_dot);

        tv=(TextView)findViewById(R.id.textView);


        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_mul.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_sweep.setOnClickListener(this);
        button_dot.setOnClickListener(this);
    }
public double getResult() {
    String s=string;
    String remain=s;
    double sum=0;
    if (string.contains("+")) {
        while(true){
            int startIndex=remain.indexOf("+");
            int end=remain.length();
            String left=remain.substring(0,startIndex);
            System.out.println("left"+left);
            double b=Double.valueOf(left);
            remain=remain.substring(startIndex+1, end);
            System.out.println("remain"+remain);
            sum=sum+b;
            System.out.println("sum is "+sum);
            if(!remain.contains("+")){
                sum=sum+Double.valueOf(remain);
                System.out.println("sum is "+sum);
                break;
            }
        }
    }
    else if(string.contains("-")){

        while(true){
            int startIndex=remain.indexOf("-");
            int end=remain.length();
            String left=remain.substring(0,startIndex);
            System.out.println("left"+left);
            double b=Double.valueOf(left);
            remain=remain.substring(startIndex+1, end);
            System.out.println("remain"+remain);
            sum=b-sum;
            System.out.println("sum is"+sum);
            if(!remain.contains("-")){
                sum=sum-Double.valueOf(remain);
                System.out.println("sum is "+sum);
                break;
            }
        }
    }
    else if(string.contains("*")){
        double m=1;
        while(true){
            int startIndex=remain.indexOf("*");
            int end=remain.length();
            String left=remain.substring(0,startIndex);
            System.out.println("left"+left);
            double b=Double.valueOf(left);
            remain=remain.substring(startIndex+1, end);
            System.out.println("remain"+remain);
            m=m*b;
            System.out.println("sum is "+sum);
            if(!remain.contains("*")){
                m=m*Double.valueOf(remain);
                sum=m;
                System.out.println("sum is "+sum);
                break;
            }
        }
    }
    else if(string.contains("/")){
        String left4 = string.substring(0, string.indexOf("/"));
        String right4 = string.substring(string.indexOf("/") + 1);
        double le4 = Double.valueOf(left4);
        double ri4 = Double.valueOf(right4);
        sum=le4/ri4;
    }
    return sum;
}

    public String Restart(){
        return string="";
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:

            case R.id.button_add:
            case R.id.button_sub:
            case R.id.button_mul:
            case R.id.button_div:
            case R.id.button_dot:
                string=string+((Button)v).getText();
                tv.setText(string);
                break;
            case R.id.button_equal:
                tv.setText(getResult()+"");
                break;
            case R.id.button_sweep:
                tv.setText(Restart()+"");
                break;
        }

    }

}
