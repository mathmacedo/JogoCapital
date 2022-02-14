package com.example.jogocapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] estados = {"Rio Grande do Sul", "Santa Catarina", "Parana", "Sao Paulo", "Rio de Janeiro", "Minas Gerais", "Pernambuco", "Mato Grosso", "Tocantins", "Bahia", "Espirito Santo", "Acre", "Ceara", "Maranhão", "Amazonas"};
    String[] capitais = {"Porto Alegre", "Florianopolis", "Curitiba", "Sao Paulo", "Rio de Janeiro", "Belo Horizonte", "Recife", "Campo Grande", "Palmas", "Salvador", "Vitoria", "Rio Branco", "Fortaleza", "Sao Luis", "Manaus"};
    TextView estadoTextView;
    EditText capitalText;
    TextView pontuacaoTextView;
    TextView acertoTextView;
    Button enviarButton;
    Button avancarButton;

    int acertos = 0;
    int quantidadePerguntas = 0;
    int random = new Random().nextInt(15) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estadoTextView = findViewById(R.id.estadoTextView);
        capitalText = findViewById(R.id.capitalEditText);
        pontuacaoTextView = findViewById(R.id.pontuacaoTextView);
        acertoTextView = findViewById(R.id.acertoTextView);
        enviarButton = findViewById(R.id.enviarButton);
        avancarButton = findViewById(R.id.avancarButton);


        String estado = estados[random];

        estadoTextView.setText(estado);
    }

    public void confirmar(View view) {
        if (capitalText.getText().toString().toLowerCase(Locale.ROOT).equals(capitais[random].toLowerCase(Locale.ROOT))) {
            acertos++;
            acertoTextView.setText("Resposta correta!");
        } else {
            acertoTextView.setText("Resposta Errada!");
        }

        pontuacaoTextView.setText("Sua pontuação é " + acertos);
        quantidadePerguntas++;


        if (quantidadePerguntas == 5) {
            enviarButton.setEnabled(false);
            avancarButton.setEnabled(false);
        }
    }

    public void avancar(View view) {
        capitalText.setText("");
        acertoTextView.setText("");
        random = new Random().nextInt(15) + 1;
        estadoTextView.setText(estados[random]);
    }
}