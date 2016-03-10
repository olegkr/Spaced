package spaced.com.spaced;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import fragments.MyDecksFragment;
import utils.LogUtil;

/**
 * Created by Oleg on 04.03.2016.
 */
public class NewDeckActivity extends Activity implements View.OnClickListener{

    private static final int LAYOUT = R.layout.new_card_create;
    private static final int CAMERA_REQUEST = 111;

    View view;
    EditText mEtDeckName;
    Bitmap mDeckBtmp;
    Button mBtnSpcdGlr;
    Button mBtnPhnGlr;
    Button mBtnTkPht;
    public ImageView mIvw;
    Button mBtnCncl;
    Button mBtnOk;


    String mDeckName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        LogUtil.d("");

        view = this.findViewById(android.R.id.content);
        mEtDeckName = (EditText) findViewById(R.id.eT_new_deck_name);
        mBtnSpcdGlr = (Button) findViewById(R.id.btn_spaced_gallery);
        mBtnPhnGlr = (Button) findViewById(R.id.btn_phone_gallery);
        mBtnTkPht = (Button) findViewById(R.id.btn_take_photo);
        mIvw = (ImageView) findViewById(R.id.imVw_new_deck);
        mBtnCncl = (Button) findViewById(R.id.btn_cancel_new_deck);
        mBtnOk = (Button) findViewById(R.id.btn_create_new_deck);

        mBtnSpcdGlr.setOnClickListener(this);
        mBtnPhnGlr.setOnClickListener(this);
        mBtnTkPht.setOnClickListener(this);
        mBtnOk.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("");
    }


    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("");
    }


    @Override
    public void onClick(View v) {
        LogUtil.d("");
        switch (v.getId()){
            case R.id.btn_phone_gallery:{
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, CAMERA_REQUEST);

                break;
            }
            case R.id.btn_create_new_deck:{
                mDeckName = mEtDeckName.getText().toString();

//                DeckModel dm = new DeckModel(0, mDeckName, mDeckBtmp);
//                DeckModel dm = new DeckModel();

//                mIvw.setImageBitmap(mDeckBtmp);

                Bundle bundle = new Bundle();
                bundle.putInt("deck_id", 0);  LogUtil.d("deck_id: " + 0);
                bundle.putString("deck_name", mDeckName);  LogUtil.d("mDeckName: " + mDeckName);
                bundle.putParcelable("deck_image", mDeckBtmp);  LogUtil.d("deck_image: " + mDeckBtmp);
                bundle.putInt("deck_count", 0);  LogUtil.d("deck_count: ");

                MyDecksFragment fragment = new MyDecksFragment();
                fragment.newInstance(bundle);
                finish();

                break; 
            }

            default:
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogUtil.d("");
        InputStream stream = null;
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
            try {
                // recyle unused bitmaps
                if (mDeckBtmp != null) {
                    mDeckBtmp.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                mDeckBtmp = BitmapFactory.decodeStream(stream);
//                mIvw.setImageBitmap(mDeckBtmp);
                // из ресурсов
//                Picasso.with(this)
//                        .load(mDeckBtmp.getGenerationId())
//                        .transform(new CropSquareTransformation())
//                        .into(mIvw);


                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath());
                Bitmap bit = decodeSampledBitmapFromResource(getApplicationContext(), uri, 100, 100);
                mIvw.setImageBitmap(bit);

//                mIvw.setImageBitmap(mDeckBtmp);

                LogUtil.d("mDeckBtmp: " + mDeckBtmp);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            if (stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Context context, Uri uri, int reqWidth, int reqHeight)
            throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        InputStream inputStream = contentResolver.openInputStream(uri);
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        inputStream = contentResolver.openInputStream(uri);
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
