package com.cajusoftware.fakedocumentgenerator.generators.cpf

import com.cajusoftware.fakedocumentgenerator.generators.FederationUnit
import com.cajusoftware.fakedocumentgenerator.masks.MaskEnum
import com.cajusoftware.fakedocumentgenerator.masks.Mask

interface CpfGenerator {
    fun generateCpf(): String
    suspend fun generateCpfSet(quantity: Int): Set<String>

    class Builder {
        private val cpfGenerator = CpfGeneratorImpl()

        fun withSymbols(value: Boolean) = apply {
            if (value)
                cpfGenerator.mask = Mask(MaskEnum.CPF)
        }

        fun setPrefix(prefix: String) = apply {
            cpfGenerator.prefix = prefix
        }

        fun setSuffix(suffix: String) = apply {
            cpfGenerator.suffix = suffix
        }

        fun setFederationUnit(federationUnit: FederationUnit) = apply {
            cpfGenerator.federationUnit = federationUnit
        }

        fun build() = cpfGenerator as CpfGenerator
    }
}