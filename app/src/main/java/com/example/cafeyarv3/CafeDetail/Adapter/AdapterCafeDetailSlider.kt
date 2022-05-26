package com.example.cafeyarv3.CafeDetail.Adapter

import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

/**
 * Created by abolfazl_dv on 13,April,2022
 */
class AdapterCafeDetailSlider : SliderAdapter() {
    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindImageSlide(position: Int, imageSlideViewHolder: ImageSlideViewHolder?) {
        when (position){
            0 -> imageSlideViewHolder?.bindImageSlide("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg")
            1 -> imageSlideViewHolder?.bindImageSlide("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg")
            2 -> imageSlideViewHolder?.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png")
            3 -> imageSlideViewHolder?.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png")
            4 -> imageSlideViewHolder?.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png")
        }
    }

}