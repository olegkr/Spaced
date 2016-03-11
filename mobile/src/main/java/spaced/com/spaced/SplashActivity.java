package spaced.com.spaced;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Ilya on 10/3/2016.
 */
public class SplashActivity extends Activity {

private static final int TARGET_DP = 500;
private static final long TIME_TO_ANIMATE = 10000;

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(name, context, attrs);
        return view;
    }

    @Override
    protected void onResume() {
        super.onResume();

        View firstCloud = findViewById(R.id.firstCloud);
        View secondCloud = findViewById(R.id.secondCloud);
        View thirdsCloud = findViewById(R.id.thirdsCloud);

        Animation animation = new TranslateAnimation(0, TARGET_DP / 2 ,0, 0);
        animation.setDuration(TIME_TO_ANIMATE);
        animation.setFillAfter(true);
        firstCloud.startAnimation(animation);

        animation = new TranslateAnimation(0, TARGET_DP * -1 ,0, 0);
        animation.setDuration(TIME_TO_ANIMATE);
        animation.setFillAfter(true);
        secondCloud.startAnimation(animation);

        animation = new TranslateAnimation(0, TARGET_DP ,0, 0);
        animation.setDuration(TIME_TO_ANIMATE);
        animation.setFillAfter(true);
        thirdsCloud.startAnimation(animation);

        findViewById(R.id.continueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainScreenActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
    }

    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
