package com.utxj.mieconomia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistroFragment extends Fragment {

    RadioGroup radioGroup;
    EditText editTextMotivo;
    EditText editTextMonto;
    Button button;
    Movimiento movimiento;


    public RegistroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         movimiento = new Movimiento();
        radioGroup = view.findViewById( R.id.radioGroup );
        editTextMotivo = view.findViewById(R.id.txtmotivo);
        editTextMonto = view.findViewById(R.id.monto);
        button = view.findViewById(R.id.btnguardar);

        radioGroup.setOnCheckedChangeListener( (radioGroup1, i) -> {
            RadioButton checkedRadioButton = (RadioButton)radioGroup.findViewById(i);
            boolean isChecked = checkedRadioButton.isChecked();
            if (isChecked){
                if( checkedRadioButton.getText() == "Ingreso" ){
                    this.movimiento.setTipo( true );
                }else{
                    this.movimiento.setTipo( false );
                }
            }
        } );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty( editTextMotivo.getText().toString() )){
                    editTextMotivo.setError("Llene este campo");
                    return;
                }
                if (TextUtils.isEmpty( editTextMonto.getText().toString() )){
                    editTextMonto.setError("Llene este campo");
                    return;
                }

                movimiento.setMotivo( editTextMotivo.getText().toString() );
                movimiento.setMonto( Double.parseDouble(editTextMonto.getText().toString())  );
                ((HomeActivity) getActivity()).agregarMovimiento(movimiento);
                getActivity().onBackPressed();
            }
        });


    }
}