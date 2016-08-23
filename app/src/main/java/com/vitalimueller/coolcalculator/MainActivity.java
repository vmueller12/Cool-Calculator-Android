package com.vitalimueller.coolcalculator;
// change the style of the Activity
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String runningNumber = "";
    private String leftValueStr = "";
    private String rightValueStr = "";
    private int result;
    TextView solutionView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    private Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneBtn = (Button) findViewById(R.id.onebtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threebtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multBtn);
        ImageButton additionBtn = (ImageButton) findViewById(R.id.addBtn);
        ImageButton subtractionBtn = (ImageButton) findViewById(R.id.subtBtn);
        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);

        solutionView = (TextView)findViewById(R.id.solutionView);


        solutionView.setText("");


        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });

        additionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });

        subtractionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                solutionView.setText("");

            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // processOperation(Operation.EQUAL);
            }
        });
        }

        void processOperation(Operation operation){
            if(currentOperation != null){
                if(runningNumber != ""){
                    rightValueStr = runningNumber;
                    runningNumber = "";

                    switch(currentOperation){
                        case ADD:
                            result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                            break;
                        case SUBTRACT:
                            result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                            break;
                        case MULTIPLY:
                            result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                            break;
                        case DIVIDE:
                            result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                            break;
                        default:
                            break;
                    }

                    leftValueStr = String.valueOf(result);
                    solutionView.setText(leftValueStr);
                }


            }else {
                leftValueStr = runningNumber;
                runningNumber = "";
            }
            currentOperation = operation;
        }

        void numberPressed(int number){
            runningNumber += String.valueOf(number);
            solutionView.setText(runningNumber);
        }



}
