/**
 * Nome: Felipe Bernardes Cisilo
 * RA: 1110482413017
 */
package br.edu.fateczl.atividade08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import br.edu.fateczl.atividade08.model.Ingresso;
import br.edu.fateczl.atividade08.model.IngressoVIP;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo, etValor, etTaxa;
    private RadioButton rbIngressoNormal, rbIngressoVIP;

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

        etCodigo = findViewById(R.id.etCodigo);
        etValor = findViewById(R.id.etValor);
        etTaxa = findViewById(R.id.etTaxa);
        rbIngressoNormal = findViewById(R.id.rbIngressoNormal);
        rbIngressoVIP = findViewById(R.id.rbIngressoVIP);

        Button btnComprar = findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(this::comprarIngresso);
    }

    public void comprarIngresso(View view) {
        String codigo = etCodigo.getText().toString();
        float valor = Float.parseFloat(etValor.getText().toString());
        float taxa = Float.parseFloat(etTaxa.getText().toString());

        Ingresso ingresso;
        if (rbIngressoVIP.isChecked()) {
            ingresso = new IngressoVIP(codigo, valor, "VIP");
        } else {
            ingresso = new Ingresso(codigo, valor);
        }

        float valorFinal = ingresso.valorFinal(taxa);

        Intent intent = new Intent(this, DetalhesCompraActivity.class);
        intent.putExtra("codigo", codigo);
        intent.putExtra("valor", valor);
        intent.putExtra("taxa", taxa);
        intent.putExtra("valorFinal", valorFinal);
        startActivity(intent);
    }
}