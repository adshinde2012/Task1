package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText paragraph, skipno;
    String answer;
    TextView anstxt, errortxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paragraph = findViewById(R.id.id_para_et);
        anstxt = findViewById(R.id.id_result_text);
        skipno = findViewById(R.id.id_et_no);
        errortxt = findViewById(R.id.id_error_text);
        errortxt.setVisibility(View.INVISIBLE);
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public void reverseFunction(View view) {

        try{
            errortxt.setVisibility(View.INVISIBLE);
            if (isEmpty(paragraph)) {
                paragraph.setError("Enter Paragraph!");
            }
            if (isEmpty(skipno)) {
                skipno.setError("Enter Number!");
            }
            else{
                answer = "";
                String paraText = paragraph.getText().toString();
                int number = Integer.parseInt(skipno.getText().toString());
                //getting words till .(dot)
                String[] para = paraText.split("\\.");

                for (int i = 0 ; i <= para.length -1; i++)
                {
                    String lines = "";
                    lines = para[i].trim();
                    String[] words = lines.split(" ");
                    //for reverse words
                    String result1 = "";
                    for (int j = words.length - (number + 1); j >= 0; j--)
                    {
                        result1 += (words[j] + " ");
                    }
                    //System.out.print(result1.trim());
                    String result2 = "";
                    //for remaining last 2 words
                    for (int k = words.length - number; k <= words.length - 1 ; k++)
                    {
                        result2 +=	(" " + words[k]);
                    }
                    //System.out.print(result2 + ". ");
                    answer += result1 + result2 + ".\n " ;
                }
                anstxt.setText(answer);
            }
        }catch(ArrayIndexOutOfBoundsException ae){
            errortxt.setVisibility(View.VISIBLE);
                    //System.out.println("number of words you don't want to reverse should not be greater than lenght of the paragraph");
        }
    }
}