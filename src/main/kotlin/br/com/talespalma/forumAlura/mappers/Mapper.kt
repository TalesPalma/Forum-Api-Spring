package br.com.talespalma.forumAlura.mappers

interface Mapper<T,U> {
    fun map(t: T):U
}