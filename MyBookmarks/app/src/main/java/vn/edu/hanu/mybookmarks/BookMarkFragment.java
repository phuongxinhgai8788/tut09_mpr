package vn.edu.hanu.mybookmarks;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class BookMarkFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book_mark, container, false);
        // get ref to all buttons
        ImageView baomoi = view.findViewById(R.id.baomoi);
        ImageView bluezone = view.findViewById(R.id.bluezone);
        ImageView zingmp3 = view.findViewById(R.id.zingmp3);
        ImageView vnexpress = view.findViewById(R.id.vn);
        // handle event listener for buttons
        baomoi.setOnClickListener(this);
        bluezone.setOnClickListener(this);
        zingmp3.setOnClickListener(this);
        vnexpress.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        FragmentManager manager = getFragmentManager();
        Fragment fragment = new WebviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        switch (v.getId()){
            case R.id.baomoi:
                args.putString("LINK","https://baomoi.com/");
                break;
            case R.id.bluezone:
                args.putString("LINK","https://bluezone.gov.vn/");

                break;
            case R.id.zingmp3:
                args.putString("LINK","https://zingmp3.vn/");

                break;
            case R.id.vn:
                args.putString("LINK","https://vnexpress.net/");
                break;
        }
        manager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}