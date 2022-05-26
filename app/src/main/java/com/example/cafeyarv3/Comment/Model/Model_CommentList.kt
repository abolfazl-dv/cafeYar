package com.example.cafeyarv3.Comment.Model

import java.util.*

/**
 * Created by abolfazl_dv on 12,May,2022
 */
class Model_CommentList(
    val userImage : Int,
    val userName : String,
    val commentPublishedDate : String,
    val commentText : String,
    val userRated : String,
    val commentPublishedDateText : String
) {
    val commentID = UUID.randomUUID().toString()
}