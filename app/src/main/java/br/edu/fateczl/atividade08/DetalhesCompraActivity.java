/**
 * @author: Felipe Bernardes Cisilo
 */

package br.edu.fateczl.atividade08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_compra);

        TextView tvCodigo = findViewById(R.id.tvCodigo);
        TextView tvValor = findViewById(R.id.tvValor);
        TextView tvTaxa = findViewById(R.id.tvTaxa);
        TextView tvValorFinal = findViewById(R.id.tvValorFinal);

        Intent intent = getIntent();
        String codigo = intent.getStringExtra("codigo");
        float valor = intent.getFloatExtra("valor", 0.0f);
        float taxa = intent.getFloatExtra("taxa", 0.0f);
        float valorFinal = intent.getFloatExtra("valorFinal", 0.0f);

        tvCodigo.setText("Código: " + codigo);
        tvValor.setText("Valor: " + valor);
        tvTaxa.setText("Taxa de Conveniência: " + taxa);
        tvValorFinal.setText("Valor Final: " + valorFinal);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> finish());
    }
}
