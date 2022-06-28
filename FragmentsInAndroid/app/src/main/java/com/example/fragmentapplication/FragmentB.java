package com.example.fragmentapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.widget.TextView;

public class FragmentB extends Fragment {
        TextView textView;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_b, container, false);
            textView = view.findViewById(R.id.textViewB);
            String message = getArguments().getString("msg");
            textView.setText(message);
            return  view;
        }
}