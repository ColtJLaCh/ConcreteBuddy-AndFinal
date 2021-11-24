package coltonlachance.com.concretecalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/** Calculator Fragment
  * Calculator fragment, takes in 3 variables and returns volume for either rectanglar/circular slabs
 * @author Colton LaChance
 */
public class CalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        TextView showCalcTV = view.findViewById(R.id.showCalcTV);

        //Rectangles (SLABS)
        EditText rectWidthInput = view.findViewById(R.id.numInputWidth);
        EditText rectLengthInput = view.findViewById(R.id.numInputLength);
        EditText rectHeightInput = view.findViewById(R.id.numInputHeightSlabs);
        EditText rectNumInput = view.findViewById(R.id.numInputNumberSlabs);

        //Circular
        EditText circOuterInput = view.findViewById(R.id.numInputOuter);
        EditText circInnerInput = view.findViewById(R.id.numInputInner);
        EditText circHeightInput = view.findViewById(R.id.numInputHeightCirc);
        EditText circNumInput = view.findViewById(R.id.numInputNumberCirc);


        Button calcButton = view.findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rectWidth = getInputVal(rectWidthInput.getText().toString());
                double rectLength = getInputVal(rectLengthInput.getText().toString());
                double rectHeight = getInputVal(rectHeightInput.getText().toString());
                double rectNum = getInputVal(rectNumInput.getText().toString());

                double circOuter = getInputVal(circOuterInput.getText().toString());
                double circInner = getInputVal(circInnerInput.getText().toString());
                double circHeight = getInputVal(circHeightInput.getText().toString());
                double circNum = getInputVal(circNumInput.getText().toString());

                //Calc volume
                double volume1 = calcSlabVolume(rectWidth,rectLength,rectHeight/100,false);
                double volume2 = calcSlabVolume(circOuter,circInner,circHeight/100,true);
                volume1 *= rectNum;
                volume2 *= circNum;

                double addedVolume = volume1+volume2;

                float finalVolume = (float)addedVolume;

                String volText = "[The total amount of concrete needed is " + String.format("%.2f",finalVolume) + "m\u00B3]";
                showCalcTV.setText(volText);
            }
        });

        return view;
    }

    /** double calcSlabVolume()
     * Takes in three variables and calculates rectangular or circular volume
     * @param x1
     * @param x2
     * @param x3
     * @param isCircular
     * @return volune
     * @author Colton LaChance
     */
    private double calcSlabVolume(double x1, double x2, double x3, boolean isCircular) {
        double volume = 0.0;
        if (!isCircular) {
            volume = x1*x2*x3;
        }else{
            volume = (Math.PI*(x1/2)*x3)-(Math.PI*(x2/2)*x3);
        }
        return volume;
    }

    /**getInputVal()
     * Takes in a string and converts it to a Double if the string doesn't equal null
     * @param inputVal
     * @return
     * @author Colton LaChance
     */
    private double getInputVal(String inputVal) {
        double val = 0.0;

        if (!inputVal.equals("")) {
            val = Double.parseDouble(inputVal);
        }
        return val;
    }
}