package kz.talipovsn.sum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editText_a; // Переменная для доступа к компоненту со значением "a"
    EditText editText_b; // Переменная для доступа к компоненту со значением "b"
    EditText editText_c; //Переменная для доступа к компоненту со значением "c"
    EditText editText_d; //Переменная для доступа к компоненту со значением "d"
    EditText editText_x; //Переменная для доступа к компоненту со значением "x"
    TextView textView_sum; // Переменная для доступа к компоненту со значением результата
    Button buttonSum; // Переменная для доступа к компоненту кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Доступ к компонентам окна
        editText_a = findViewById(R.id.editText_a);
        editText_b = findViewById(R.id.editText_b);
        editText_c = findViewById(R.id.editText_c);
        editText_d = findViewById(R.id.editText_d);
        editText_x = findViewById(R.id.editText_x);
        textView_sum = findViewById(R.id.textView_sum);
        buttonSum = findViewById(R.id.buttonSum);

        if (savedInstanceState != null) {
            textView_sum.setText(savedInstanceState.getString("y"));
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("y", textView_sum.getText().toString());
    }

    // МЕТОД КНОПКИ РАСЧЕТА
    public void onClick(View v) {
        // Объявление локальных переменных
        double a, b, c, d, x, y;
        try { // НАЧАЛО ЗАЩИЩЕННОГО БЛОКА

            // Чтение данных из компонент
            a = Double.parseDouble(editText_a.getText().toString().trim());
            b = Double.parseDouble(editText_b.getText().toString().trim());
            c = Double.parseDouble(editText_c.getText().toString().trim());
            d = Double.parseDouble(editText_d.getText().toString().trim());
            x = Double.parseDouble(editText_x.getText().toString().trim());

            // Основной алгоритм
            if (x <= 5) {
                y = ((Math.pow(a, 2) * c) + Math.pow(b, 2) - d) / x;
            } else {
                y = Math.pow(x, 2) + 5;
            }

            NumberFormat formatter = new DecimalFormat("#0.00");
            System.out.println(formatter.format(4.0));

            NumberFormat normalNum = new DecimalFormat("#0");
            System.out.println(normalNum.format(4));

            // Вывод полученного значения в компонент
            if (y % 1 == 0) {
                textView_sum.setText(String.valueOf(normalNum.format(y)));
            } else {
                textView_sum.setText(String.valueOf(formatter.format(y)));
            }


        } catch (Exception e) { // ЧТО ДЕЛАТЬ ЕСЛИ ВОЗНИКНЕТ ОШИБКА В БЛОКЕ МЕЖДУ "TRY" И "CATCH":

            // Вывод сообщения об ошибке
            textView_sum.setText("Неверные входные данные для расчета!");

        }  // КОНЕЦ ЗАЩИЩЕННОГО БЛОКА

    }

}