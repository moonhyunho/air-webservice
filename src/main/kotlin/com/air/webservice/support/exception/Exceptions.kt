package com.air.webservice.support.exception

import com.air.webservice.support.MessageKey


abstract class ApiException : RuntimeException {
    val messageKey: MessageKey
    val objs: Array<*>

    constructor(messageKey: MessageKey, vararg objs: Any) : super(
        "${messageKey.name}:${objs.joinToString { it.toString() }}"
    ) {
        this.messageKey = messageKey
        this.objs = objs
    }
}

class EntityNotFoundException : ApiException {
    constructor(messageKey: MessageKey, vararg objs: Any) : super(messageKey, *objs)
}

class MethodArgumentInvalidException : ApiException {
    constructor(messageKey: MessageKey, vararg objs: Any) : super(messageKey, *objs)
}