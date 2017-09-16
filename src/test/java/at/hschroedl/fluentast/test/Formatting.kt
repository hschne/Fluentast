package at.hschroedl.fluentast.test


fun String.clean(): String = this.replace("\n\\s*".toRegex(), "")