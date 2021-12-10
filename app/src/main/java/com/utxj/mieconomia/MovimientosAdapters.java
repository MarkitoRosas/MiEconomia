package com.utxj.mieconomia;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MovimientosAdapters extends RecyclerView.Adapter<MovimientosAdapters.viewHolder> {

    ArrayList<Movimiento> lista;
    Context context;
    private static DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");


    public MovimientosAdapters(ArrayList<Movimiento> movimientos, Context context) {
        this.lista = movimientos;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate( R.layout.item_movimiento, null, false );
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Movimiento movimiento =  lista.get(position);

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm");
        String strDate = dateFormat.format( movimiento.getFecha() );
        holder.fecha.setText(strDate);

        holder.motivo.setText( movimiento.getMotivo() );
        String simbolo = "- ";
        holder.monto.setTextColor(Color.rgb(238, 96,2));
        if( movimiento.getTipo() ){
            simbolo = "+ ";
            holder.monto.setTextColor(Color.rgb(9,175,0));
        }
        holder.monto.setText( simbolo + "$" + REAL_FORMATTER.format(movimiento.getMonto()));
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView fecha, motivo, monto;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha);
            motivo = itemView.findViewById(R.id.txtmotivo);
            monto = itemView.findViewById(R.id.txtmonto);
        }
    }
}
