package br.com.digitalhouse.digitalhousegroceryapp.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.digitalhousegroceryapp.R;
import br.com.digitalhouse.digitalhousegroceryapp.modules.lista.model.Promocao;

public class PromocaoAdapter extends RecyclerView.Adapter<PromocaoAdapter.ViewHolder> {

    private List<Promocao> promocaoList = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promocao_celula,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Promocao promocao = promocaoList.get(position);
        holder.bind(promocao);

    }

    @Override
    public int getItemCount() {
        return promocaoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView descricaoTextView;
        private TextView precoTextView;
        private ImageView imagemImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            descricaoTextView = itemView.findViewById(R.id.descricao_promocao_text_view_id);
            precoTextView = itemView.findViewById(R.id.preco_promocao_text_view_id);
            imagemImageView = itemView.findViewById(R.id.imagem_promocao_image_view_id);
        }

        public void bind(Promocao promocao) {

            descricaoTextView.setText(promocao.getDescricao());
            precoTextView.setText(String.valueOf( promocao.getPreco()));

            Picasso.get().load(promocao.getImagem()).into(imagemImageView);

        }
    }
}
