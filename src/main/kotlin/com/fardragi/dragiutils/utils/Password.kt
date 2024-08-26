package com.fardragi.dragiutils.utils

import com.fardragi.dragiutils.viewmodels.PasswordInfo
import java.security.SecureRandom
import org.bouncycastle.crypto.generators.Argon2BytesGenerator
import org.bouncycastle.crypto.params.Argon2Parameters

class Password {
  companion object {
    fun checkPassword(password: String, hash: ByteArray, salt: ByteArray): Boolean {
      val builder = createBuilder(salt)

      val generator = Argon2BytesGenerator()
      generator.init(builder.build())

      val result = ByteArray(32)
      generator.generateBytes(password.toByteArray(Charsets.UTF_8), result, 0, 32)

      return hash.contentEquals(result)
    }

    fun genPassword(password: String): PasswordInfo {
      val salt = genSalt()

      val builder = createBuilder(salt)

      val generator = Argon2BytesGenerator()
      generator.init(builder.build())

      val result = ByteArray(32)
      generator.generateBytes(password.toByteArray(Charsets.UTF_8), result, 0, 32)

      return PasswordInfo(result, salt)
    }

    private fun createBuilder(salt: ByteArray): Argon2Parameters.Builder {
      return Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
          .withVersion(Argon2Parameters.ARGON2_VERSION_13)
          .withIterations(2)
          .withMemoryAsKB(66536)
          .withParallelism(1)
          .withSalt(salt)
    }

    private fun genSalt(): ByteArray {
      val secureRandom = SecureRandom()
      val salt = ByteArray(16)
      secureRandom.nextBytes(salt)
      return salt
    }
  }
}
