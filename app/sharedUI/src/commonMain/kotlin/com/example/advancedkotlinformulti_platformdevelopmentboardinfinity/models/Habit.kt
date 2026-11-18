package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val name: String,
    val description: String = "",
    val icon: String = "📝",
    val color: String = "#4CAF50",
    val completedDates: List<String> = emptyList(),
    val streak: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val isSynced: Boolean = false
) {
    fun getTodayCompletion(): Boolean {
        val today = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
            .format(Date())
        return completedDates.contains(today)
    }

    fun getCompletionRate(): Double {
        val totalDays = 30 // ბოლო 30 დღე
        val completed = completedDates.filter { date ->
            try {
                val dateObj =
                    java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
                        .parse(date)
                val thirtyDaysAgo = Date(System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000)
                dateObj != null && dateObj.after(thirtyDaysAgo)
            } catch (e: Exception) {
                false
            }
        }.size
        return (completed.toDouble() / totalDays) * 100
    }
}