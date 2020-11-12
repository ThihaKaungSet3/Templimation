package non.shahad.templatesforrle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import non.shahad.templatesforrle.databinding.ListItemBinding

class MainRecyclerViewAdapter(
    private val listItems: List<Pair<Int,String>> = emptyList(),
    private val onItemClick: (Int) -> Unit
): RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> (){

    inner class MainViewHolder(
        private val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Pair<Int,String>){
            binding.name = item.second
            binding.root.setOnClickListener {
                onItemClick(item.first)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int = listItems.size

}