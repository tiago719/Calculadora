package pt.isec.a21250388.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Boolean isNewNumber;
    float anterior;
    int operacao;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anterior=0;
        operacao=-1;
        isNewNumber=true;
    }

    public void OnCarregasteNumero(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);

        String str=((Button)v).getText().toString();

        if(isNewNumber)
            tv.setText(str);
        else
            tv.setText(tv.getText()+str);

        isNewNumber=false;
    }

    public void onMais(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);

        anterior= (float) Double.parseDouble(tv.getText().toString());
        tv.setText("");
        operacao=1;
    }

    public void onMenos(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        anterior= (float) Double.parseDouble(tv.getText().toString());
        tv.setText("");
        operacao=2;
    }

    public void onVezes(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        anterior= (float) Double.parseDouble(tv.getText().toString());
        tv.setText("");

        operacao=3;
    }

    public void onDividir(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        anterior= (float) Double.parseDouble(tv.getText().toString());
        tv.setText("");
        operacao=4;
    }

    public void onPercentagem(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        anterior= (float) Double.parseDouble(tv.getText().toString());
        tv.setText(""+(float) (anterior*0.01));
    }

    public void onAC(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        tv.setText("");
        tv.setText("0.0");
        isNewNumber=true;
    }

    public void onMaisMenos(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        float atual=Float.parseFloat(tv.getText().toString());

        atual*=-1;
        tv.setText(""+atual);
        isNewNumber=true;
    }

    public void onIgual(View v)
    {
        TextView tv = (TextView) findViewById(R.id.tTexto);
        float atual=Float.parseFloat(tv.getText().toString());
        float resultado=0;
        if(operacao!=-1)
        {
            switch (operacao)
            {
                case 1:
                    resultado=anterior+atual;
                    break;
                case 2:
                    resultado=anterior-atual;
                    break;
                case 3:
                    resultado=anterior*atual;
                    break;
                case 4:
                    resultado=anterior/atual;
                    break;
            }
            operacao=-1;
            tv.setText(""+resultado);
        }
        else
        {
            tv.setText(""+atual);
        }
        isNewNumber=true;
    }
}
