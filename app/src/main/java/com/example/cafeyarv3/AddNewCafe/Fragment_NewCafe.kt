package com.example.cafeyarv3.AddNewCafe

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.AddNewCafe.Adapter.Adapter_ImagePicker
import com.example.cafeyarv3.R


/**
 * Created by abolfazl_dv on 02,April,2022
 */
class Fragment_NewCafe : Fragment() {
    var imagePickerRecycler: RecyclerView? = null
    private var images: ArrayList<Uri>? = null
    private val position: Int = 0

    companion object {
        const val PICK_IMAGE_CODE = 1234


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newcafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // views

        imagePickerRecycler = view.findViewById<RecyclerView>(R.id.ImagePickerRecycler)
        val btn_pickImage = view.findViewById<Button>(R.id.btnPickImage)
        val Actv_CafeType = view.findViewById<AutoCompleteTextView>(R.id.Actv_CafeType)
        // image picker
        images = ArrayList()
        btn_pickImage.setOnClickListener {
            pickImageIntent()
        }
        // spinner
        val items =
            listOf("کافه", "قهوه فروشی", "کافه باغ", "کافه رستوران", "کافه گیم", "کافه کتاب","کافه سیار")
        val typeList = arrayListOf<String>()
        typeList.add("کافه")
        typeList.add("قهوه فروشی")
        typeList.add("کافه باغ")
        typeList.add("کافه رستوران")
        typeList.add("کافه گیم")
        typeList.add("کافه کتاب")
        typeList.add("کافه سیار")
        val adapter = ArrayAdapter(requireContext(), R.layout.listitem_dropdown_cafetype, typeList)
        Actv_CafeType.setAdapter(adapter)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data!!.clipData != null) {
                    val count = data.clipData!!.itemCount
                    for (i in 0 until count) {
                        val imageUri = data.clipData!!.getItemAt(i).uri
                        images!!.add(imageUri)
                        val adapter = Adapter_ImagePicker(requireContext(), images!!)
                        imagePickerRecycler?.adapter = adapter
                        imagePickerRecycler?.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL , false)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }


    private fun pickImageIntent() {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "select images"), PICK_IMAGE_CODE)
    }
}