package com.fardragi.nyaruko.exceptions

class NotFoundException(className: String?, id: String?) : Exception("$className not found with id: $id")
