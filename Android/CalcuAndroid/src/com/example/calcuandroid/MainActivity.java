package com.example.calcuandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends Activity {
	public enum Calc {Mul, Div, Plus, Sub}
	public EditText display;
	Calc op;
	Double mem;
	Button btnPl;
	Button btnSub;
	Button btnMul;
	Button btnDiv;
	Button btnEq;
	Button btn0;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btnCl;
	TextView input;
	String a="";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//setting up the buttons
		input = (EditText) findViewById(R.id.input);
		btnPl = (Button) findViewById(R.id.button11);
		btnSub = (Button) findViewById(R.id.btnMin);
		btnMul = (Button) findViewById(R.id.btnMul);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnEq = (Button) findViewById(R.id.btnEq);
		btn0 = (Button) findViewById(R.id.button1);
		btn1 = (Button) findViewById(R.id.button2);
		btn2 = (Button) findViewById(R.id.button3);
		btn3 = (Button) findViewById(R.id.button4);
		btn4 = (Button) findViewById(R.id.button5);
		btn5 = (Button) findViewById(R.id.button6);
		btn6 = (Button) findViewById(R.id.button7);
		btn7 = (Button) findViewById(R.id.button8);
		btn8 = (Button) findViewById(R.id.button9);
		btn9 = (Button) findViewById(R.id.button10);
		btnCl = (Button) findViewById(R.id.btnCl);
		
		//setting up buttons
		btn0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"0");
				
			}
		});
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"1");			
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"2");		
			}
		});
		
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"3");			
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"4");			
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"5");			
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"6");			
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"7");			
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"8");				
			}
		});
		btn9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				a = input.getText().toString();
				input.setText(a+"9");				
			}
		});
		
		
		//setting up operands
		btnCl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				input.setText("");
				
			}
		});
		btnPl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				op = Calc.Plus;
				mem = Double.parseDouble(String.valueOf(input.getText()));
				input.setText("");		
			}
		});
		btnSub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				op = Calc.Sub;
				mem = Double.parseDouble(String.valueOf(input.getText()));
				input.setText("");		
			}
		});
		btnMul.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				op = Calc.Mul;
				mem = Double.parseDouble(String.valueOf(input.getText()));
				input.setText("");		
			}
		});
		btnDiv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				op = Calc.Div;
				mem = Double.parseDouble(String.valueOf(input.getText()));
				input.setText("");		
			}
		});
		btnEq.setOnClickListener(new View.OnClickListener() {
			//PROBLEM WITH THIS METHOD
			/*for some reason, after doing the calculation, the screen won't automatically clear when I press a new number
			 working on trying to figure out why, but for now will put a label that says to use the clear button after a calculation
			 */
			@Override
			public void onClick(View v) {
			
				double Result;
				String s;
				switch (op) {
				case Plus:
					Result=Double.parseDouble(String.valueOf(input.getText()))+mem;
					s = String.valueOf(Result);
					input.setText(s);
					break;
				case Sub:
					//Result = mem-Double.parseDouble(val);
					//s = String.valueOf(Result);
					//input.setText(s);
					Result=mem - Double.parseDouble(String.valueOf(input.getText()));
					s = String.valueOf(Result);
					input.setText(s);
					break;
				case Mul:
					//Result = Double.parseDouble(val)*mem;
					//s = String.valueOf(Result);
					//input.setText(s);
					Result=Double.parseDouble(String.valueOf(input.getText()))*mem;
					s = String.valueOf(Result);
					input.setText(s);
					break;
				case Div:
					//Result = mem/Double.parseDouble(val);
					//s = String.valueOf(Result);
					//input.setText(s);
					Result=mem / Double.parseDouble(String.valueOf(input.getText()));
					s = String.valueOf(Result);
					input.setText(s);
					break;
					
				}
				
			}
		});
		
		
		
			
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
