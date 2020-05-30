package com.example.konovodov_hw_512_externalstorage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    public StringBuffer firstMember = new StringBuffer();
    public StringBuffer secondMember = new StringBuffer();
    public StringBuffer action = new StringBuffer();

    //public StringBuffer resultStr = new StringBuffer();
    public BigDecimal firstMemberBD;
    public BigDecimal secondMemberBD;
    public BigDecimal resultBD;

    private Button frameViewBtn;

    private LinearLayout llayout2;
    private LinearLayout llayout3;
    private LinearLayout llayout4;
    private LinearLayout llayout5;
    private LinearLayout llayout6;

    private LinearLayout llayout7;
    private LinearLayout llayout8;
    private LinearLayout llayout9;


    private TextView text1;
    private Button clearBtn;
    private Button percentBtn;
    private Button delBtn;
    private Button divBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button multBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button minusBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button plusBtn;
    private Button doubZeroBtn;
    private Button zeroBtn;
    private Button dotBtn;
    private Button resultBtn;
    private ImageView imageViewBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initID();


        text1.setTextAlignment(View.TEXT_ALIGNMENT_INHERIT);
        text1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);


        btnListeners();
        String filePath = getIntent().getStringExtra("filepath");

        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        if (bitmap != null) {
            imageViewBackground.setImageBitmap(bitmap);
        }


    }

    public void btnListeners() {

        frameViewBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                if (llayout2.getVisibility() == View.VISIBLE) {
                    llayout2.setVisibility(View.GONE);
                    llayout3.setVisibility(View.GONE);
                    llayout4.setVisibility(View.GONE);
                    llayout5.setVisibility(View.GONE);
                    llayout6.setVisibility(View.GONE);


                    llayout7.setVisibility(View.VISIBLE);
                    llayout8.setVisibility(View.VISIBLE);
                    llayout9.setVisibility(View.VISIBLE);

                } else {
                    llayout2.setVisibility(View.VISIBLE);
                    llayout3.setVisibility(View.VISIBLE);
                    llayout4.setVisibility(View.VISIBLE);
                    llayout5.setVisibility(View.VISIBLE);
                    llayout6.setVisibility(View.VISIBLE);

                    llayout7.setVisibility(View.GONE);
                    llayout8.setVisibility(View.GONE);
                    llayout9.setVisibility(View.GONE);


                }
            }
        });


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //text1.setText("");

                firstMember.setLength(0);
                secondMember.setLength(0);
                action.setLength(0);
                outData();


            }
        });
        percentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('%');
                outData();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delSymbol();
                outData();
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('/');
                outData();
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("7");
                outData();
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("8");
                outData();
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("9");
                outData();
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('X');
                outData();
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("4");
                outData();
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("5");
                outData();
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("6");
                outData();
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('-');
                outData();
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("1");
                outData();
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("2");
                outData();
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("3");
                outData();
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('+');
                outData();
            }
        });

        doubZeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (action.length() == 0) {
                    if (firstMember.length() != 0) {
                        firstMemberBD = new BigDecimal(firstMember.toString());
                        firstMemberBD = firstMemberBD.multiply(new BigDecimal("-1"));
                        firstMember = new StringBuffer(firstMemberBD.toString());
                    }
                } else {
                    if (secondMember.length() != 0) {
                        secondMemberBD = new BigDecimal(secondMember.toString());
                        secondMemberBD = secondMemberBD.multiply(new BigDecimal("-1"));
                        secondMember = new StringBuffer(secondMemberBD.toString());
                    }
                }
                //addSymbol("0");
                //addSymbol("0");
                outData();
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("0");
                outData();
            }
        });
        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (action.length() == 0) {
                    if (!firstMember.toString().contains(".")) {
                        if (firstMember.length() == 0) {
                            addSymbol("0");
                            addSymbol(".");
                        } else {
                            addSymbol(".");
                        }
                    }

                } else {
                    if (!secondMember.toString().contains(".")) {
                        if (secondMember.length() == 0) {
                            addSymbol("0");
                            addSymbol(".");
                        } else {
                            addSymbol(".");
                        }
                    }
                }

                outData();
            }
        });
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondMember.length() != 0) {
                    getResult();
                    outResult();
                    firstMemberBD = resultBD;
                    firstMember = new StringBuffer(firstMemberBD.toString());
                    secondMember.setLength(0);
                    action.setLength(0);
                }


            }
        });


    }

    public void clearData() {
    /*firstMember.delete();
    secondMember;
    action;
    resultStr;*/
    }

    public void addSymbol(String last) {
        if (action.length() == 0) {
            addAnySymbol(firstMember, last);


        } else {
            addAnySymbol(secondMember, last);
        }

    }

    private void addAnySymbol(StringBuffer member, String last) {
        if (member.length() == 1) {
            if (member.charAt(0) == '0') {
                if ("0".equals(last)) {

                } else {
                    if (".".equals(last)) {
                        member.append(last);
                    } else {
                        member.replace(0, 1, last);
                    }
                }


            } else {
                member.append(last);
            }
        } else {
            member.append(last);
        }
    }

    public void setAction(char last) {
        if (firstMember.length() != 0) {
            if (action.length() == 0) {
                action.insert(0, last);
            } else {
                action.setCharAt(0, last);
            }
        }
    }

    public void outData() {
        if (secondMember.length() != 0) {
            secondMemberBD = new BigDecimal(secondMember.toString());

            if (secondMemberBD.compareTo(new BigDecimal(0)) < 0/*"-".equals(secondMember.charAt(0))*/) {
                text1.setText(firstMember.toString() + action.toString() + '(' + secondMember.toString() + ')');
            } else {
                text1.setText(firstMember.toString() + action.toString() + secondMember.toString());
            }
        } else {
            text1.setText(firstMember.toString() + action.toString() + secondMember.toString());
        }
    }

    public void delSymbol() {
        if (action.length() == 0) {
            if (firstMember.length() != 0) {
                firstMember.deleteCharAt(firstMember.length() - 1);
            }

        } else {
            if (secondMember.length() == 0) {
                action.deleteCharAt(action.length() - 1);
            } else {
                secondMember.deleteCharAt(secondMember.length() - 1);
            }


        }
    }

    public void getResult() {

        firstMemberBD = new BigDecimal(firstMember.toString());
        //secondMemberBD = new BigDecimal(secondMember.toString());
        switch (action.toString().charAt(0)) {
            case '%': {
                secondMemberBD = new BigDecimal(secondMember.toString());
                resultBD = (firstMemberBD.divide(new BigDecimal("100"))).multiply(secondMemberBD);
                break;
            }
            case '/': {
                if ("0".equals(secondMember.toString())) {

                    Toast.makeText(MainActivity.this, "Операция деления на 0 запрещена", Toast.LENGTH_LONG).show();


                } else {
                    secondMemberBD = new BigDecimal(secondMember.toString());
                    //resultBD.setScale(, BigDecimal.ROUND_HALF_EVEN);
                    try {
                        resultBD = firstMemberBD.divide(secondMemberBD);//., decimals, rounding);//.setScale(2,BigDecimal.ROUND_DOWN);
                    } catch (ArithmeticException e) {
                        resultBD = firstMemberBD.divide(secondMemberBD, 5, BigDecimal.ROUND_HALF_EVEN);//., decimals, rounding);//.setScale(2,BigDecimal.ROUND_DOWN);
                        Toast.makeText(MainActivity.this, "Пардон, в учебных целях точность ограничена.\nО покупке лицензии узнавайте у разработчика ))", Toast.LENGTH_LONG).show();
                    }

                }
                break;
            }
            case 'X': {
                secondMemberBD = new BigDecimal(secondMember.toString());
                resultBD = firstMemberBD.multiply(secondMemberBD);
                break;
            }
            case '-': {
                secondMemberBD = new BigDecimal(secondMember.toString());
                resultBD = firstMemberBD.subtract(secondMemberBD);
                break;
            }
            case '+': {
                secondMemberBD = new BigDecimal(secondMember.toString());
                resultBD = firstMemberBD.add(secondMemberBD);
                break;
            }
        }


    }

    public void outResult() {
        //text1.setText(firstMember.toString() + action.toString() + secondMember.toString() + "\n" + resultBD.toString());
        if (secondMember.length() != 0) {
            secondMemberBD = new BigDecimal(secondMember.toString());

            if (secondMemberBD.compareTo(new BigDecimal("0")) < 0/*"-".equals(secondMember.charAt(0))*/) {
                text1.setText(firstMember.toString() + action.toString() + '(' + secondMember.toString() + ')' + "\n" + resultBD.toString());
            } else {
                if ((secondMemberBD.compareTo(new BigDecimal("0")) == 0) && ("/".equals(action.toString()))) {
                    text1.setText(firstMember.toString() + action.toString() + secondMember.toString() + "\n" + "Error"/*resultBD.toString()*/);
                    //firstMember.setLength(0);
                    action.setLength(0);
                    secondMember.setLength(0);
                } else {
                    text1.setText(firstMember.toString() + action.toString() + secondMember.toString() + "\n" + resultBD.toString());
                }
            }
        } else {
            text1.setText(firstMember.toString() + action.toString() + secondMember.toString() + "\n" + resultBD.toString());
        }
    }


    private void initID() {
        frameViewBtn = findViewById(R.id.button);
        llayout2 = findViewById(R.id.linearLayout2);
        llayout3 = findViewById(R.id.linearLayout3);
        llayout4 = findViewById(R.id.linearLayout4);
        llayout5 = findViewById(R.id.linearLayout5);
        llayout6 = findViewById(R.id.linearLayout6);

        llayout7 = findViewById(R.id.linearLayout7);
        llayout8 = findViewById(R.id.linearLayout8);
        llayout9 = findViewById(R.id.linearLayout9);


        text1 = (TextView) findViewById(R.id.textView);
        clearBtn = findViewById(R.id.button1);
        percentBtn = findViewById(R.id.button2);
        delBtn = findViewById(R.id.button3);
        divBtn = findViewById(R.id.button4);
        sevenBtn = findViewById(R.id.button5);
        eightBtn = findViewById(R.id.button6);
        nineBtn = findViewById(R.id.button7);
        multBtn = findViewById(R.id.button8);
        fourBtn = findViewById(R.id.button9);
        fiveBtn = findViewById(R.id.button10);
        sixBtn = findViewById(R.id.button11);
        minusBtn = findViewById(R.id.button12);
        oneBtn = findViewById(R.id.button13);
        twoBtn = findViewById(R.id.button14);
        threeBtn = findViewById(R.id.button15);
        plusBtn = findViewById(R.id.button16);
        doubZeroBtn = findViewById(R.id.button17);
        zeroBtn = findViewById(R.id.button18);
        dotBtn = findViewById(R.id.button19);
        resultBtn = findViewById(R.id.button20);
        imageViewBackground = findViewById(R.id.imageViewBackground);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_open_notes) {
            //Toast.makeText(MainActivity.this, "Открыть записную книжку", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Открыть настройки", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intentNotes);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
