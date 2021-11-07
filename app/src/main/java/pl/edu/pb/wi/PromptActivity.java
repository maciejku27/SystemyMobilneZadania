package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private boolean correctAnswer;

    private Button showHintButton;
    private TextView promptTextView;
    private TextView hintTextView;

    public static final String KEY_EXTRA_HINT_SHOWN = "hintShown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        showHintButton = findViewById(R.id.hint_button);
        hintTextView = findViewById(R.id.hint_textView);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        showHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hint = correctAnswer ? R.string.button_true : R.string.button_false;
                hintTextView.setText(hint);
                setHintShownResult(true);
            }
        });
    }
    private void setHintShownResult(boolean hintWasShown) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_HINT_SHOWN, hintWasShown);
        setResult(RESULT_OK, resultIntent);
    }

}