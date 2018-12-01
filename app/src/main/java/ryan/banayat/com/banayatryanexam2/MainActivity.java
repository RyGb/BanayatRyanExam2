package ryan.banayat.com.banayatryanexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText eFN, eLN, eScore1, eScore2;
    private Button sendData;
    private Firebase fir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fir = new Firebase("https://fir-itf.firebaseio.com/grade/key");

        eFN = findViewById(R.id.etFN);
        eLN = findViewById(R.id.etLN);
        eScore1 = findViewById(R.id.etEx1);
        eScore2 = findViewById(R.id.etEx2);

        sendData = findViewById(R.id.aveClick);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = eFN.getText().toString();
                String lname = eLN.getText().toString();
                TextView resultTextView = findViewById(R.id.resTextView);

                int sc1 = Integer.parseInt(eScore1.getText().toString().trim());
                int sc2 = Integer.parseInt(eScore2.getText().toString().trim());
                int ave = (sc1+sc2)/2;
                resultTextView.setText(ave +"");

                Firebase aver = fir.child("average");
                Firebase fn = fir.child("fname");
                Firebase ln = fir.child("lname");

                aver.setValue(ave);
                fn.setValue(fname);
                ln.setValue(lname);

            }
        });
    }
}