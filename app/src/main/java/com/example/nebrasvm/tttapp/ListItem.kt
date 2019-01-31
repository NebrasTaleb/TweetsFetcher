package com.example.nebrasvm.tttapp

class ListItem(text: String, image: Int) {
    private var Text: String
    private var Image: Int

    init {
        this.Text = text
        this.Image = image
    }

    fun getText(): String {
        return this.Text
    }

    fun getImage(): Int {
        return this.Image
    }

    fun setText(text: String) {
        this.Text = text
    }

    fun setImage(src: Int) {
        this.Image = src
    }
}