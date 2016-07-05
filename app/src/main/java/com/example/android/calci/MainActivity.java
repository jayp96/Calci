package com.example.android.calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.StringCharacterIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String insert ="";
    public float totpow1, totsub1, totmul1=0,totdiv1;
    public int sum=0,multiply=0,subtract=0,divide=0,power=0;
    public float tot,tot1,tot2,tot3,tot4,tot5;
    public float sub,sub1,sub2,sub3,sub4,sub5;
    public float mul,mul1,mul2,mul3,mul4,mul5;
    public float div,div1,div2,div3,div4,div5;


    public char op = '#';

    //to display the number
    public void display(String number) {
        TextView t = (TextView) findViewById(R.id.disp_total_no);
        t.setText(number);
    }

    //to reset the number
    public void reset()
    {
        insert = "";

        op = '#';
        display(insert);
    }
    // to be used when the syntx in cacli will be wrong
    public void error( ) {
        TextView t = (TextView) findViewById(R.id.disp_total_no);
        t.setText("SYNTAX ERROR");
    }
    public void plus (View view)
    {   if(insert.equals("")) {
        insert = "0";
    }
    else {
        insert = insert + "+";
        op = '+';
        display(insert);

    }
        sum++;


    }
    public void clr (View view)
    {
        insert ="";

        display(insert);
    }
    public void subtract (View view){
        if((insert.equals("")))
            insert ="0";

        insert = insert +"-";

        op = '-';


        display(insert);
        subtract++;
        //TextView textView = (TextView) findViewById(R.id.no_minus);
        //display("-");
    }
    public void multiplication (View view){
        if(insert.equals(""))
            insert ="0";

        insert = insert +"X";

        op = '*';
        display(insert);
        multiply++;


    }
    public void division (View view){
        if(insert.equals(""))
            insert ="0";

        insert = insert +"/";
        display(insert);
        op = '/';
        divide++;
    }

    public void dec ( View view) {
        TextView t = (TextView) findViewById(R.id.decimal);
        if (op == '.') {
            reset();
        } else {
            op='.';
            insert = insert + ".";
            display(insert);
        }
    }


    public void no_0(View view) {
        insert = insert + "0";
        display(insert);
    }

    public void no_1(View view) {
        insert = insert + "1";
        display(insert);
    }

    public void no_2 (View view) {
        insert = insert + "2";
        display(insert);
    }
    public void no_3 (View view) {
        insert = insert + "3";
        display(insert);

    }

    public void no_4 (View view) {
        insert = insert + "4";
        display(insert);
    }
    public void no_5 (View view) {
        insert = insert + "5";
        display(insert);
    }
    public void no_6 (View view) {
        insert = insert + "6";
        display(insert);
    }
    public void no_7 (View view) {
        insert = insert + "7";
        display(insert);
    }
    public void no_8 (View view) {
        insert = insert + "8";

        display(insert);
    }
    public void no_9 (View view) {
        insert = insert + "9";

        display(insert);
    }
    public void two0(View view){
        insert = insert +"00";
        display(insert);
    }
    //for deleting the last character but it crashes when insert="" :(
    public void del (View view) {
        insert = removeLastChar(insert);
        op='#';

        TextView textView = (TextView) findViewById(R.id.no_del);
        display(insert);

    }
    //called by del function
    public String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length()-1);
    }
    public void power (View view){

        insert = insert +"^";
        op='^';
        display(insert);
        power++;
    }
    /**public void dis(String n)
     {

     TextView t = (TextView) findViewById(R.id.disp_total_no);
     //t.setText(n);
     t.append(n);

     }**/

    public void equal (View view) {

        if ( (insert.equals("")))
        {
            display("0");

            return;}
        else if((insert.endsWith("+"))||(insert.endsWith("/"))||(insert.endsWith("-"))||(insert.endsWith("X"))||(insert.endsWith("^"))){
            error();
        }
     /**   else if(){
            Pattern pattern = Pattern.compile("[+-/*^]");
            Matcher matcher = pattern.matcher(insert);
            if (matcher.find()) {
                // contains special characters

            } else {
                // doesn't contain special characters
            }
        }
      **/
        else {
            switch (op) {
                case '+':
if(insert.contains("+")) {
    String[] parts = insert.split("\\+");
    String part1 = parts[0];
    String part2 = parts[1];
    float num1 = Float.parseFloat(part1);
    float num2 = Float.parseFloat(part2);
    if (parts.length == 2) { tot1 = num1 + num2; String msg = Float.toString(tot1); display(msg);}
    else if (parts.length == 3) { String part3 = parts[2]; float num3 = Float.parseFloat(part3); tot = tot1 + num3; String msg = Float.toString(tot); display(msg);}
    else if (parts.length == 4) { String part4 = parts[3]; float num4 = Float.parseFloat(part4); tot2 = tot + num4; String msg = Float.toString(tot2); display(msg);}
    else if (parts.length == 5) { String part5 = parts[4]; float num5 = Float.parseFloat(part5); tot3 = tot2 + num5;String msg = Float.toString(tot3);display(msg);}
    else if (parts.length == 6) { String part6 = parts[5];float num6 = Float.parseFloat(part6);tot4 = tot3 + num6;String msg = Float.toString(tot4);display(msg);}
    else if (parts.length == 7) { String part7 = parts[6]; float num6 = Float.parseFloat(part7); tot5 = tot4 + num6; String msg = Float.toString(tot5); display(msg); }
    else {
        insert = "0";
        display("not too many operations");
    }
}
                    else if(insert.contains(".*[-].[/].[*].[^]*")){ display("Only One Operand to be Operated");}


                    /**
                     for(int i=4;i<=sum;i++) {
                     String part(i) = parts[i-1];

                     float num(i) = Float.parseFloat(parts(i));
                     }**/

                    /**else{
                     reset();
                     }
                     **/
                    break;
                case '-':
                    String[] p = insert.split("\\-");
                    String p1 = p[0];
                    String p2 = p[1];
                    float n1 = Float.parseFloat(p1);
                    float n2 = Float.parseFloat(p2);
                    if(p.length==2){
                        totsub1=n1-n2;
                        String msgsub = Float.toString(totsub1);
                        display(msgsub);

                    }
                    else if(p.length==3){
                        String p3 = p[2];
                        float n3 = Float.parseFloat(p3);

                         sub = n1 - n2 - n3;
                        String msgsub = Float.toString(sub);
                        display(msgsub);

                    }
                    else if(p.length==4){String p4 = p[3];float n4 = Float.parseFloat(p4);sub1 = (float)(sub-n4);
                        String msgsub = Float.toString(sub1);
                        display(msgsub);}

                    else if(p.length==5){String p5 = p[4];float n5 = Float.parseFloat(p5);sub2 = sub1-n5;
                        String msgsub = Float.toString(sub2);
                        display(msgsub);}
                    else if(p.length==6){String p6 = p[5];float n6 = Float.parseFloat(p6);sub3 = sub2-n6;
                        String msgsub = Float.toString(sub3);
                        display(msgsub);}
                    else if(p.length==7){String p7 = p[6];float n7 = Float.parseFloat(p7);sub4 = sub3-n7;
                        String msgsub = Float.toString(sub4);
                        display(msgsub);}
                    else {
                        insert="0";
                        display("not too many operations");}

                    /**else{
                     reset();
                     }
                     **/
                    //System.out.println(totsub);

                    break;
                case '*':
                    String[] pa = insert.split("X");
                    String pa1 = pa[0];
                    String pa2 = pa[1];

                    float nu1 = Float.parseFloat(pa1);
                    float nu2 = Float.parseFloat(pa2);

                    if(pa.length==2){
                        totmul1= nu1 * nu2;
                        String msgmul = Float.toString(totmul1);
                        display(msgmul);

                    }
                    else if(pa.length==3){String pa3 = pa[2];   float nu3 = Float.parseFloat(pa3);  mul = totmul1 * nu3;
                        String msgmul = Float.toString(mul);
                        display(msgmul);}
                    else if(pa.length==4){String pa4 = pa[3];   float nu4 = Float.parseFloat(pa4);  mul1 = mul * nu4;
                        String msgmul = Float.toString(mul1);
                        display(msgmul);}
                    else if(pa.length==5){String pa5 = pa[4];   float nu5 = Float.parseFloat(pa5);  mul2 = mul1 * nu5;
                        String msgmul = Float.toString(mul2);
                        display(msgmul);}
                    else if(pa.length==6){String pa6 = pa[5];   float nu6 = Float.parseFloat(pa6);  mul3 = mul2 * nu6;
                        String msgmul = Float.toString(mul3);
                        display(msgmul);}
                    else if(pa.length==7){String pa7 = pa[6];   float nu7 = Float.parseFloat(pa7);  mul4 = mul3 * nu7;
                        String msgmul = Float.toString(mul4);
                        display(msgmul);}

                    else {
                        insert="0";
                        display("not too many operations");}

                    /**else
                     {
                     reset();
                     }**/
                    //System.out.println(totmul);
                    break;
                case '/':
                    String[] par = insert.split("\\/");
                    String par1 = par[0];
                    String par2 = par[1];
                    float number1 = Float.parseFloat(par1);
                    float number2 = Float.parseFloat(par2);
                    if(par.length==2)
                    {if (number2 != 0) { totdiv1 = number1 / number2; String msgdiv = Float.toString(totdiv1); display(msgdiv); break;}
                        else {//error();
                         display("INFINITY");}}
                    else if(par.length==3){ String par3 = par[2]; float number3 = Float.parseFloat(par3);
                        if(number3!=0)
                        {div = totdiv1 / number3; String msgdiv = Float.toString(div); display(msgdiv);break;}}
                    //System.out.println(totdiv);
                    else if(par.length==4){ String par4 = par[3]; float number4 = Float.parseFloat(par4);
                        if(number4!=0)
                        {div1 = div / number4; String msgdiv = Float.toString(div1); display(msgdiv);break;}}
                    else if(par.length==5){ String par5 = par[4]; float number5 = Float.parseFloat(par5);
                        if(number5!=0)
                        {div2 = div1 / number5; String msgdiv = Float.toString(div2); display(msgdiv);break;}}
                    else if(par.length==6){ String par6 = par[5]; float number6 = Float.parseFloat(par6);
                        if(number6!=0)
                        {div3 = div2 / number6; String msgdiv = Float.toString(div3); display(msgdiv);break;}}
                    else if(par.length==7){ String par7 = par[6]; float number7 = Float.parseFloat(par7);
                        if(number7!=0)
                        {div4 = div3 / number7; String msgdiv = Float.toString(div4); display(msgdiv);break;}}
                    else {
                        insert="0";
                        display("not too many operations");}
                    break;


                case '^':
                    String[] s = insert.split("\\^");
                    String s1 = s[0];
                    String s2 = s[1];
                    float nam1 = Float.parseFloat(s1);
                    float nam2 = Float.parseFloat(s2);

                    if (s.length == 2) {
                        totpow1 = myPow(nam1, nam2);
                        String msgpow = Float.toString(totpow1);
                        display(msgpow);
                    }
                    else if(s.length==3){
                        String s3 = s[2];
                        float nam3 = Float.parseFloat(s3);

                        float totpow = myPow(totpow1, nam3); //^ nam3;
                        String msgpow = Float.toString(totpow);
                        display(msgpow);}
                    else{
                        display("only for 2 operations");
                    }
                    // System.out.println(totpow);



                    break;
                default:

                    reset();
                    break;
            }
        }
/**
 String msg = String.valueOf(tot);
 display(msg);
 num1=msg;total="";op='.';
 **/
    }
    public float myPow(float x, float p) {
        double dblResult = Math.pow(x, p);
        float floatResult = (float)dblResult; // <-- Change to something safe. It may easily overflow.
        return floatResult;
    }
    public float Mul(float x, float y){
        return x*y;

    }
}

