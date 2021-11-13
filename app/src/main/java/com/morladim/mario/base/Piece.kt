package com.morladim.mario.base

/**
 * 要总结的知识点、想使用的库等的基类
 * @Author 5k5k
 * @Date 2021/11/10-22:04
 */
abstract class Piece(
    val name: String,
    val description: String?,
    val usage: String?,
    val tags: Array<String>?,
    val references: Array<String>?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Piece

        if (name != other.name) return false
        if (description != other.description) return false
        if (usage != other.usage) return false
        if (tags != null) {
            if (other.tags == null) return false
            if (!tags.contentEquals(other.tags)) return false
        } else if (other.tags != null) return false
        if (references != null) {
            if (other.references == null) return false
            if (!references.contentEquals(other.references)) return false
        } else if (other.references != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (usage?.hashCode() ?: 0)
        result = 31 * result + (tags?.contentHashCode() ?: 0)
        result = 31 * result + (references?.contentHashCode() ?: 0)
        return result
    }
}