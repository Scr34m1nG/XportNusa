import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.adyatma.xportnusa.R

class AdapList(context: Context, dataArrayList: ArrayList<DataList>) :
    ArrayAdapter<DataList>(context, R.layout.item_layout, dataArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val dataList = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        }

        val customDetailImage: ImageView = view!!.findViewById(R.id.customDetailImage)
        val customProdukDetails: TextView = view.findViewById(R.id.customProdukDetails)
        val customProdukDescriptions: TextView = view.findViewById(R.id.customProdukDescriptions)
        val storeInfoButton: ImageButton = view.findViewById(R.id.storeInfoButton)
        val chatSellerButton: Button = view.findViewById(R.id.chatSellerButton)

        dataList?.let {
            customDetailImage.setImageResource(it.Image)
            customProdukDetails.text = it.produkDetails
            customProdukDescriptions.text = it.produkDescriptions
        }

        storeInfoButton.setOnClickListener { storeInfoButtonClicked() }
        chatSellerButton.setOnClickListener { chatSellerButtonClicked() }

        return view
    }

    private fun storeInfoButtonClicked() {
        // Implement your store info button click logic here
    }

    private fun chatSellerButtonClicked() {
        // Implement your chat seller button click logic here
    }
}