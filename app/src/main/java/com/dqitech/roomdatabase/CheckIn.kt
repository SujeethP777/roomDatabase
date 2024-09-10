package com.dqitech.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CheckIn")
data class CheckIn(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val days: Long,
)