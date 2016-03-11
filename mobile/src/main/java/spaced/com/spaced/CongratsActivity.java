package spaced.com.spaced;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ilya on 10/3/2016.
 */
public class CongratsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.congrats_layout);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/UbuntuCondensedRegular.ttf");
        ((TextView)findViewById(R.id.Title)).setTypeface(font);
        ((TextView)findViewById(R.id.SubTitle)).setTypeface(font);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
