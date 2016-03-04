package spaced.com.spaced;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Oleg on 04.03.2016.
 */
public class NewCardActivity extends Activity {

    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_card_create);

        view = this.findViewById(android.R.id.content);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
