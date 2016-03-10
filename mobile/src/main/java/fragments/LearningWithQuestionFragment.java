package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import spaced.com.spaced.R;

/**
 * Created by Ilya on 10/3/2016.
 */
public class LearningWithQuestionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.learning_with_question_fragment, container, false);
        view.findViewById(R.id.showAnswerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "showing answer", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
