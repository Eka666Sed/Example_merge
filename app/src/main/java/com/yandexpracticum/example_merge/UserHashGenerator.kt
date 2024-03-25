package com.yandexpracticum.example_merge

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.UUID

internal object UserHashGenerator {

    fun generateHashedUUID(password: String): String {
        val u = UUID.randomUUID()
        val i = password + u.toString()

        val b = i.toByteArray(StandardCharsets.UTF_8)
        val d = MessageDigest.getInstance("MD5")
        val bb = d.digest(b)

        return bytesToHexString(bb)
    }

    private fun bytesToHexString(bytes: ByteArray): String {
        val stringBuilder = StringBuilder()
        for (byte in bytes) {
            stringBuilder.append(String.format("%02x", byte))
        }
        return stringBuilder.toString()
    }

}