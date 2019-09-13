package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private int number;
    private EditText inputNumber;
    private Button button;
    private int numberTebak;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: bind layout di sini
        initRandomNumber();
    }

    // TODO: generate angka random di sini
    private void initRandomNumber() {
        number = random.nextInt(10) + 1;
    }

    public void handleGuess(View view) {
        // TODO: Tambahkan logika untuk melakukan pengecekan angka
        inputNumber = findViewById(R.id.number_input);
        numberTebak = Integer.parseInt(String.valueOf(inputNumber.getText()));
        if (numberTebak == number) {
            Toast.makeText(this, "tebakan anda benar!", Toast.LENGTH_SHORT).show();
            button = findViewById(R.id.guess_button);
            button.setEnabled(false);
        } else if (numberTebak > number) {
            Toast.makeText(this, "tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
        } else if (numberTebak < number) {
            Toast.makeText(this, "tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
        }
    }

    private int buatAngkaRandom(int angkaMin, int angkaMax) {
        Random rand = new Random();
        int randomNum = rand.nextInt(angkaMax - angkaMin) + angkaMin;
        return randomNum;
    }

    public void handleReset(View view) {
        // TODO: Reset tampilan
        setContentView(R.layout.activity_main);
        initRandomNumber();
    }
}
