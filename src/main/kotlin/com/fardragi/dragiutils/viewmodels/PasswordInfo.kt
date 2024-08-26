package com.fardragi.dragiutils.viewmodels

data class PasswordInfo(val hash: ByteArray, val salt: ByteArray) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as PasswordInfo

    if (!hash.contentEquals(other.hash)) return false
    if (!salt.contentEquals(other.salt)) return false

    return true
  }

  override fun hashCode(): Int {
    var result = hash.contentHashCode()
    result = 31 * result + salt.contentHashCode()
    return result
  }
}
