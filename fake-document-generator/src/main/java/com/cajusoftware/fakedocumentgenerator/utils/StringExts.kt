package com.cajusoftware.fakedocumentgenerator.utils

val String.withoutDocumentSymbols: String
    get() = this
        .replace(".", "").replace("-", "")
        .replace("(", "").replace(")", "")
        .replace("/", "").replace(" ", "")
        .replace("*", "")

fun String?.space(): String = "$this "
fun String?.spaceBeforeThat(): String = " $this"